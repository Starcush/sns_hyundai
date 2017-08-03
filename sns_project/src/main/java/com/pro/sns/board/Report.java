package com.pro.sns.board;

import java.sql.Date;

import com.pro.sns.boardRep.BoardRep;
import com.pro.sns.member.Member;

public class Report {
	private int num;
	private String reporter;
	private String target;
	private String report_date;
	private String admin_response_comment;
	private String request_completed_date;
	private int board_num;
	private int board_rep_num;
	private Member member;
	private Board board;
	private BoardRep boardRep;
	public Report() {
		super();
	}
	public Report(int num, String reporter, String target, String report_date, String admin_response_comment,
			String request_completed_date, int board_num, int board_rep_num, Member member, Board board,
			BoardRep boardRep) {
		super();
		this.num = num;
		this.reporter = reporter;
		this.target = target;
		this.report_date = report_date;
		this.admin_response_comment = admin_response_comment;
		this.request_completed_date = request_completed_date;
		this.board_num = board_num;
		this.board_rep_num = board_rep_num;
		this.member = member;
		this.board = board;
		this.boardRep = boardRep;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getAdmin_response_comment() {
		return admin_response_comment;
	}
	public void setAdmin_response_comment(String admin_response_comment) {
		this.admin_response_comment = admin_response_comment;
	}
	public String getRequest_completed_date() {
		return request_completed_date;
	}
	public void setRequest_completed_date(String request_completed_date) {
		this.request_completed_date = request_completed_date;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getBoard_rep_num() {
		return board_rep_num;
	}
	public void setBoard_rep_num(int board_rep_num) {
		this.board_rep_num = board_rep_num;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public BoardRep getBoardRep() {
		return boardRep;
	}
	public void setBoardRep(BoardRep boardRep) {
		this.boardRep = boardRep;
	}
	@Override
	public String toString() {
		return "Report [num=" + num + ", reporter=" + reporter + ", target=" + target + ", report_date=" + report_date
				+ ", admin_response_comment=" + admin_response_comment + ", request_completed_date="
				+ request_completed_date + ", board_num=" + board_num + ", board_rep_num=" + board_rep_num + ", member="
				+ member + ", board=" + board + ", boardRep=" + boardRep + "]";
	}
	
	
	
}
