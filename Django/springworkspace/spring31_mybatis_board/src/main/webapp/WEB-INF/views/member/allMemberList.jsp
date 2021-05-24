<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="java.util.*"%>
<%@ page import="com.sjw.mybatisboard.dto.*"%>
<%@ page import="com.sjw.mybatisboard.service.*"%>

<meta charset="UTF-8">
<title>등록 회원명단</title>
</head>
<body>

	<%@include file="../Top.jsp"%>
	<%
	
	
	String pageNumberStr = request.getParameter("xpage");
	MemberListService service = new MemberListService();
	//BDao dao = sqlSession.getMapper(BDao.class);
	//BDao dao = new BDao();
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	MemberListView viewData = service.getMessageListView(pageNumber);
	int totalPages = viewData.getPageTotalCount();
	if (pageNumberStr == null)
		pageNumberStr = "1";

	out.println(pageNumberStr + "/" + totalPages);
	List<MDto> subList = viewData.getMessageList();
	
	
	
	
	
	
	%>

	<div class="container">
	<h1 align="center">등록회원명단</h1>
	<div align="right">
		<button type="button" class = "btn btn-primary" onclick="location.href='main'">메인</button>
	</div>
	<hr>
	 <% 
	 
	 out.print("<table class='table table-striped'>");
		out.print("<tr>");
		out.print("<th>회원번호</th>");
		out.print("<th>아이디/닉네임</th>");
		out.print("<th>패스워드</th>");
		out.print("<th>연락처</th>");
		out.print("</tr>");

		for (MDto x : subList ) {
			out.print("<tr >");
			out.print("<td>" + x.getNo() + "</td>");
			out.print("<td>" + x.getId() + "</td>");
			out.print("<td>" + "????" + "</td>");
			out.print("<td>" + x.getPhone() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	 
	 
	 %>


</body>
</html>