<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.img{ max-width: 100%; height: auto; }



img { max-width: 100%; height: auto; }



</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("utf-8");
%>

</head>
<body class="body">
	<%@include file="Top.jsp"%>
	<p/>
	<center>
	<img style="width=100%;height=100%; object-fit:contain;" src="<spring:url value ='/resources/img/BACKIMAGE.png'/>" alt="메인이미지"> 
	</center>
	<P />
	<%@include file="Bottom.jsp"%>
</body>
</html>