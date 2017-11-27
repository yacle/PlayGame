<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <title>CKEditor 5 - Classic editor</title>
    <script src="//cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
</head>
<body>
<div align="center">
	<h1>공지사항게시판</h1>
	<h3>게시판 글작성</h3>
</div>
<div>
	<form action="/master/write_notice" method="post" autocomplete="off" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${auth_id }">
		<div class="form-group">
			<label class="control-label " for="title">글 제목</label> 
			<div>
				<input type="text"class="form-control" style="width: 80%;" name="title">
			</div>
		</div>
		<div class="form-group">
			<textarea class="form-control" name="content" id="editor"></textarea>
			<!-- ck edit script -->		
			<script>
			 CKEDITOR.replace("editor");
			</script>
		</div>
		<div align="center">
			<button type="submit">글등록</button>
		</div>
	</form>
</div>
</body>