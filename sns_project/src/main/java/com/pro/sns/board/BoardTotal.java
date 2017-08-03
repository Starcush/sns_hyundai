package com.pro.sns.board;

import java.util.ArrayList;

import com.pro.sns.boardRep.BoardRep;

public class BoardTotal {
	private Board board;
	private ArrayList<BoardRep> replist;
	
	public BoardTotal(Board board, ArrayList<BoardRep> replist) {
		super();
		this.board = board;
		this.replist = replist;
	}

	public BoardTotal() {
		super();
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ArrayList<BoardRep> getReplist() {
		return replist;
	}

	public void setReplist(ArrayList<BoardRep> replist) {
		this.replist = replist;
	}

	@Override
	public String toString() {
		return "BoardTotal [board=" + board + ", replist=" + replist + "]";
	}
	
	
	
	

	

}
