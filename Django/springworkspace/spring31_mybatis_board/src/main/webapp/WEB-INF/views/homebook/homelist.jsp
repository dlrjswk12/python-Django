<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sjw.mybatisboard.dto.HomeBook"%>
<%@ page import="com.sjw.mybatisboard.service.Constant"%>
<%@ page import="com.sjw.mybatisboard.dao.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="com.sjw.mybatisboard.dto.*" %>
<%@ page import="com.sjw.mybatisboard.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게부 목록</title>
</head>
<body>
	<%@include file="../Top.jsp"%>
			<div class="container">
	<%
	MDto dto = (MDto)session.getAttribute("joinVo");
	if(dto==null){
		%>
		<script>
		alert('로그인 하세요');
		document.location.href="main";
		</script>
		<%
	}else{	

		String pageNumberStr = request.getParameter("xpage");
		HomeBookListService service = new HomeBookListService(dto.getId());
		//BDao dao = sqlSession.getMapper(BDao.class);
		//BDao dao = new BDao();
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		HomeBookListView viewData = service.getMessageListView(pageNumber);
		int totalPages = viewData.getPageTotalCount();
		if(pageNumberStr==null) pageNumberStr="1";
		
		out.println(pageNumberStr + "/" + totalPages);
		List<HomeBook> subList = viewData.getMessageList();
		
		%>
		
		<h1><%=dto.getId()%>님 가계부 목록 목록</h1>
		
		<table class="table table-bordered" border='1'>
		<tr>
			<th>관리번호</th>
			<th>일자</th>
			<th>구분</th>
			<th>계정과목</th>
			<th>적요</th>
			<th>차변</th>
			<th>대변</th>
			<th>사용자ID</th>
			<th>수정</th>
		</tr>
		<%
			for (HomeBook x : subList) {
		%>
		<tr>
			<td><%=x.getSerialno()%></td>
			<td><%=x.getDay()%></td>
			<td><%=x.getSection()%></td>
			<td><%=x.getAccounttitle()%></td>
			<td><%=x.getRemark()%></td>
			<td><%=x.getRevenue()%></td>
			<td><%=x.getExpense()%></td>
			<td><%=x.getMid()%></td>
			<td><button type="button"  class="btn btn-outline-danger" onclick="location.href='homebookAdjustDo?no=<%=x.getSerialno()%>'">
					수정</td>
		</tr>
		<%
			}
		%>
		<%
	}
		%>
	</table>
	</div>
		
</body>
</html>