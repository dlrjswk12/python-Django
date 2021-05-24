<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.a.b.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<div align="center">
		<%@include file="home.jsp"%>
		<%
	Member vo = (Member) session.getAttribute("memView");
		%>
		<h1>회원 정보</h1>
		<table border="1">
			<form action="memmodify?id=<%=vo.getbId()%>" method="post">
				<input type="hidden" name="password" value="<%=vo.getbPw()%>">
				<input type="hidden" name="no" value="<%=vo.getbNo() %>">
				<input type="hidden" name="gender" value="<%=vo.getbGender() %>">
				<tr>
					<th>아이디</th>
					<td><%=vo.getbId() %></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2"><%=vo.getbName() %></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><%=vo.getbBirthday() %></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td colspan="2"><%=vo.getbJoindate() %></td>
				<tr>
					<th>잔액</th>
					<td colspan="2"><%=vo.getbCash() %>
					</td>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						value="정보수정"> &nbsp;&nbsp;</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>