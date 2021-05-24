<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
</head>
<body>
		<%@include file="../home.jsp"%>
		<h1 align="center">ID 찾기</h1>
	<div align="center">
		<table border="1">
			<form action="idsearchdo" method="post">		
				<tr>
					<th>이름</th>
					<td colspan="2"><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="birthday"></td>
				</tr>
				<tr>
					<td align="center" colspan="3">
					<input type="submit" value="ID 찾기" class="btn btn-primary">
					&nbsp;&nbsp;
					<input type="reset" value="재입력" class="btn btn-primary"></td>
				</tr>
			</form>
		</table>
	</div>
	<div align="center">
	<p/>
	<h1 align="center">비밀번호 찾기</h1>
		<table border="1">
			<form action="idsearchdo" method="post">
				<tr>
					<th>아이디</th>
					<td colspan="2"><input type="text" name="bid"></td>
				<tr>
					<th>이름</th>
					<td colspan="2"><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="birthday"></td>
				</tr>
				<tr>
					<td align="center" colspan="3">
					<input type="submit" value="비밀번호 찾기" class="btn btn-primary">
					&nbsp;&nbsp;
					<input type="reset" value="재입력" class="btn btn-primary"></td>
			</form>
		</table>
	</div>
</body>
</html>