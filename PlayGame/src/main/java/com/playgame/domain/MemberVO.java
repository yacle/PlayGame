package com.playgame.domain;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private String pwd_hint;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd_hint() {
		return pwd_hint;
	}
	public void setPwd_hint(String pwd_hint) {
		this.pwd_hint = pwd_hint;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", pwd_hint="
				+ pwd_hint + "]";
	}
	
}