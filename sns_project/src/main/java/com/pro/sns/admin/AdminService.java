package com.pro.sns.admin;

import java.util.ArrayList;

import com.pro.sns.board.Report;
import com.pro.sns.member.Member;

public interface AdminService {
	ArrayList<Member> selectAllMember();
	void deleteMember(String id);
	ArrayList<Report> reportList();
	ArrayList<Report> reportListByNum(int board_num);
	void restrictionMember(String id);
	Member selectMember(String id);
	void restrictionComment(Report r);
	void ban(Ban ban);
	String sysDate();
	String endDate();
}
