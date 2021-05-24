<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="com.a.b.service.*"%>
<html>
<head>
<%
	String id = (String) session.getAttribute("id");
	if (id == null) {
		id = "GUEST";
	}
%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
	<title>Home</title>
</head>
<body>
<table border="0">
		<table width="100%" border="0">
		<tr>
			<td><a href="main" style="text-decoration: none"><img src="<spring:url value ='/resources/img/LOGO.png'/>" height="70" alt="로고출력자리">
			</a></td>
			<td colspan="3">
				<div align="center">
					<h1>도서 관리</h1>
				</div>
			</td>
			<td align="center" width="200"><h3 class="y"><%=id%>
				</h3>
	<%
 	if (id.equals("GUEST")) { %>
				<button class="btn btn-primary" onclick="location.href='login'">로그인</button>
				<button class="btn btn-primary" onclick="location.href='memberjoin'">회원가입</button></td>
				<%
					} else {
				%>
				<button onclick="location.href='logout'">로그아웃</button>
				<%
					}if (id.equals("admin")){
						%>
				<button onclick="location.href='adminpage'">관리자화면</button>
						<%
					}else if(!id.equals("GUEST")) {
						%>
				<button onclick="location.href='memdata'">정보수정</button>
						<%
					}
				%></td>
		</tr>
		<tr height="50" colspan="5">
			<td align="center"><h2><a href="BookList">도서 목록</a></h2></td>
			<td align="center"><h2><a href="homewrite">읽은 책 목록</a></h2></td>
			<td align="center"><h2><a href="homebook">현재 대여 목록</a></h2></td>
			<td align="center"><h2><a href="">요청 게시판</a></h2></td>
			<td align="center"><h2><a href="">금액 충전</a></h2>
		</tr>
</table>
</body>
</html>
