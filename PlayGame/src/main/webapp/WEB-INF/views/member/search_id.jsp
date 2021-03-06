<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-left:270px">
<h2>아이디 찾기</h2><br/>
<h4>등록된 이름과 이메일을 입력하십시요.</h4>
	<div class="form-group">
		<label for="name">이름:</label>
		<input type="text" class="form-control" id="name" placeholder="Enter Name" style="width:50%">
	</div>
	<div class="form-group">
		<label for="email">E-mail:</label>
		<input type="text" class="form-control" id="email" placeholder="Enter E-mail" style="width:50%">
	</div>
	<div align="right" style="width:50%; color: blue">
		<a href="/member/searchPW" style="color: blue">비밀번호 찾기</a><br/><br/>
		<button type="button" class="btn btn-default" id="search_id">찾기</button>
	</div>
</div>

<script>
$("#search_id").click(function(){
	$.ajax({
		type:"post",
		async:false,
		url:"/member/searchId",
		data:{
			"name":$("#name").val(),
			"email":$("#email").val()
		}
	}).done(function(r){
		window.alert("사용하시는 ID는 ["+r+"] 입니다.");
		location.href="/login";
	})
})
</script>