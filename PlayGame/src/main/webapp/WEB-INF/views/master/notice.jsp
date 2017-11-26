<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
td{
	font-size:15px;
}
</style>
<div align="center">
	<h2>공지사항</h2>
</div>
<!-- 관리자 글쓰기 버튼 --> 
<button type="button" class="btn btn-default"><a href="/master/write_notice">글쓰기</a></button>
<c:if test="${auth_level gt 9}">
	<div align="right">
		<button type="button" class="btn btn-default"><a href="/master/write_notice">글쓰기</a></button>
	</div>
</c:if>
<table class="table table-hover">
	<thead>
		<tr>
			<th width="10%">#</th>
			<th width="65%">제목</th>
			<th width="10%">작성자</th>
			<th width="15%">작성일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>{obj.no }</td>
			<td>{obj.title }</td>
			<td>{obj.writer }</td>
			<td>{obj.add_date }</td>
		</tr>
	<c:forEach var="obj" items="${list }">
		<tr>
			<td>${obj.no }</td>
			<td>${obj.title }</td>
			<td>${obj.writer }</td>
			<td>${obj.add_date }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>