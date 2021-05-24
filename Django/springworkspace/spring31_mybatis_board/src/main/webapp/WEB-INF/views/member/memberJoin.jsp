<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입하기</title>
</head>
<body>
<%@ include file ="../Top.jsp" %>

<div class = "container">
	<h1 align = "center">회원가입</h1>
	

<form action = "memberJoinDo" method = "POST">
	<table class = "table table-bordered" >
		<tr>
			<th>아이디</th>
			<td><input type="text" class="form-control" name="mid"></td>
			
		</tr>
		<tr>
			<th>비번</th>
			<td><input type="password" class="form-control" name="mpassword"></td>
		</tr>
		<tr>
			<th>비번확인</th>
			<td><input type="password" class="form-control" name="mpassword2"></td>
		</tr>	
		<tr>
			<th>전화번호</th>
			<td><input type="text" class="form-control" name="mphone"></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="회원가입"></td>
		</tr>
	
	</table>
	


</form>
 
</div>

</body>
</html>