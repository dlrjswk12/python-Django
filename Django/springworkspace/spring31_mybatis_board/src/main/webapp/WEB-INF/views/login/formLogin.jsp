<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창!</title>
</head>
<body>
	<div class = "container">
		<h1 align = "center">로그인창</h1>
	
	<hr>
	<hr>
	<form name="loginFrm" action="logindo" method ="POST">
	<table class="table table-bordered" align="center">
		<tr><th>ID</th><td>
		<input class="form-control"  type="text" name="id" size="20">
	</td></tr>
	<tr><th>PASSWORD</th><td>
		<input class="form-control"  type="password" name="password" size="20">
	</td></tr>
	<tr><td colspan="2" align="center">
		<input class="btn btn-success" type="submit" value="로그인">
		<input class="btn btn-danger" type="reset" value="다시">
	</td></tr>
	</table>
	</div>

</body>
</html>