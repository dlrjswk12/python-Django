<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page import="java.util.Date" %>
<%@ include file="../includes/header.jsp" %>


<div class="container">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb mt-4">
          <li class="breadcrumb-item">
            <a href="/haengbok">홈</a>
          </li>
          <li class="breadcrumb-item active">마이페이지</li>
        </ol>

	<div class="row mt-4">
      <div class="col-lg-3 mb-4 smallhide">
        <div class="list-group">
          <a href="#" class="list-group-item active">회원 리스트</a>
          <a href="borrowinfo" class="list-group-item">대출 정보	</a>
          <a href="/haengbok/member/changepw" class="list-group-item">비밀번호 변경</a>
          
        </div>
      </div>
      <div class="col-lg-9 mb-4">

        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            	회원 목록</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>아이디</th>
                    <th>이메일</th>
                    <th>가입일</th>
                    <th>최근 접속일</th>
                  </tr>
                </thead>
                <c:forEach items="${list }" var="user">
                
                <tbody>
                  <tr>
                    <td><c:out value="${user.userid }"/></td>
                    <td><c:out value="${user.useremail }"/></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.regDate }"/></td>
                    <td><fmt:formatDate value="${user.updateDate }" type="both"/></td>
                  </tr>
                </tbody>
                
                </c:forEach>
              </table>
            </div>
          </div>
        </div>
	</div>
	</div>
      </div>
      <!-- /.container-fluid -->



<%@ include file="../includes/footer.jsp" %>