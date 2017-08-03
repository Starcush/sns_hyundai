package com.pro.sns.boardRep;

import java.util.ArrayList;
import java.util.HashMap;

import com.pro.sns.board.Board;

public interface BoardRepDaoMapper {
	//로그인했을경우 내가 안쓴 글의 댓글출력
	ArrayList<BoardRep> boardRepSelectAllLoginUserOnly(HashMap<String, Object> map); 
	
	//로그인했을경우 내가 쓴 글의 댓글출력
	ArrayList<BoardRep> boardRepSelectAllLoginUserOnly_myBoard(HashMap<String,Object>map);
	
	//로그인하지않았을경우의 댓글출력
	ArrayList<BoardRep> boardRepSelectAllNoLoginUserOnly(int boardNum);
	
	int boardRepMakeNum();
	
	void boardRepInsert(BoardRep br);
	
	void boardRepInsert_backup(BoardRep br);
	
	
}

