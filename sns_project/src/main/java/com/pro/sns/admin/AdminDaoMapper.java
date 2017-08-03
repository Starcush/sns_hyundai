package com.pro.sns.admin;

import java.util.ArrayList;

import com.pro.sns.board.Report;
import com.pro.sns.member.Member;

public interface AdminDaoMapper {
	/**
	 * 모든 회원 정보 보기 AdminController쪽에서 호출될듯
	 * @return
	 */
	ArrayList<Member> selectAllMember();
	void deleteMember(String id);
	ArrayList<Report> reportList();
}
