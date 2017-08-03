package com.pro.sns.board;

import java.sql.Date;
import java.util.ArrayList;

import com.pro.sns.boardRep.BoardRep;

public interface BoardService {
	//��� �Խù��� �׿� ��Ī�Ǵ� ��� ����� �ѷ��ִ� �޼���(�α�������)
	ArrayList<BoardTotal> getAllBoardLoginUserOnly(String id);
	
	ArrayList<BoardTotal> getAllBoardNoLoginUserOnly();

	//-------------------------�ѹ��̻� ����------------------------------------------------
	
	//�������޾ƿ���
	int boardMakeNum();
	
	// �Խù��ۼ�
	void boardInsert(Board b);
	
	// num������ �Խù��޾ƿ�
			Board selectByNum(int num);

			/**
			 * id������ (writer�� member�� id�� �ɵ�) �Խù����� �޾ƿ� �Ƹ��� �Ű���ÿ��� ���ϰŰ���
			 * 
			 * @param id
			 * @return
			 */
			Board selectById(String id);

			/**
			 * name���� �Խù����� �޾ƿ� �Ű���ÿ��� ��������?
			 * 
			 * @param name
			 * @return
			 */
			Board selectByName(String name);

			/**
			 * �Խù� �ۼ��ڰ� �ڱ� �� ���ﶧ ����Ҽ� ����
			 * 
			 * @param num
			 */
			void deleteBoardByNum(int num);

			/**
			 * �Խù� ����
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
