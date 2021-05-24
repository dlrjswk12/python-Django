<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.a.b.dao.EDao" %>
<%@ page import="com.a.b.dao.MDao" %>
<%@ page import="com.a.b.dto.RentalingList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import= "java.sql.Timestamp" %>
<%@ page import= "java.text.DateFormat" %>
<%@ page import= "java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<title>현재대여목록페이지</title>
</head>
<body>
<%@include file="home.jsp"%>


<%

	String vo = (String)session.getAttribute("id"); 
	//세션설정한게 없으므로 "id"값에는 null이 들어가있다, 즉 vo는 null이 되버린다
	System.out.println("1");
	System.out.println(id); // 이건 위에서 불러들이는 home.jsp 파일이 GUEST로 만들어버린다
	System.out.println(vo);
	SimpleDateFormat formatT = new SimpleDateFormat ("yyyy년 MM월 dd일 HH시 mm분");
	
	ArrayList<RentalingList> List = (ArrayList<RentalingList>)request.getAttribute("rentalinglist");
	
	System.out.println(request.getAttribute("rentalinglist"));
	//ArrayList<RentalingList> List2 = List.get(0);
	
%>
<%-- 
<%= request.getAttribute("rentalinglist") %>
<%= List.get(0).getbRentaldate() %> 이거 도서대출한거 없으면 에러남
<%= formatT.format(List.get(0).getbRentaldate()) %>
<%= List.size() %>
<%= List.get(0).getbId() %> --%>

<% if (id=="GUEST"){ %>
	<script>
		alert('로그인 하세요');
		document.location.href="main";
	</script>
	<%}%>
<div>

<%-- <table border="1" align = "center">
	</tr>
		<tr>
			<th>대출기록번호</th>
			<th>회원아이디</th>
			<th>책번호</th>
			<th>대출한날짜</th>
			<th>대출기간만료예정일</th>
		</tr>
			<c:forEach items="${rentalinglist}" var="dto">
			<tr>
				<td>${dto.bRentalno}</td>
				<td>${dto.bId}</td>
				<td>${dto.bBookno}</td>
				<td>${dto.bRentaldate}</td>
				<td>${dto.bReturndate}</td>
			</tr>
			</c:forEach>
</table> --%>
	
	<table border="1" align = "center">
	<tr>
		<p>현재 접속자 ID = <%= vo %> , 렌탈'링'리스트, 로그인 회원아이디로 현재빌려진책들 출력</p>
	</tr>
		<tr>
			<th>대출기록번호</th>
			<th>회원아이디</th>
			<th>책번호</th>
			<th>대출한날짜</th>
			<th>대출기간만료예정일</th>
		</tr>
			
<% try{
	for(int i=0; i < List.size() ; i++)
	{%>
			<tr>
	<td><%= List.get(i).getbRentalno() %></td>
	<td><%= List.get(i).getbId() %></td>
	<td><%= List.get(i).getbBookno() %></td>
	<td><%= formatT.format(List.get(i).getbRentaldate()) %></td>
	<td><%= formatT.format(List.get(i).getbReturndate()) %></td>
			</tr>
	<%}
	} catch (Exception e){
	System.out.println("에러처리");
	}%>
				
	</table>
	
	</div>
</body>
</html>