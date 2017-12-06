<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
form{
	padding: 20px 20px 20px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS - JQuery-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<form action="/product/add" method="post">
	<h2>제품 등록</h2>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="code">Category</label>
			<select class="form-control" id="code">
				<option>PS4</option>
				<option>XBOX</option>
				<option>NINTENDO</option>
			</select>
		</div>	
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="name">Name</label>
			<input type="text" class="form-control" id="name">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="company">Company</label>
			<input type="text" class="form-control" id="company">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="detail">detail</label>
			<textarea class="form-control" id="detail"></textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="sn">Serial No.</label>
			<input type="text" class="form-control" id="sn">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="price">Price</label>
			<input type="text" class="form-control" id="name">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="in_date">입고일자</label>
			<input type="date" class="form-control" id="in_date">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="pic01">Image 01</label>
			<input type="file" class="form-control" id="pic01">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="pic02">Image 02</label>
			<input type="file" class="form-control" id="pic02">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-4">
			<label for="pic03">Image 03</label>
			<input type="file" class="form-control" id="pic03">
		</div>
	</div>
	<button type="submit">등록</button>
</form>
