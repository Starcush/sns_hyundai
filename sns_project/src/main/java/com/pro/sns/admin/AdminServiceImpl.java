package com.pro.sns.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.pro.sns.board.Report;
import com.pro.sns.member.Member;
import com.pro.sns.member.MemberDaoMapper;
@Component("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private AdminDaoMapper dao;
	@Override
	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.selectAllMember();
	}
	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		dao.deleteMember(id);
	}
	@Override
	public ArrayList<Report> reportList() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.reportList();
	}
	@Override
	public ArrayList<Report> reportListByNum(int board_num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.reportListByNum(board_num);
	}
	@Override
	public void restrictionMember(String id) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		dao.restrictionMember(id);
	}
	@Override
	public Member selectMember(String id) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.selectMember(id);
	}
	@Override
	public void restrictionComment(Report r) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		dao.restrictionComment(r);
	}
	@Override
	public void ban(Ban ban) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		dao.ban(ban);
	}
	@Override
	public String sysDate() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.sysDate();
	}
	@Override
	public String endDate() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(AdminDaoMapper.class);
		return dao.endDate();
	}
}
