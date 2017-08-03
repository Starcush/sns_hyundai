package com.pro.sns.boardRep;

import java.sql.Date;

public class BoardRep {
	private int num;
	private String writer;
	private String content;
	private String board_rep_date;
	private int board_num;
	private int type;

	public BoardRep() {
		super();
	}

	public BoardRep(int num, String writer, String content, String board_rep_date, int board_num, int type) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.board_rep_date = board_rep_date;
		this.board_num = board_num;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoard_rep_date() {
		return board_rep_date;
	}

	public void setBoard_rep_date(String board_rep_date) {
		this.board_rep_date = board_rep_date;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BoardRep [num=" + num + ", writer=" + writer + ", content=" + content + ", board_rep_date="
				+ board_rep_date + ", board_num=" + board_num + ", type=" + type + "]";
	}

	
	
}
