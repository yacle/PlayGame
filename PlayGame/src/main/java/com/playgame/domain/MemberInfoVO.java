package com.playgame.domain;

public class MemberInfoVO {
	private String info_id;
	private String address_main;
	private String address_sub;
	private Integer phone_num;
	private Integer point;
	private String coupon;
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
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
		return phone_num;
	}
	public void setPhone(Integer phone_num) {
		this.phone_num = phone_num;
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
		return "MemberInfoVO [info_id="+info_id+"address_main=" + address_main + ", address_sub=" + address_sub + 
				", phone_num=" + phone_num+ ", point=" + point + ", coupon=" + coupon + "]";
	}
}
