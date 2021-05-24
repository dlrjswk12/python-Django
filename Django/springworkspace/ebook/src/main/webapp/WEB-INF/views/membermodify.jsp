<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.a.b.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<meta charset="UTF-8">
<title>정보 수정</title>
</head>
<body>
	<div align="center">
		<%@include file="home.jsp"%>
		<%
	Member vo = (Member) session.getAttribute("targetMem");
		%>
		<h1>회원 정보 수정</h1>
		<table border="1">
			<form action="memmodifydo" method="post">
				<tr>
					<th>아이디</th>
					<td><%=vo.getbId() %></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2"><input type="text" name="name" size="30" value="<%=vo.getbName() %>"></td>
				</tr>
				<!-- password1 -->
				<tr>
					<th>패스워드</th>
					<td colspan="2"><input type="password" name="password"
						size="30"></td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td colspan="2"><input type="password" name="password2"
						size="30"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="birthday" size='30' value="<%=vo.getbBirthday() %>"></td>
				</tr>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						value="정보수정"> &nbsp;&nbsp; <input type="reset"
						value="전체삭제"> &nbsp;&nbsp;</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>