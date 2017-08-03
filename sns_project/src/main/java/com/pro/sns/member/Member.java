package com.pro.sns.member;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String id, pwd, name, email, img, isban;
	private MultipartFile file;

	public Member() {
		super();
	}

	public Member(String id, String pwd, String name, String email, String img, String isban, MultipartFile file) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.img = img;
		this.isban = isban;
		this.file = file;
	}

	public Member(String id, String pwd, String name, String email, String img, String isban) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.img = img;
		this.isban = isban;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIsban() {
		return isban;
	}

	public void setIsban(String isban) {
		this.isban = isban;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", img=" + img + ", isban="
				+ isban + ", file=" + file + "]";
	}

}
