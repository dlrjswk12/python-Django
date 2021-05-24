<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
<link href="${context}/css/common.css" rel="stylesheet">
<script src="${context}/js/common.js"></script>
<script src="${context}/js/bootstrap.min.js"></script>
<style type="text/css">
li{
	cursor: pointer;
}
</style>
</head>

<c:set var="loginUrl">${context}/user/login.jsp</c:set>

<c:set var="bookListUrl">${context}/work/book/retrieveBookList.do</c:set>
<c:set var="extendUrl">${context}/work/rent/retrieveMyExtendList.do</c:set>
<c:set var="reserveUrl">${context}/work/reserve/retrieveMyReserveList.do</c:set>

<c:set var="bookManageUrl">${context}/work/book/retrieveBookListRForManage.do</c:set>
<c:set var="rentManageUrl">${context}/work/book/retrieveBookListForRent.do</c:set>
<c:set var="statisticsUrl">${context}/work/book/retrieveStatisticsForGenre.do</c:set>

<body>
	<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a href="${context}/work/book/goMain.do" class="navbar-brand"><strong>HS도서관</strong></a>
			</div>
			<ul class="nav navbar-nav">
				<c:if test="${sessionScope.grade != 'A'}">
					<li><a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${bookListUrl}')"><font color="black"><strong>도서대출</strong></font></a></li>
					<li><a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${extendUrl}')"><font color="black"><strong>대출연장신청</strong></font></a></li>
					<li><a onclick="javascript:fn_isLogin('${sessionScope.id}','${loginUrl}','${reserveUrl}')"><font color="black"><strong>예약현황</strong></font></a></li>
				</c:if>
				<c:if test="${sessionScope.grade == 'A'}">
					<li><a href="${bookManageUrl}"><font color="black"><strong>도서관리</strong></font></a></li>
					<li><a href="${rentManageUrl}"><font color="black"><strong>대출관리</strong></font></a></li>
					<li><a href="${statisticsUrl}"><font color="black"><strong>전체통계</strong></font></a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:if test="${sessionScope.id == null && sessionScope.grade != 'A'}">
						<a href="${context}/work/user/createUser.do"><font color="black"><strong>회원가입</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null && sessionScope.grade != 'A'}">
						<a href="${context}/work/user/updateUser.do"><font color="black"><strong>정보수정</strong></font></a>
					</c:if>
				</li>
				<li>
					<c:if test="${sessionScope.id == null}">
						<a href="${context}/user/login.jsp"><font color="black"><strong>LOGIN</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.id != null}">
						<a href="${context}/work/user/logout.do"><font color="black"><strong>LOGOUT</strong></font></a>
					</c:if>
				</li>
			</ul>
		</div>
	</nav>
</body>
</html>