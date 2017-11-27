package com.playgame.domain;

import java.sql.Date;

public class NoticeVO {
	private String no;
	private String title;
	private String writer;
	private String content;
	private Date add_date;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", add_date="
				+ add_date + "]";
	}
	
}
