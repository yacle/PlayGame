<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <title>CKEditor 5 - Classic editor</title>
    <script src="https://cdn.ckeditor.com/ckeditor5/1.0.0-alpha.2/classic/ckeditor.js"></script>
</head>
<body>
<div align="center">
	<h1>거래후기게시판</h1>
	<h3>게시판 글작성</h3>
</div>
<div>
	<form class="form-horizontal" action="/master/write_notice" method="post" autocomplete="off" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${auth_id }">
		<div class="form-group">
			<label class="control-label col-sm-3" for="title">글 제목</label> 
			<div class="col-sm-9">
				<input type="text"class="form-control" style="width: 80%;" name="title">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="content">Content:</label>
			<div class="col-sm-9">
				<textarea class="form-control" rows="5" name="content" id="editor" style="width: 80%;"></textarea>
			<!-- ck edit script -->		
			    <script>
			        ClassicEditor
			            .create( document.querySelector( '#editor' ) )
			            .catch( error => {
			                console.error( error );
			            } );
			    </script>
			</div>
		</div>
		<div align="center">
			<button type="submit">글등록</button>
			<button type="reset">재작성</button>
		</div>
	</form>
</div>
</body>