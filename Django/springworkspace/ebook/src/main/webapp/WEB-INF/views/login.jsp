<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="home.jsp"%>
<div>
<hr>
<h1 align="center">로그인</h1>
<form name="loginFrm" action="logindo" method ="POST">
<table align="center">
	<tr><th>ID</th><td>
		<input type="text" name="id" size="20">
	</td></tr>
	<tr><th>PASSWORD</th><td>
		<input type="password" name="password" size="20">
	</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" class="btn btn-primary" value="로그인">
		<input type="reset" class="btn btn-primary" value="재입력"><p/><p/>
	</td></tr>
</table>
</form>
	<h5 align="center">
		<button class="btn btn-primary" onclick="location.href='memberjoin'">회원 가입</button>
		<button class="btn btn-primary" onclick="location.href='idSerach'">아이디 찾기</button>
		<button class="btn btn-primary" onclick="location.href='pwSerach'">비밀번호 찾기</button>
	</h5>
</div>
</body>
</html>