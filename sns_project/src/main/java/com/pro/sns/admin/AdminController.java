package com.pro.sns.admin;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.sns.board.Report;
import com.pro.sns.member.Member;


@Controller
public class AdminController {
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "adminService")
	private AdminService aService;
	
	@RequestMapping(value = "/admin/allMemberList.do")
	public String allMemberList(){
		return "admin/memberList";
	}
	
	@RequestMapping(value = "/admin/allReportRequestList.do")
	public String allReportRequestList(){
		return "admin/allReportRequest";
	}
	
	@RequestMapping(value = "/admin/banMemberList.do")
	public String banMemberList(){
		return "admin/banMemberList";
	}
	@RequestMapping(value="/admin/MemberList.do")
	public ModelAndView selectAllMember(){
		ModelAndView mv = new ModelAndView("admin/memberList");
		ArrayList<Member> list = (ArrayList<Member>)aService.selectAllMember();
		System.out.println("list : "+list);
		mv.addObject("list", list);
		System.out.println("mv : "+mv);
		return mv;
	}
	@RequestMapping(value="/admin/deleteMember.do")
	public String deleteMember(@RequestParam(value="id") String id) {
		String path = "C:\\dw89z_SNS_V2\\sns_project\\src\\main\\webapp\\resources\\images\\member_img\\"
				+ id;
		File file = new File(path);
		file.delete();
		System.out.println("id : "+id);
		aService.deleteMember(id);
		return "redirect:/admin/MemberList.do";
	}
	@RequestMapping(value="/admin/reportList.do")
	public ModelAndView reportList() {
		ModelAndView mv = new ModelAndView("admin/allReportRequest");
		ArrayList<Report> rList = aService.reportList();
		System.out.println("rList : "+rList);
		mv.addObject("rList", rList);
		System.out.println("mv 1 : "+mv);
		return mv;
	}
}
