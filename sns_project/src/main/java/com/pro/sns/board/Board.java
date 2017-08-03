package com.pro.sns.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.pro.sns.member.Member;

public class Board {
	private int num;
	private String writer;
	private String path;
	private String content;
	private Date board_date;
	private int type; // 0비공개 1친구공개 2 전체공개
	private String category;
	private int good_count;
	private Member member;
	private MultipartFile file;

	public Board() {
		super();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Board(int num, String writer, String path, String content, Date board_date, int type, String category,
			int good_count, Member member, MultipartFile file) {
		super();
		this.num = num;
		this.writer = writer;
		this.path = path;
		this.content = content;
		this.board_date = board_date;
		this.type = type;
		this.category = category;
		this.good_count = good_count;
		this.member = member;
		this.file = file;
	}

	public Board(int num, String writer, String path, String content, Date board_date, int type, String category,
			int good_count) {
		super();
		this.num = num;
		this.writer = writer;
		this.path = path;
		this.content = content;
		this.board_date = board_date;
		this.type = type;
		this.category = category;
		this.good_count = good_count;
	}

	public Board(int num, String writer, String path, String content, Date board_date, int type, String category,
			int good_count, MultipartFile file) {
		super();
		this.num = num;
		this.writer = writer;
		this.path = path;
		this.content = content;
		this.board_date = board_date;
		this.type = type;
		this.category = category;
		this.good_count = good_count;
		this.file = file;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getGood_count() {
		return good_count;
	}

	public void setGood_count(int good_count) {
		this.good_count = good_count;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", path=" + path + ", content=" + content + ", board_date="
				+ board_date + ", type=" + type + ", category=" + category + ", good_count=" + good_count + ", member="
				+ member + ", file=" + file + "]";
	}

}
