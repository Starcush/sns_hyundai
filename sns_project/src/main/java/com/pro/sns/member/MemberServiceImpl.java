package com.pro.sns.member;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	private MemberDaoMapper dao;

	@Override
	public void memberJoin(Member m) {
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		dao.memberInsert(m);
	}

	@Override
	public boolean idcheck(String id) {
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		Member m = dao.selectMember(id);
		if (m != null) {// 사용불가
			return false;
		}
		return true;
	}

	@Override
	public Member getMemberById(String id) {
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		return dao.selectMember(id);
	}

	@Override
	public void outMember(String id) {
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		dao.deleteMember(id);
	}

	@Override
	public ArrayList<Member> getAllMemberForAdmin() {
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		return dao.selectAllMember();
	}

	@Override
	public void modifyMember(Member m) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		dao.updateMember(m);
	}
	//-------------------------------------------------------07.26
	@Override
	public ArrayList<Block> getMyBlockList(String id) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		return dao.myBlockList(id);
	}
	
//	@Override
//	public int blockMakeNum() {
//		// TODO Auto-generated method stub
//		dao = sqlSession.getMapper(MemberDaoMapper.class);
//		return dao.blockMakeNum();
//	}

	@Override
	public void blockInsert(Block b) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		dao.blockInsert(b);
	}

	@Override
	public void blockDelete(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(MemberDaoMapper.class);
		dao.blockDelete(num);
	}

}// class
