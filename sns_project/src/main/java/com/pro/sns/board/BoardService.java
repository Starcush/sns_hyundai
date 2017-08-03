package com.pro.sns.board;

import java.sql.Date;
import java.util.ArrayList;

import com.pro.sns.boardRep.BoardRep;

public interface BoardService {
	//모든 게시물과 그에 매칭되는 모든 댓글을 뿌려주는 메서드(로그인유저)
	ArrayList<BoardTotal> getAllBoardLoginUserOnly(String id);
	
	ArrayList<BoardTotal> getAllBoardNoLoginUserOnly();

	//-------------------------한번이상 사용됨------------------------------------------------
	
	//시퀀스받아오기
	int boardMakeNum();
	
	// 게시물작성
	void boardInsert(Board b);
	
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
	
			
			int boardRepMakeNum();
			
			void boardRepInsert(BoardRep br);
			
			BoardRep selectByRepNum(int num);
			String sysDate();
			void reportInsert(Report r);
			int reportMakeNum();
			ArrayList<Report> reportList(String reporter);
			boolean reportCheck(int board_num);
			Report selectByBoard_Num(int board_num);
}
