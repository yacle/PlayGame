<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<h2>JOIN</h2>
	<hr>
	<form class="form-horizontal" action="/member/join" method="post">

		<div class="form-group">
			<label class="control-label col-sm-2" for="id">ID : </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="id"
					placeholder="Enter ID" name="id"> <span id="checkId"></span>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="pw">Password : </label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="pw"
					placeholder="Enter Password" name="pw"> <input
					type="password" class="form-control" id="pw2"
					placeholder="Enter Password" name="pw2"> <span
					id="checkPass"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="birth">Birth : </label>
			<div class="col-sm-5">
				<input type="date" class="form-control" id="birth" name="birth">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">*Name : </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="name" name="name">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email : </label>
			<div class="col-sm-7">
				<input type="email" class="form-control" id="email"
					placeholder="Enter Email" name="email"> <span
					id="checkEmail"></span><br />
				<button type="button" id="en">Email 인증하기</button>
				<span id="em"></span>
				<input type="hidden" id="trcheck">
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

// 빈칸 X
$(document).ready(function(){
	$("#join").click(function(){
		if($("#id").val().length==0){alert("ID를 입력하세요"); $("#id").focus(); return false;}
		if($("#pw").val().length==0){alert("비밀번호를 입력하세요"); $("#pw").focus(); return false;}
		if($("#pw2").val().length==0){alert("비밀번호를 입력하세요"); $("#pw2").focus(); return false;}
		if($("#email").val().length==0){alert("Email을 입력하세요"); $("#email").focus(); return false;}
		if($("#trcheck").val().length==0){alert("이메일 인증이 완료되지 않았습니다."); $("#email").focus(); return false;}
	})
})



	//ID 중복확인
	document.getElementById("id").onblur = function() {
		if (this.value.length != 0) {
			var xhr = new XMLHttpRequest();
			var ids = document.getElementById("id").value;
			console.log(ids);
			xhr.open("post", "/member/signup_check/id", true);
			xhr.send(ids);

			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					if (this.responseText.trim() == "false") {
						document.getElementById("checkId").innerHTML = "<b style=\"color:green\">사용가능 ID</b>"
							document.getElementById("join").disabled=false;
					} else {
						document.getElementById("checkId").innerHTML = "<b style=\"color:red\">사용불가능 ID</b>"
							document.getElementById("join").disabled=true;
					}
				}
			}
		}
	}
	//이메일 사용가능 확인
	document.getElementById("email").onblur = function() {
		if (this.value.length != 0) {
			var email = document.getElementById("email").value;
			var xhr = new XMLHttpRequest();
			console.log(email);
			xhr.open("post", "/member/signup_check/email", true);
			xhr.send(email);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					if (this.responseText.trim() == "false") {
						document.getElementById("checkEmail").innerHTML = "<b style=\"color:green\">사용가능 Email</b>"
						//document.getElementById("sbt").disabled = "disabled";
							document.getElementById("en").onclick=function(){
							var email = document.getElementById("email").value;
						var xhrr = new XMLHttpRequest();
						xhrr.open("get", "/member/join/auth?email=" + email, false);
						xhrr.onreadystatechange = function() {
							if (this.readyState == 4) {
								window.alert("<" + email + "> 로 인증번호가 전송되었습니다.");
								document.getElementById("en").style.display = "none";
							}
						}
						xhrr.send();
						document.getElementById("em").innerHTML = "인증번호 : <input type=\"text\" id=\"cre\"><button type=\"button\" id=\"tr\">Email 인증하기</button>";
						document.getElementById("tr").onclick = function() {
							var xh = new XMLHttpRequest();
							var ee = document.getElementById("cre").value;
							xh.open("get", "/member/join/tre?tre=" + ee, false);
							xh.onreadystatechange = function() {
								if (this.readyState == 4) {
									var obj = JSON.parse(this.responseText);
									if (obj.tre) {
										window.alert("인증이 확인되었습니다." + "\n"
												+ "JOIN버튼을 누르면 로그인창으로 이동합니다.")
												document.getElementById("trcheck").value="성공"
												
												
									} else {
										window.alert("인증 번호가 다릅니다.")
									}
								}
							}
							xh.send();
						}
							}
					
					} else {
						document.getElementById("checkEmail").innerHTML = "<b style=\"color:red\">사용불가능 Email</b>"
					}
				}
			}
		}
	}

	//비밀번호 확인
	document.getElementById("pw2").onblur = function() {
		var pass = document.getElementById("pw").value;
		var pass2 = document.getElementById("pw2").value;
		console.log(pw);
		console.log(pw2);
		if (this.value == pass) {
			document.getElementById("checkPass").innerHTML = "<b style=\"color:green\">일치</b>"
		} else {
			document.getElementById("checkPass").innerHTML = "<b style=\"color:red\">불일치</b>"
		}
	}

	//*	//가입이메일 인증
	document.getElementById("en").onclick = function() {
		var email = document.getElementById("email").value;
		var xhrr = new XMLHttpRequest();
		xhrr.open("get", "/member/join/auth?email=" + email, false);
		xhrr.onreadystatechange = function() {
			if (this.readyState == 4) {
				window.alert("<" + email + "> 로 인증번호가 전송되었습니다.");
				document.getElementById("en").style.display = "none";
			}
		}
		xhrr.send();
		document.getElementById("em").innerHTML = "인증번호 : <input type=\"text\" id=\"cre\"><button type=\"button\" id=\"tr\">Email 인증하기</button>";
		document.getElementById("tr").onclick = function() {
			var xh = new XMLHttpRequest();
			var ee = document.getElementById("cre").value;
			xh.open("get", "/member/join/tre?tre=" + ee, false);
			xh.onreadystatechange = function() {
				if (this.readyState == 4) {
					var obj = JSON.parse(this.responseText);
					if (obj.tre) {
						window.alert("인증이 확인되었습니다." + "\n"
								+ "JOIN버튼을 누르면 로그인창으로 이동합니다.")
								document.getElementById("trcheck").value="성공"
					} else {
						window.alert("인증 번호가 다릅니다.")
					}
				}
			}
			xh.send();
		}
	}

	//
</script>
