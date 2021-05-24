<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script>
	$(".idcheck").click(function() {

		var query = {
			id : $("input#mid").val()
		};

		$.ajax({
			url : "/idcheck",
			type : "post",
			data : query,
			success : function(data) {

				if (data == 1) {
					$(".result .msg").text("사용 불가");
					$(".result .msg").attr("style", "color:#f00");
				} else {
					$(".result .msg").text("사용 가능");
					$(".result .msg").attr("style", "color:#00f");
				}
			}
		}); // ajax 끝
	});
</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div align="center">
		<%@include file="home.jsp"%>
		<h1>회원가입</h1>
		<table border="1">
			<form action="memberdo" method="post">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="mid" name="mid" size="30">
						<button type="button" class="idcheck">중복확인</button></td>
				<tr>
					<th colspan="2" align="center" class="result"><span class="msg">아이디 확인</span>
					</th>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2"><input type="text" name="name" size="30"></td>
				</tr>
				<!-- password1 -->
				<tr>
					<th>패스워드</th>
					<td colspan="2"><input type="password" name="password"
						size="30"></td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td colspan="2"><input type="password" name="password2"
						size="30"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="birthday" size='30'></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><select name="phone">
							<option value="010">010</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
							<option value="011">011</option>
					</select>-<input type="text" name="phone2" size="5"> -<input
						type="text" name="phone3" size="5"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2"><input type="text" name="adress" size="30">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						value="회원가입"> &nbsp;&nbsp; <input type="reset"
						value="전체삭제"> &nbsp;&nbsp;</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>