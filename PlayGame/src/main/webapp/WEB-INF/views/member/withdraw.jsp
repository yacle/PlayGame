<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form class="form-horizontal" action="/member/join" method="post">
	<h2>회원탈퇴</h2>
	<div class="form-group">
		<label class="control-label col-sm-2" for="id">*ID : </label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="id" placeholder="Enter ID" name="id"> 
			<span id="checkId"></span>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pw">*Password : </label>
		<div class="col-sm-5">
			<input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
			<span id="checkPass"></span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" id="withdraw" name="withdraw" >회원탈퇴</button>
		</div>
	</div>
</body>
</html>