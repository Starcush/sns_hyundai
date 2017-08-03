package com.pro.sns.boardRep;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.pro.sns.board.BoardDaoMapper;

public class BoardRepServiceImpl implements BoardRepService{
	@Resource(name = "sqlSession")
	private SqlSession  sqlSession;
	
	private BoardDaoMapper dao;
	private BoardRepDaoMapper dao_rep;
	@Override
	public ArrayList<BoardRep> boardRepSelectAllLoginUserOnly(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardRep> boardRepSelectAllLoginUserOnly_myBoard(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardRep> boardRepSelectAllNoLoginUserOnly(int boardNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardRepMakeNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void boardRepInsert(BoardRep br) {
		// TODO Auto-generated method stub
		dao_rep = sqlSession.getMapper(BoardRepDaoMapper.class);
		dao_rep.boardRepInsert(br);
		dao_rep.boardRepInsert_backup(br);
	}

	

	

}
