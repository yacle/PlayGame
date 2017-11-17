package com.playgame.domain;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String address;
	private Integer phone;
	private String email;
	private String sms;
	private String pwd_hint;
	private Integer point;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getPwd_hint() {
		return pwd_hint;
	}
	public void setPwd_hint(String pwd_hint) {
		this.pwd_hint = pwd_hint;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", sms=" + sms + ", pwd_hint=" + pwd_hint
				+ ", point=" + point + "]";
	}
}
