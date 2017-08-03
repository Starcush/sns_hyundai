package com.pro.sns.member;

import java.util.ArrayList;

public interface MemberDaoMapper {
	//-----------이 안에 있는 메서드들은 한번이상 호출되서 쓰이고 있음---------------------
	void memberInsert(Member m);// 회원가입
	//-----------이 안에 있는 메서드들은 한번이상 호출되서 쓰이고 있음---------------------
	Member selectMember(String id);// 아이디로 검색한다. 로그인, 아이디중복체크, 내정보보기.. 
	void deleteMember(String id);//탈퇴
	void updateMember(Member m);//정보수정
	ArrayList<Member> selectAllMember();
	
	ArrayList<Block> myBlockList(String id); //해당하는 아이디에 대해서(request) target을 가져와야한다
//	int blockMakeNum();
	void blockInsert(Block b); //block을 하는 메서드
	void blockDelete(int num); //block을 해제해주는 메서드
}
