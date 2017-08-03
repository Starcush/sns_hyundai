package com.pro.sns.board;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.pro.sns.boardRep.BoardRep;
import com.pro.sns.boardRep.BoardRepDaoMapper;
import com.pro.sns.member.Member;

@Component("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name = "sqlSession")
	private SqlSession  sqlSession;
	
	private BoardDaoMapper dao;
	private BoardRepDaoMapper dao_rep;

	@Override
	public ArrayList<BoardTotal> getAllBoardLoginUserOnly(String id) {
		/**
		 * 이 메서드는 특정사용자가 로그인했을때 그 사용자에 맞는 조건으로 모든 게시물과 댓글을 출력해준다
		 * 게시물 조건
		 * 1. 나의 친구이면서 비공개가 아닌 모든 글(친구,전체공개)
		 * 2. 나의 친구가 아니면서 비공개를 제외하고, 친구공개도 제외한 전체글(type이 2인)것만 보여준다(나는 나자신과 친구가 아니므로 나를 포함함)
		 * 3. 그리고 나의 모든글까지 포함해야한다
		 * 4. 내가 차단한 상대의 게시물도 제외한다
		 * 댓글 조건
		 * 5. 게시물의 작성자(writer)가 컨트롤러에서 받아온 세션id값과 일치한다면 (내글이라면) boardRepSelectAllLoginUserOnly_myBoard 호출
		 *   그렇지 않다면 boardRepSelectAllLoginUserOnly 호출
		 */
		System.out.println("세션id값 : " + id);
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao_rep = sqlSession.getMapper(BoardRepDaoMapper.class);
		
		//게시물과 회원정보중일부(프로필이미지)와 댓글 전부 받아줄 ArrayList
		ArrayList<BoardTotal> totalList = new ArrayList<BoardTotal>();
		
		BoardTotal boardTotal;
		
		ArrayList<Board> boardList = dao.boardSelectAllLoginUserOnly(id);//Member와 Board정보 담겨있음
		
		System.out.println(boardList);
		ArrayList<BoardRep> boardRepList_my;
		ArrayList<BoardRep> boardRepList;
		
		for(int i = 0; i < boardList.size(); i ++){
			Board b = boardList.get(i);
			
			//게시물은 조건에 맞게 받아왔지만, 그중에서 게시물이 내가 쓴 글인지 아닌지에 따라서 보여지는 댓글이 달라져야함 
			if(b.getWriter().equals(id)){//작성자가 컨트롤러에서 받아온 세션정보(id)와 일치한다면 내가 쓴 글임
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("num", b.getNum());
				map.put("writer", b.getWriter());
				boardRepList_my = dao_rep.boardRepSelectAllLoginUserOnly_myBoard(map);
				boardTotal = new BoardTotal(b, boardRepList_my);
				System.out.println(boardTotal);
				
			}else{//내글은 아님
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("num", b.getNum());
				map.put("writer", b.getWriter());
				boardRepList = dao_rep.boardRepSelectAllLoginUserOnly(map);
				boardTotal = new BoardTotal(b, boardRepList);
				System.out.println(boardTotal);
			}
			totalList.add(boardTotal);
		}
		return totalList;
	}

	@Override
	public ArrayList<BoardTotal> getAllBoardNoLoginUserOnly() {
		// TODO Auto-generated method stub
		//게시물과 댓글 전부 받아줄 arraylist
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao_rep = sqlSession.getMapper(BoardRepDaoMapper.class);
		System.out.println("비회원 접속시 getAllBoardNoLoginUserOnly 메서드 호출!");
		//게시물과 회원정보중일부(프로필이미지)와 댓글 전부 받아줄 ArrayList
		ArrayList<BoardTotal> totalList = new ArrayList<BoardTotal>();
		BoardTotal boardTotal;
		
		ArrayList<Board> boardList = dao.boardSelectAllNoLoginUserOnly();//담겨있음
		
		System.out.println(boardList);
		System.out.println(boardList.size());
	
		ArrayList<BoardRep> boardRepList;
		for(int i = 0; i < boardList.size(); i ++){
			Board board = boardList.get(i);
			boardRepList = dao_rep.boardRepSelectAllNoLoginUserOnly(board.getNum());
			boardTotal = new BoardTotal(board, boardRepList);
			System.out.println(boardTotal);
			totalList.add(boardTotal);
		}
		return totalList;
	}

	@Override
	public int boardMakeNum() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.boardMakeNum();
	}

	@Override
	public void boardInsert(Board b) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao.boardInsert(b);
		dao.boardInsert_backup(b);
	}

	@Override
	public Board selectByNum(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.selectByNum(num);
	}

	@Override
	public Board selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoardByNum(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao.deleteBoardByNum(num);
	}

	@Override
	public void boardUpdate(Board b) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao.boardUpdate(b);
		dao.boardUpdate_backup(b);
	}

	@Override
	public int boardRepMakeNum() {
		// TODO Auto-generated method stub
		dao_rep = sqlSession.getMapper(BoardRepDaoMapper.class);
		return dao_rep.boardRepMakeNum();
	}

	@Override
	public void boardRepInsert(BoardRep br) {
		// TODO Auto-generated method stub
		dao_rep = sqlSession.getMapper(BoardRepDaoMapper.class);
		dao_rep.boardRepInsert(br);
		dao_rep.boardRepInsert_backup(br);
	}

	@Override
	public BoardRep selectByRepNum(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.selectByRepNum(num);
	}

	@Override
	public String sysDate() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.sysDate();
	}

	@Override
	public void reportInsert(Report r) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		dao.reportInsert(r);
	}

	@Override
	public int reportMakeNum() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.reportMakeNum();
	}

	@Override
	public ArrayList<Report> reportList(String reporter) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.reportList(reporter);
	}

	@Override
	public boolean reportCheck(int board_num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		Report r = dao.selectByBoard_Num(board_num);
		System.out.println(r);
		if (r != null) {// 사용불가
			return false;
		}
		return true;
	}

	@Override
	public Report selectByBoard_Num(int board_num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(BoardDaoMapper.class);
		return dao.selectByBoard_Num(board_num);
	}


}
