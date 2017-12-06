<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 align="center">${title}게시판</h2>
<div class="row text-center">
	<c:forEach var="i" begin="0" end="${cnt}" step="1">
		<c:choose>
			<c:when test="${empty list[i].NO }">
			</c:when>
			<c:otherwise>
				<a href="/item/view/${list[i].NO}">
					<div class="col-sm-3">
						<div class="thumbnail">
							<img src="/sellB_File/${list[i].PIC}" class="img-thumbnail" alt="Article Photo" width="200px" height="200px"><br/>
						</div>
					</div>
				</a>
			</c:otherwise>
		</c:choose>
		<c:if test="${i%4 eq 3}">
			<div class="row"></div>
		</c:if>
	</c:forEach>   
</div> 
<script>
//포인트체크 & 레벨 
$("#write").click(function() {
	$.ajax({
		"type" : "POST",
		"async" : false,
		"url" : "/sell/checkpoint",
		"data" : {
			"id" : $("#id").val()
		}
	}).done(function(obj){
		if(obj=="ok"){
			window.alert("공지사항에서 레벨과 포인트를 확인하세요.");
		}else{
			location.href = "/sell/sellForm";
		}
	})
});
</script>  