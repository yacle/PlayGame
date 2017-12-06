<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-left:270px">
<h2>비밀번호 찾기</h2><br/>
<h4>등록된 이메일주소로 임시 비밀번호를 발급합니다.</h4>
	<div class="form-group">
		<label for="id">ID:</label>
		<input type="text" class="form-control" id="id" placeholder="Enter ID" style="width:50%">
	</div>
	<div class="form-group">
		<label for="pwd_hint">비밀번호 힌트:</label>
		<input type="text" class="form-control" id="pwd_hint" placeholder="Enter Password Hint" style="width:50%">
	</div>
	<div align="right" style="width:50%; color: blue">
		<a href="/member/searchId" style="color: blue">아이디 찾기</a><br/><br/>
		<button type="button" class="btn btn-default" id="search_pw">발급</button>
	</div>
</div>

<script>
$("#search_pw").click(function(){
	$.ajax({
		type:"post",
		async:false,
		url:"/member/searchPw",
		data:{
			"id":$("#id").val(),
			"pwd_hint":$("#pwd_hint").val()
		},
		success:function(){
			window.alert("임시비밀번호를 이메일로 발송하였습니다.");
			location.href="/login";
		}
	})
})
</script>