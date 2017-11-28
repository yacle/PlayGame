<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-left:270px">
	<h2>LOGIN</h2><br/>
	<form action="/login" method="post">
		<div class="form-group">
			<label for="id">ID:</label>
			<input type="text" class="form-control" name="id" placeholder="Enter ID" style="width:50%">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" name="password" placeholder="Enter password" style="width:50%">
		</div>
		<div align="right" style="width:50%;">
		<a href="/member/searchId" style="color: blue">아이디 찾기</a> | <a href="/member/searchPW" style="color: blue">비밀번호 찾기</a><br/><br/>
		<button type="button" id="submit" class="btn btn-default">Submit</button>
		</div>
	</form>
</div>

<script>
$("#submit").click(function(){
	$.ajax({
		type:"post",
		async:false,
		url:"/login",
		data:$("form").serialize(),
		success:function(data){
			if(data=='ok'){
				location.replace("/");
			}else{
				window.alert("아이디와 패스워드를 확인해주세요");
			}
		}
	})
})
</script>