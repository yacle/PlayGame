<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<h2>JOIN</h2>
	<hr>
	<form class="form-horizontal" action="/member/join" method="post">
		
		<div class="form-group">
		 <span class="help-block right">* 필수 입력 항목</span>
			<label class="control-label col-sm-2" for="id">*ID : </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="id" placeholder="Enter ID" name="id"> 
				<span id="checkId"><button type="button" id="dbchkid">중복체크</button></span>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="pw">*Password : </label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="pw" placeholder="Enter Password" name="password">
				<input type="password" class="form-control" id="pw2" placeholder="Reconfirm Password" name="pw2">
				<span id="checkPass"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd_hint">*비밀번호 힌트 : </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="pwd_hint" placeholder="비밀번호 힌트 10자 이내" name="pwd_hint">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name : </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="name" name="name">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">*Email:</label>
			<div class="col-sm-5">
				<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
				<button type="button" id="emailReg"><small>인증메일보내기</small></button>
				<span id="codeInput"><input type="text" id="regCode" placeholder="Enter Code"></span>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default" id="join" name="join" >JOIN</button>
			</div>
		</div>
		
	</form>
</div>

<script>

// 필수입력항목 체크
$(document).ready(function(){
	$("#join").click(function(){
		if($("#id").val().length==0){alert("ID를 입력하세요"); $("#id").focus(); return false;}
		if($("#checkId").html()!='사용가능'){alert("ID 중복체크를 하세요"); $("#id").focus(); return false;}
		if($("#pw").val().length==0){alert("비밀번호를 입력하세요"); $("#pw").focus(); return false;}
		if($("#pw2").val().length==0){alert("비밀번호를 입력하세요"); $("#pw2").focus(); return false;}
		if($("#email").val().length==0){alert("Email을 입력하세요"); $("#email").focus(); return false;}
		if($("#codeInput").html()!="<b style=\"color:green\">인증완료</b>"){alert("이메일 인증이 완료되지 않았습니다."); $("#email").focus(); return false;}
	})
})

//ID 중복확인
$("#dbchkid").click(function(){
	var i = $("#id").val();
	if(i.length>4){
		$.ajax({
			"type":"post",
			"async":false,
			"url":"/member/duplication",
			"data":{
				"id":$("#id").val()
			}
		}).done(function(r){
			if(r!=0){
				window.alert("사용중인 아이디입니다.");
			}else{
				$("#checkId").html("사용가능");
			}
		})
	}else{
		$("#checkId").html("아이디는 5자이상 입력하십시오.");
	}
})

//비밀번호 확인
$("#pw").keyup(function(){
	var pwd=$("#pw").val();
	var a = /[a-z]/.test(pwd);
	var b = /[A-Z]/.test(pwd);
	var c = /[0-9]/.test(pwd);
	var d = pwd.length;
	if(a==true && b==true && c==true && d>7){
		pw=true;
		$("#checkPass").html("");
	}else{
		$("#checkPass").html("8자 이상 영문 대소문자, 숫자가 포함되어야 합니다");
	}
})
// 비밀번호 재확인
$("#pw2").keyup(function() {
	var pass = $("#pw").val();
	var pass2 = $("#pw2").val();
	if (pass2 == pass) {
		$("#checkPass").html("<b style=\"color:green\">일치</b>");
	} else {
		$("#checkPass").html("<b style=\"color:red\">불일치</b>");
	}
})

// 이메일 인증 코드 전송
$("#emailReg").click(function(){
	$.ajax({
		type:"post",
		async:false,
		url:"/member/regEmail",
		data:{
			"email":$("#email").val()
		},
		success:function(){
			window.alert("이메일로 인증코드를 발송하였습니다.");
		},
		error:function(){
			window.alert("이메일 주소를 확인해주세요");
		}
	})
})
// 인증코드 확인
$("#regCode").change(function(){
	$.ajax({
		"type":"post",
		"async":false,
		"url":"/member/regCode",
		"data":{
			"regCode":$("#regCode").val(),
			"email":$("#email").val()
		}
	}).done(function(obj){
		if(obj == "true"){
			$("#codeInput").html("<b style=\"color:green\">인증완료</b>");
			$("#emailReg").hide();
		}else{
			$("#codeInput").html("<b style=\"color:red\">인증실패</b>");
			window.alert("email 주소를 확인해주십시요")
		}
	})
})	
</script>
