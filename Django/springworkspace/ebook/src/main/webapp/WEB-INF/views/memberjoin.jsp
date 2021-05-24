<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#mid").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#mid').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/memberjoin/idCheck?userId='+ mid,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_id == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
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
					<td><input type="text" class="form-control" id="mid" name="mid" placeholder="ID" required>
				<tr>
					<th colspan="2"><div class="check_font" id="id_check"></div>
					</th>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2"><input type="text" name="name"></td>
				</tr>
				<!-- password1 -->
				<tr>
					<th>패스워드</th>
					<td colspan="2"><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td colspan="2"><input type="password" name="password2"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="birthday"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="checkbox" name="gender" value="남">남</td>
					<td><input type="checkbox" name="gender" value="여">여</td>
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