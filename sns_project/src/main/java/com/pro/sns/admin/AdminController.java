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
	@RequestMapping(value="/admin/reportListByNum.do")
	public ModelAndView reportListByNum(@RequestParam(value="board_num") int board_num) {
		ModelAndView mv = new ModelAndView("admin/allReportRequest");
		ArrayList<Report> rList = aService.reportList();
		ArrayList<Report> ListByNum = aService.reportListByNum(board_num);
		System.out.println("board_num : "+board_num);
		mv.addObject("rList", rList);
		mv.addObject("ListByNum", ListByNum);
		System.out.println("ListByNum : "+ListByNum);
		System.out.println("mv : "+mv);
		return mv;
	}
	@RequestMapping(value="/admin/restrictionMember.do")
	public ModelAndView restrictionMember(Report r, Ban ban, @RequestParam(value="id") String id) {
		ModelAndView mv = new ModelAndView("admin/allReportRequest");
		ArrayList<Report> rList = aService.reportList();
		mv.addObject("rList", rList);
//		Member m = aService.selectMember(id);
		System.out.println("id : "+id);
//		System.out.println("m before : "+m);
		aService.restrictionMember(id);
//		System.out.println("m after : "+m);
		System.out.println("id 2 : "+id);
		aService.restrictionComment(r);
		System.out.println("report r :"+r);
		String start_date = aService.sysDate();
		System.out.println("start_date : "+start_date);
		String end_date = aService.endDate();
		System.out.println("end_date : "+end_date);
		ban.setId(id);
		System.out.println("id 3 : "+id);
		ban.setStart_date(start_date);
		ban.setEnd_date(end_date);
		aService.ban(ban);
		System.out.println("ban : "+ban);
		return mv;
	}
//	@RequestMapping(value="/admin/restrictionComment.do")
//	public String restrictionComment(Report r, Ban ban, @RequestParam(value="id") String id) {
//		System.out.println("id 2 : "+id);
//		aService.restrictionComment(r);
//		System.out.println("report r :"+r);
//		String start_date = aService.sysDate();
//		System.out.println("start_date : "+start_date);
//		String end_date = aService.endDate();
//		System.out.println("end_date : "+end_date);
//		ban.setId(id);
//		System.out.println("id 3 : "+id);
//		ban.setStart_date(start_date);
//		ban.setEnd_date(end_date);
//		aService.ban(ban);
//		System.out.println("ban : "+ban);
//		return "admin/allReportRequest";
//	}
	
	@RequestMapping(value="/admin/restrictionComment.do")
	public String restrictionComment(@RequestParam(value="id") String id, @RequestParam(value="num") int num, Report r) {
		//id는 sns_ban 테이블에서 어떤 아이디에 제재를 해줄지 넣어주기 위해서 필요
		//num은 sns_report테이블에서 어떤 내용을 update해줘야 하는지 결정해줘야 한다.
//		Report r = new Report();
		Ban b = new Ban();
		
		String start_date = aService.sysDate();
		String end_date = aService.endDate();
		b.setId(id);
		b.setStart_date(start_date);
		b.setEnd_date(end_date);
		aService.ban(b);
		System.out.println("Ban : "+b);
		
		r.setNum(num);
		r.setRequest_completed_date(start_date);
		aService.restrictionComment(r);
		System.out.println("comment : "+r.getAdmin_response_comment());
		
		return "admin/allReportRequest";
	}
	@RequestMapping(value="/admin/ban.do")
	public String ban(Ban ban){
		String start_date = aService.sysDate();
		String end_date = aService.endDate();
		ban.setStart_date(start_date);
		ban.setEnd_date(end_date);
		aService.ban(ban);
		return "admin/allReportRequest";
	}
}