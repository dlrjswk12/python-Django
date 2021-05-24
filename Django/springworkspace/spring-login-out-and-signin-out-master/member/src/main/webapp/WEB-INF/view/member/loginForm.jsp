<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script>
var ex = "<c:out value="${ex}" />";
if(ex=="wrong"){
	alert("아이디 비밀번호가 틀렸습니다.");
}
</script>
<title>로그인 폼</title>
</head>
<body>
<% if(session.getAttribute("log")!=null) {
%>
<script>
window.location="http://localhost:8080/member/main";
</script>
<%
}
%>
LoginForm
<br/><br/>
<form method="post">
아이디  : <input name="email" type="text" /><br/><br/>
비밀번호  : <input name="password" type="password" /><br/><br/>
<input type="submit" value="로그인" />
<a href="sign/permit" ><input type="button" value="회원가입" /></a>

</form>

</body>
</html>