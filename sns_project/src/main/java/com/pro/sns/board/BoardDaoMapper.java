package com.pro.sns.board;

import java.sql.Date;
import java.util.ArrayList;

import com.pro.sns.boardRep.BoardRep;

public interface BoardDaoMapper {

	// 모든 게시물 출력(로그인했을때전용)
	ArrayList<Board> boardSelectAllLoginUserOnly(String id);

	// 모든 게시물 출력(로그인 x)
	ArrayList<Board> boardSelectAllNoLoginUserOnly();
	
	//시퀀스받아오기
	int boardMakeNum();
	
	// 게시물작성(동일한 시퀀스번호로 백업테이블에도 insert됨)
	void boardInsert(Board b);
	void boardInsert_backup(Board b);

	//-------------------------한번이상 사용됨------------------------------------------------
	


	// num값으로 게시물받아옴
	Board selectByNum(int num);

	/**
	 * id값으로 (writer나 member의 id가 될듯) 게시물정보 받아옴 아마도 신고관련에서 쓰일거같다
	 * 
	 * @param id
	 * @return
	 */
	Board selectById(String id);

	/**
	 * name으로 게시물정보 받아옴 신고관련에서 쓰일지도?
	 * 
	 * @param name
	 * @return
	 */
	Board selectByName(String name);

	/**
	 * 게시물 작성자가 자기 글 지울때 사용할수 있음
	 * 
	 * @param num
	 */
	void deleteBoardByNum(int num);

	/**
	 * 게시물 수정
	 * 
	 * @param b
	 */
	void boardUpdate(Board b);
	void boardUpdate_backup(Board b);
	int boardRepMakeNum();
	
	
	void boardRepInsert(BoardRep br);
	void boardRepInsert_backup(BoardRep br);
	BoardRep selectByRepNum(int num);
	String sysDate();
	int reportMakeNum();
	void reportInsert(Report r);
	ArrayList<Report> reportList(String reporter);
	Report selectByBoard_Num(int board_num);
}
