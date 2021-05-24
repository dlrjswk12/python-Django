<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="main.jsp">
<title>HS도서관</title>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
<script src="${context}/js/jquery-1.9.1.js"></script>
<script src="${context}/js/bootstrap.min.js"></script>
</head>

<c:set var="loginUrl">${context}/user/login.jsp</c:set>

<c:set var="bookListUrl">${context}/work/book/retrieveBookList.do</c:set>
<c:set var="extendUrl">${context}/work/rent/retrieveMyExtendList.do</c:set>
<c:set var="reserveUrl">${context}/work/reserve/retrieveMyReserveList.do</c:set>

<c:set var="bookManageUrl">${context}/work/book/retrieveBookListRForManage.do</c:set>
<c:set var="rentManageUrl">${context}/work/book/retrieveBookListForRent.do</c:set>
<c:set var="statisticsUrl">${context}/work/book/retrieveStatisticsForGenre.do</c:set>

<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron jumbotron-info" style="background-color: white;">
			<h1><font color="black"><strong>HS Library</strong></font><img src="${context}/backgroundImage/book.png" width="100" height="100"></h1>
			<p><font color="black"><strong>Welcome to the HS Library</strong></font></p>
		</div>
	</div>
	<br><br><br>
	<div class="container" style="margin-bottom: 5%;">
		<div class="row">
			<c:if test="${sessionScope.grade != 'A'}">
				<div class="col-md-4">
				    <a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${bookListUrl}')" class="btn btn-primary" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-list-alt" style="font-size: 80px; margin-top: 5%;"></span> <br/>도서대출</h1>
					</a>
				</div>
				<div class="col-md-4">
				    <a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${extendUrl}')" class="btn btn-danger" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-pencil" style="font-size: 80px; margin-top: 5%;"></span> <br/>대출연장신청</h1>
				    </a>
				</div>
				<div class="col-md-4">
				    <a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${reserveUrl}')" class="btn btn-info" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-eye-open" style="font-size: 80px; margin-top: 5%;"></span> <br/>예약현황</h1>
	    		    </a>
				</div>
			</c:if>
			<c:if test="${sessionScope.grade == 'A'}">
				<div class="col-md-4">
				    <a href="${bookManageUrl}" class="btn btn-primary" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-list-alt" style="font-size: 80px; margin-top: 5%;"></span> <br/>도서관리</h1>
					</a>
				</div>
				<div class="col-md-4">
				    <a href="${rentManageUrl}" class="btn btn-danger" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-pencil" style="font-size: 80px; margin-top: 5%;"></span> <br/>대출관리</h1>
				    </a>
				</div>
				<div class="col-md-4">
				    <a href="${statisticsUrl}" class="btn btn-info" style="width: 100%; height: 250px;" role="button">
						<h1><span class="glyphicon glyphicon-eye-open" style="font-size: 80px; margin-top: 5%;"></span> <br/>전체통계</h1>
	    		    </a>
				</div>
			</c:if>
	    </div>
	</div>


	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>