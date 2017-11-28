<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form class="form-horizontal" action="/member/withdraw" method="post">
	<h2>회원탈퇴</h2>
	<div class="form-group">
		<label class="control-label col-sm-2" for="id">*ID : </label>
		<div class="col-sm-5">
			<input type="text" class="form-control" placeholder="Enter ID" name="id"> 
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pw">*Password : </label>
		<div class="col-sm-5">
			<input type="password" class="form-control" placeholder="Enter Password" name="password">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default" id="withdraw" name="withdraw" >회원탈퇴</button>
		</div>
	</div>
</form>

<script>
$("#withdraw").click(function(){
	$.ajax({
        url:'/member/withdraw',
        type:'post',
        data:$('form').serialize(),
        success:function(data){
        	if(data != 0){
          		location.href("/home");
        	}else{
        		window.alert("삭제 실패");
        	}
        }
    })
})
</script>