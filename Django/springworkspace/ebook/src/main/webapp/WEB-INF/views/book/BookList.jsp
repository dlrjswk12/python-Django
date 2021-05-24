<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.a.b.dto.*"%>
<%@ page import="com.a.b.dao.*"%>
<%@ page import="com.a.b.service.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/home.jsp"%>
	
	<div class= "container">
		<h1> 도서 목록</h1>	
		<hr>
		<table class = "table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>소개</th>
				<th>저자</th>
				<th>카테고리</th>
			</tr> 
			<c:forEach items="${BookList}" var="BookList">
			<tr>	
				<td><c:out value="${BookList.bBookno}"/></td>
				<td><c:out value="${BookList.bBookname}"/></td>
				<td><c:out value="${BookList.bContent}"/></td>
				<td><c:out value="${BookList.bWriter}"/></td>
				<td><c:out value="${BookList.bCategory}"/></td>
			</tr>		
			</c:forEach>
		</table>
	</div>
		
<%@ include file="/WEB-INF/views/bottom.jsp"%>



</body>
</html>