package com.pro.sns.board;

import java.sql.Date;
import java.util.ArrayList;

import com.pro.sns.boardRep.BoardRep;

public interface BoardDaoMapper {

	// ��� �Խù� ���(�α�������������)
	ArrayList<Board> boardSelectAllLoginUserOnly(String id);

	// ��� �Խù� ���(�α��� x)
	ArrayList<Board> boardSelectAllNoLoginUserOnly();
	
	//�������޾ƿ���
	int boardMakeNum();
	
	// �Խù��ۼ�(������ ��������ȣ�� ������̺����� insert��)
	void boardInsert(Board b);
	void boardInsert_backup(Board b);

	//-------------------------�ѹ��̻� ����------------------------------------------------
	


	// num������ �Խù��޾ƿ�
	Board selectByNum(int num);

	/**
	 * id������ (writer�� member�� id�� �ɵ�) �Խù����� �޾ƿ� �Ƹ��� �Ű����ÿ��� ���ϰŰ���
	 * 
	 * @param id
	 * @return
	 */
	Board selectById(String id);

	/**
	 * name���� �Խù����� �޾ƿ� �Ű����ÿ��� ��������?
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