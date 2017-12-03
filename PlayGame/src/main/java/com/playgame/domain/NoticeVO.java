package com.playgame.domain;

import java.sql.Date;
import java.util.Arrays;

public class NoticeVO {
	private String no;
	private String title;
	private String writer;
	private String content;
	private Date add_date;
	private String[] file_url;	//첨부파일(클라이언트 측에서 받아오는 파일들)
	private String fileName;	//파일의 full url 주소값(DB에 삽입하기 위함)
	private Integer view_count;
	
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
	public String[] getFile_url() {
		return file_url;
	}
	public void setFile_url(String[] file_url) {
		this.file_url = file_url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getView_count() {
		return view_count;
	}
	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", add_date="
				+ add_date + ", file_url=" + Arrays.toString(file_url) + ", fileName=" + fileName + ", view_count="
				+ view_count + "]";
	}
	
}