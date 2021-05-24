<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 목록</title>
</head>
<body>
	<div>
	<br/>
	<table border="1" width="45%" align="left">
		<tr>
		<th colspan="3">신규 도서</th>
		</tr>
		<tr>
			<th>이미지</th>
			<th>타이틀</th>
			<th>저자</th>
		</tr>
		<tr>
		<td>이미지</td>
		<td>aaa</td>
		<td>bbb</td>
	</table>
	<table border="1" width="45%" align="right">
	<tr>
	<th colspan="5" align="center">알림</th>
	</tr>
		<tr>
			<th>타이틀</th>
			<th>대출일자</th>
			<th>남은일자</th>
			<th>연장</th>
		</tr>
			<tr>

				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <a
					href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
				<td>${dto.bDate}</td>
			</tr>
	</table>
	</div>
</body>
</html>