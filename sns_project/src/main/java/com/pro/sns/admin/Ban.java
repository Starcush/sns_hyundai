package com.pro.sns.admin;

import com.pro.sns.member.Member;

public class Ban {
	private int num;
	private String id;
	private String start_date;
	private String end_date;
	private Member member;
	public Ban(int num, String id, String start_date, String end_date, Member member) {
		super();
		this.num = num;
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.member = member;
	}
	public Ban() {
		super();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Ban [num=" + num + ", id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", member="
				+ member + "]";
	}
	
}
