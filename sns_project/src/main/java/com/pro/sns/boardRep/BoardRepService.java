package com.pro.sns.boardRep;

import java.util.ArrayList;
import java.util.HashMap;

import com.pro.sns.board.Board;

public interface BoardRepService {
	//�α���������� ���� �Ⱦ� ���� ������
		ArrayList<BoardRep> boardRepSelectAllLoginUserOnly(HashMap<String, Object> map); 
		
		//�α���������� ���� �� ���� ������
		ArrayList<BoardRep> boardRepSelectAllLoginUserOnly_myBoard(HashMap<String,Object>map);
		
		//�α��������ʾ�������� ������
		ArrayList<BoardRep> boardRepSelectAllNoLoginUserOnly(int boardNum);
	int boardRepMakeNum();
	
	void boardRepInsert(BoardRep br);
	
}