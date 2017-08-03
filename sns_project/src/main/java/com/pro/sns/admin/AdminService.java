package com.pro.sns.admin;

import java.util.ArrayList;

import com.pro.sns.board.Report;
import com.pro.sns.member.Member;

public interface AdminService {
	ArrayList<Member> selectAllMember();
	void deleteMember(String id);
	ArrayList<Report> reportList();
}
