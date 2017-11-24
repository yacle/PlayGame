<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-left:270px">
<h2>비밀번호 찾기</h2><br/>
<h4>등록된 이메일주소로 임시 비밀번호를 발급합니다.</h4>
	<div class="form-group">
		<label for="id">ID:</label>
		<input type="text" class="form-control" name="id" placeholder="Enter ID" style="width:50%">
	</div>
	<div class="form-group">
		<label for="name">Name:</label>
		<input type="text" class="form-control" name="name" placeholder="Enter Name" style="width:50%">
	</div>
	<div align="right" style="width:50%; color: blue">
		<a href="/member/searchId" style="color: blue">아이디 찾기</a><br/><br/>
		<button type="button" class="btn btn-default">찾기</button>
	</div>
</div>