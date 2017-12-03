<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.row{
	background-color:LightBlue; 
}
#title{
	padding: 5px 15px;
}
#title_line{
	padding-top: 30px;
}
#content{
	padding: 10px;
}
</style>
<h1>공지사항</h1>
<hr/>
<div class="row">
	<div class="col-sm-8">
		<div id="title"><h2><b>${vo.title } 제목</b></h2></div>
	</div>
	<div class="col-sm-4">
		<div id="title_line"><h5>작성자 : ${vo.writer } | ${vo.add_date } | ${vo.view_count }</h5></div>
	</div>
</div>
<div id="content"><h4>${vo.content }내용</h4></div>
<hr/>
<!-- 파일리스트 -->
<div class="form-group">
	<ul class="list-group">
	<c:forEach items="${fileList}" var="list">
		<c:forEach items="${list}" var="map">
			<li class="list-group-item">
				<a href="${map.value}">${map.key}</a>
			</li>
	 	</c:forEach>
 	</c:forEach>
 	</ul>
</div>
<hr/>
<div align="right"><button type="button" class="btn" onClick="history.back()">목록</button></div>

<!-- 라이브리 시티 설치 코드 -->
<div id="lv-container" data-id="city" data-uid="MTAyMC8zMjA5OC84NjYy">
	<script type="text/javascript">
   (function(d, s) {
       var j, e = d.getElementsByTagName(s)[0];

       if (typeof LivereTower === 'function') { return; }

       j = d.createElement(s);
       j.src = 'https://cdn-city.livere.com/js/embed.dist.js';
       j.async = true;

       e.parentNode.insertBefore(j, e);
   })(document, 'script');
	</script>
<noscript> 라이브리 댓글 작성을 위해 JavaScript를 활성화 해주세요</noscript>
</div>
<!-- 시티 설치 코드 끝 -->