package com.pro.sns.member;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.sns.validator.MemberValidator;

@Controller
public class MemberController {
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	private MemberDaoMapper dao;
	@Resource(name = "memberService")
	private MemberService mService;

	@RequestMapping(value = "/member/loginPage.do")
	public String loginForm() {
		return "member/login";
	}

	@RequestMapping(value = "/member/joinForm.do")
	public String joinForm() {
		return "member/join";
	}

	@RequestMapping(value = "/member/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/board/totalList.do";
	}

	@RequestMapping(value = "/member/out.do")
	public String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member member = (Member) session.getAttribute("member");
		
		String path = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\member_img\\"
				+ member.getImg();
		File file = new File(path);
		file.delete();
		
		String id = member.getId();
		mService.outMember(id);
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/board/totalList.do";
	}

	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest req) {
		System.out.println("login called");
		ModelAndView mv = new ModelAndView();

		if (mService.getMemberById(id) != null && mService.getMemberById(id).getPwd().equals(pwd)) {
			if (mService.getMemberById(id).getIsban().equals("f")) {
				mv.setViewName("redirect:/board/totalListLoginUserOnly.do");
				HttpSession session = req.getSession();
				session.setAttribute("member", mService.getMemberById(id));
			} else {
				mv.addObject("member", mService.getMemberById(id));
				mv.setViewName("member/loginFail");
			}
		} else {
			mv.setViewName("member/loginFail");
		}

		return mv;
	}

	@RequestMapping(value = "/member/idCheck.do")
	public ModelAndView idcheck(@RequestParam(value = "id") String id) {
		ModelAndView mv = new ModelAndView("member/idcheck");
		if (mService.idcheck(id) == true) {
			mv.addObject("result", "사용가능");
		} else if (mService.idcheck(id) == false) {
			mv.addObject("result", "사용불가");
		}
		return mv;
	}

	@RequestMapping(value = "/member/join.do")
	public String join(@ModelAttribute("member") Member m, BindingResult result) {
		// 사용자가 어떤 이미지명을 올리던간에 등록한 id값과 일치하게 해줘야한다

		new MemberValidator().validate(m, result);
		
		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
			System.out.println(result);
			return "member/join";
		}

		String path = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\member_img\\";
		
		
		String fileName = m.getFile().getOriginalFilename();
		File oldFile = new File(path + fileName);
		File newFile = new File(path + m.getId() + ".jpg");
		oldFile.renameTo(newFile);
		try {
			m.getFile().transferTo(newFile);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		m.setImg(m.getId() + ".jpg");
		mService.memberJoin(m);

		return "redirect:/board/totalList.do";
	}

	// searchForEdit
	@RequestMapping(value = "/member/searchForModify.do")
	public ModelAndView searchForModify(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member m = (Member) session.getAttribute("member");
		ModelAndView mv = new ModelAndView("member/modify");
		mv.addObject("memupdate", m);
		return mv;
	}

	@RequestMapping(value = "/member/modify.do")
	public String modify(Member m, HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		Member m1 = (Member)session.getAttribute("member");

		String oldPath = m1.getImg();
		File selectedDir = new File(oldPath);
		selectedDir.delete();// 지워진다

		String newPath = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\member_img\\";		
		String fileName = m.getFile().getOriginalFilename();
		File oldFile = new File(newPath + fileName);
		File newFile = new File(newPath + m.getId() + ".jpg");
		oldFile.renameTo(newFile);
		
		try {
			m.getFile().transferTo(newFile);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(m.getFile().isEmpty()) {
			m.setImg("no_profile.jpg");
			
		} else {
			m.setImg(m.getId() + ".jpg");
			
		}
		session.setAttribute("member", m);		
		mService.modifyMember(m);

		return "redirect:/board/totalListLoginUserOnly.do";
	}
	
	//-----------------------------------------------    07.26
	@RequestMapping(value = "/member/myBlockList.do")
	public ModelAndView myBlockList(HttpServletRequest req) {
		
		ModelAndView mv = new ModelAndView("member/block");
		HttpSession session = req.getSession(false);
		ArrayList<Block> blockList = new ArrayList<Block>();
		
		Member member = (Member)session.getAttribute("member");
		System.out.println("member : "+member);
		
		String id = member.getId();
		System.out.println("id : "+id);
		
		blockList = mService.getMyBlockList(id);
		System.out.println("blockList : "+blockList);
		mv.addObject("blockList", blockList);
		return mv;
	}
	
	
	@RequestMapping(value="/member/block.do") //blockInsert 차단목록에 추가
	public String block(@RequestParam(value="target") String target, HttpServletRequest req) {
		//block table에는 상대방의 아이디만 가져가면 된다.
		HttpSession session = req.getSession(false);
		Block block = new Block();
		
		Member m = (Member)session.getAttribute("member");
//		block.setNum(mService.blockMakeNum());
		block.setRequester(m.getId());
		block.setTarget(target);
		System.out.println("target : "+target);
		
		mService.blockInsert(block);
		return "redirect:/board/totalListLoginUserOnly.do";
		
	}
	
	@RequestMapping(value="/member/unblock.do") //차단목록 삭제
	public String unblock(@RequestParam(value="num") int num) {
//		세션 유지를 해줘야 하나??
//		HttpSession session = req.getSession(false);
		mService.blockDelete(num);
		return "redirect:/member/myBlockList.do";
	}
	
	//----------------------------------------------------------------------
	
	@RequestMapping(value = "/member/myFriends.do")
	public String myFriends(){
		return "member/friends";
	}
	
	@RequestMapping(value = "/member/myReport.do")
	public String myReport(){
		return "member/report";
	}
	
}
