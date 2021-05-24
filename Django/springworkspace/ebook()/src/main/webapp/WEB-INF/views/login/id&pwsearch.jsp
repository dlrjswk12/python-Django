<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.a.b.dto.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID/PW 찾기 결과</title>
</head>
		<%@include file="../home.jsp"%>
<body>
	<%
		String vo = (String)session.getAttribute("searchID");
	if(vo == null){
		%>
		입력하신 정보를 확인 후 다시 시도해 주세요.
		<%
	}else {
		%>
		<h1 align="center">
		ID or PW : <%=vo %>
		</h1>
		<%
	}
	%>
</body>
</html>