package com.pro.sns.board;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pro.sns.boardRep.BoardRep;
import com.pro.sns.member.Member;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService bService;
	
	@RequestMapping(value = "/board/writeForm.do")
	public String writeFormGo(){
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/board/write.do")
	public String write(Board b){
		
		int numberForPrimaryImage = bService.boardMakeNum();
		String fileName = b.getFile().getOriginalFilename();
		String path = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\board_img\\";
		File file = new File(path + numberForPrimaryImage + fileName);
		
		try {
			b.getFile().transferTo(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		b.setNum(numberForPrimaryImage);
		b.setPath(numberForPrimaryImage+fileName);
		bService.boardInsert(b);
		return "redirect:/board/totalListLoginUserOnly.do";
	}

	@RequestMapping(value = "/board/totalListLoginUserOnly.do")
	public ModelAndView totalPrintToIndexLoginUserOnly(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member m = (Member) session.getAttribute("member");
		ModelAndView mv = new ModelAndView("member/index");
		ArrayList<BoardTotal> totalListForLoginUser = bService.getAllBoardLoginUserOnly(m.getId());
		mv.addObject("totalList_login", totalListForLoginUser);
		//사실 여기서 비회원도 처리할수 있지만,  member/index.jsp에서 JSTL로 처리해봤음
		return mv;
	}
	
	@RequestMapping(value = "/board/totalList.do")
	public ModelAndView totalPrintToIndexNoLoginUser(){
		ModelAndView mv = new ModelAndView("member/index");
		ArrayList<BoardTotal> totalListForNoLoginUser  = bService.getAllBoardNoLoginUserOnly();
		mv.addObject("totalList_noLogin", totalListForNoLoginUser);
		return mv;
	}
	@RequestMapping(value = "/board/editForm.do")
	public ModelAndView editFormGo(@RequestParam(value = "num") int num){
		ModelAndView mv = new ModelAndView("board/boardEdit");
		Board board = bService.selectByNum(num);
		mv.addObject("board", board);
		System.out.println(board);
		return mv;
	}
	@RequestMapping(value = "/board/update.do")
	public String boardUpdate(Board b){
		System.out.println(b);
		int numberForPrimaryImage = bService.boardMakeNum();
		String fileName = b.getFile().getOriginalFilename();
		String path = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\board_img\\";
		File file = new File(path + numberForPrimaryImage + fileName);
		
		try {
			b.getFile().transferTo(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		b.setPath(numberForPrimaryImage+fileName);
		
			bService.boardUpdate(b);
		return "redirect:/board/totalListLoginUserOnly.do";
	}
	@RequestMapping(value="/board/delete.do")
	public String boardDelete(@RequestParam(value="num") int num) {
		bService.deleteBoardByNum(num);
		return "redirect:/board/totalListLoginUserOnly.do";
	}
	@RequestMapping(value="/board/writeRep.do")
	public String boardRepInsert(BoardRep br) {
		int num = bService.boardRepMakeNum();
		br.setNum(num);
		bService.boardRepInsert(br);
		return "redirect:/board/totalListLoginUserOnly.do";
	}
	@RequestMapping(value="/board/report.do")
	public String reportInsert(Report r) {
		int num = bService.reportMakeNum();
		int board_num = r.getBoard_num();
		Report r1 = bService.selectByBoard_Num(board_num);
		System.out.println("board 1 : "+r);
		String view = "";
		if(r1 != null) {
			view ="redirect:/board/totalListLoginUserOnly.do"; 
		} else {
			r.setNum(num);
			r.setReport_date(bService.sysDate());
			bService.reportInsert(r);
			view ="redirect:/board/totalListLoginUserOnly.do"; 
		}
		
		return view;
	}
	@RequestMapping(value="/board/reportList.do")
	public ModelAndView reportList(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member m = (Member) session.getAttribute("member");
		ModelAndView mv = new ModelAndView("member/report");
		ArrayList<Report> reportList = bService.reportList(m.getId());
		System.out.println("member : "+m);
		System.out.println("reportList : "+reportList);
		mv.addObject("reportList", reportList);
		//사실 여기서 비회원도 처리할수 있지만,  member/index.jsp에서 JSTL로 처리해봤음
		return mv;
	}
	@RequestMapping(value = "/board/reportCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView reportCheck(@RequestParam(value = "num") int board_num) {
		ModelAndView mv = new ModelAndView("board/reportcheck");
		System.out.println("num 1 : "+board_num);
		if (bService.reportCheck(board_num) == true) {
			mv.addObject("result", "신고완료");
		} else if (bService.reportCheck(board_num) == false) {
			mv.addObject("result", "이미 신고된 게시물입니다.");
		}
		System.out.println("num 2 : "+board_num);
		System.out.println("mv : "+mv);
		return mv;
		
	}
}
