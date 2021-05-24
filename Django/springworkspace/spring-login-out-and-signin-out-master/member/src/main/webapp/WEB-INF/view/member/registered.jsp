<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
${member.name}님 가입되셨습니다.

<form action="info/modify" >
<input type="submit" value="회원 정보 수정" />
</form>

<form action="profile" >
<input type="submit" value="프로필  관리" />
</form>

</body>
</html>