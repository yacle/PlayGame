<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <!-- include summernote css/js-->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	<script type="text/javascript">
  	
  	function sendFile(file, editor){
  		//html5에 기능중 하나인 FormData를 생성 : <form>태그로 만든 데이터의 전송 방식과 동일하게 파일 데이터를 전송할 수 있음.
  		var formdata = new FormData();
  		formdata.append("file", file);
  		$.ajax({
  			type:"POST",
  			url:'/uploadEditorForm',
  			data:formdata,
  			dataType:'text',
  			cache : false,
  			//데이터를 일반적인 query string으로 변활 할것인지 결정, 다른 데이터형식으로 데이터를 보내기위해 자동 변환 방지
  			//dafault:application/x-www-form-urlencoded -변경> 
  			processData:false,
  			//dafalut:application/x-www-form-urlencoded -변경> multipart/form-data 
  			contentType:false,
  			success:function(data){
  				console.log(data);
  				//서버명과 로컬호스트가 없어서 안된거였음.
  				var url = data;
  				console.log(url);
  				$('#summernote').summernote('insertImage', url);
  				//url를 받아서 li<input type=hidden name='files' value="url을 넣어준다.">
  				var dataname = data.substring(url.indexOf("_") + 1);
 				$(".list-group").append("<li class='list-group-item'>"+dataname+"<input type='hidden' name='file_url' value='"+url+"'/></li>");
  			}
  		});
  	}
  	
  	function deleteFile(file){
  		//이미지를 클릭후 삭제버튼을 클릭했을때 url이 깨져서 들어것을 다시 디코딩
		var currentFileName = decodeURIComponent(file);
  		
		$.ajax({
			url:'/deleteFile',
			type:'post',
			data:{fileName:currentFileName},
			dataType:'text',
			success:function(result){
				if(result == 'deleted'){
					//---/2016/09/19/5e617c4d-998f-4db7-bb55-554dec4d8e94_[스프링 생명주기.png] 잘라내기
					currentFileName = currentFileName.substring(currentFileName.indexOf("_") + 1);
					
					$(".list-group-item").each(function(index){
						var value = $(this).text();
						//루프를 돌면서 하나씩 텍스트 내용과 삭제되는 파일이름을 비교
						if(currentFileName === value){
							//에디터에 있는 이미지가 삭제된다면 하단에 표시된 파일명도 같이삭제 된다.
							$(this).remove();
						}
			  		});
				}
			}
		});
  	}
  </script>
</head>
<body>
<div align="center">
	<h1>공지사항게시판</h1>
	<h3>게시판 글작성</h3>
</div>
<div>
	<form action="/notice/write_notice" method="post" autocomplete="off" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${auth_id }">
		<div class="form-group">
			<label class="control-label" for="title">글 제목</label> 
			<div>
				<input type="text" class="form-control" name="title">
			</div>
		</div>
		<div class="form-group">
			<textarea class="form-control" name="content" rows="10" id="summernote"></textarea>
		</div>
			<!-- summernote script -->		
			<script>
			$(document).ready(function(){
				$('#summernote').summernote({
					width:1140,
					callbacks : {
						onImageUpload : function(files, editor, welEditable) {
							sendFile(files[0], this);
						},
  						onMediaDelete:function($target, editor, $editable){
  							deleteFile($target[0].src);
  						},
  						lang: 'ko-KR'
					}
				});
			});
			</script>
			<div class="form-group">
		 		 <ul class="list-group">
				</ul>
			</div>
		<div align="center">
			<button type="submit">글등록</button>
		</div>
	</form>
</div>
</body>