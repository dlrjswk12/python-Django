<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.a.b.service.*"%>
<%@ page import="com.a.b.dto.*" %>
<html>
<head>
	<div>
	<%
	Member vo = (Member)session.getAttribute("joinVo");
	if(vo==null){
		%>
		<script>
		alert('로그인 후 가능합니다.');
		document.location.href="main";
		</script>
		<%
	}%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<title>금액 충전</title>
</head>
<body>
	<%@include file="home.jsp"%>
	<h1 align="center">금액 충전</h1>
<form name="cashup" action="cashupdo" method ="POST">
	<input type="hidden" name="bId" value="${joinVo.bId}">
<table align="center">
	<tr><th>금액</th><td>
		<input type="text" name="bCash" size="20">
	</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" class="btn btn-primary" value="충전">
		<input type="reset" class="btn btn-primary" value="재입력"><p/><p/>
	</td></tr>
</table>
</form>
		
	
	
	
	
	
	
	
	</table>
</body>
</html>