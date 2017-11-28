package com.playgame.domain;

public class MemberInfoVO {
	private String address_main;
	private String address_sub;
	private Integer phone;
	private String sms;
	private Integer point;
	private String coupon;
	
	public String getAddress_main() {
		return address_main;
	}
	public void setAddress_main(String address_main) {
		this.address_main = address_main;
	}
	public String getAddress_sub() {
		return address_sub;
	}
	public void setAddress_sub(String address_sub) {
		this.address_sub = address_sub;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	@Override
	public String toString() {
		return "MemberInfoVO [address_main=" + address_main + ", address_sub=" + address_sub + ", phone=" + phone
				+ ", sms=" + sms + ", point=" + point + ", coupon=" + coupon + "]";
	}
}
