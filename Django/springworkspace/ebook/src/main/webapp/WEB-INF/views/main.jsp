<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<style>
.body {
	background-img: url('/resources/img/body.png');
}
</style>
</head>
<body class="body">
	<%@include file="home.jsp"%>
	<form action="" method="post" align="center">
		<input type="text" size="55%">
		<input type="submit" name="search" value="검색">
	</form>
	<p/>
		<%@include file="list.jsp" %>
	<p/>
	<center>
	<img style="width=100%;height=50%;object-fit:contain;" src="<spring:url value ='/resources/img/a.png'/>" alt="메인이미지"> 
	</center>
	<p/>
	<%@include file="bottom.jsp"%>
</body>
</html>