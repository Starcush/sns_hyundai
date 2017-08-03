package com.pro.sns.member;

import java.util.ArrayList;

public interface MemberService {
	
	//--------------------한번이라도 쓴 메서드 ---------------
	void modifyMember(Member m);
	void memberJoin(Member m);
	boolean idcheck(String id);
	Member getMemberById(String id);//이 메서드를 통해서 정보확인, 로그인 둘다 할수 있음
	void outMember(String id);
	
	ArrayList<Block> getMyBlockList(String id);
//	int blockMakeNum();
	void blockInsert(Block b);
	void blockDelete(int num);
	//------------------------------------------------------
	

	ArrayList<Member> getAllMemberForAdmin();//관리자가 모든 회원정보 볼때 사용
	
	
	

	
}
