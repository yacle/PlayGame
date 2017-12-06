package com.playgame.domain;

import java.sql.Date;

public class ProductVO {
	private Integer product_no;
	private String code;
	private String name;
	private String company;
	private String detail;
	private String serial_no;
	private Integer price;
	private Date in_date;
	private String order_no;
	private String pic01;
	private String pic02;
	private String pic03;
	
	public Integer getProduct_no() {
		return product_no;
	}
	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getIn_date() {
		return in_date;
	}
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getPic01() {
		return pic01;
	}
	public void setPic01(String pic01) {
		this.pic01 = pic01;
	}
	public String getPic02() {
		return pic02;
	}
	public void setPic02(String pic02) {
		this.pic02 = pic02;
	}
	public String getPic03() {
		return pic03;
	}
	public void setPic03(String pic03) {
		this.pic03 = pic03;
	}
	@Override
	public String toString() {
		return "ProductVO [product_no=" + product_no + ", code=" + code + ", name=" + name + ", company=" + company
				+ ", detail=" + detail + ", serial_no=" + serial_no + ", price=" + price + ", in_date=" + in_date
				+ ", order_no=" + order_no + ", pic01=" + pic01 + ", pic02=" + pic02 + ", pic03=" + pic03 + "]";
	}
}
