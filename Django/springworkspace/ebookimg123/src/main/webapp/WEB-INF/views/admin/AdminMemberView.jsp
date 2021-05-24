<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ page import="com.a.b.dto.*"%>
<%@ page import="com.a.b.dao.*"%>
<%@ page import="com.a.b.service.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원  목록</title>

<style>

.container {
text-align: center;

}

</style>

</head>
<body>



	<%@ include file="adminpage.jsp"%>
	
	<div class= "container">
		<h1> 회원 목록</h1>	
		<hr>
		<div align="right">
		<a class = "btn btn-primary" href="Adminwrite_view">책추가</a>
	</div>
		<table class = "table table-striped">
			<tr>
				
				<th>아이디</th> 
				<th>패스워드</th>
				<th>이름</th>
				<th>성</th>
				<th>생일</th>
				<th>가입일</th>
				
				
			</tr>
		
			<c:forEach items="${ADmember}" var="ADmember">
			<tr>	
					
				<th><c:out value="${ADmember.bId}"/></th>
				<td><c:out value="${ADmember.bPw}"/></td>
				<td><c:out value="${ADmember.bName}"/></td>
				<td><c:out value="${ADmember.bGender}"/></td>	
				<td><c:out value="${ADmember.bBirthday}"/></td>
				<td><c:out value="${ADmember.bJoindate}"/></td>
				<%-- <th><a class = "btn btn-primary" href="AdminContent?bBookno=${BookList.bBookno}">수정</a></td>	
				<th><a class = "btn btn-primary" href="AdminDelete?bBookno=${BookList.bBookno}">삭제</a></td> --%>
				
				
				
			</tr>		
			</c:forEach>
			
		</table>
	</div>
<%@ include file="/WEB-INF/views/bottom.jsp"%>



</body>
</html>