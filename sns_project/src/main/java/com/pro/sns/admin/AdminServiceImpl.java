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

}
