<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>

<script>
var ex =  '${ex}';
if(ex == 'exception'){
	alert("이미 가입된 이메일 입니다.");
}

function CheckForm(memberInfo){ 
	 	var re = /^[a-z0-9]{6,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	 	var re1 = /^[a-z0-9]{8,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	 	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	       // 이메일이 적합한지 검사할 정규식
		var bi = /^[0-9]{6}$/
		var tel = /^[0-9]{10,11}$/
			
		var form = memberInfo;

	    if(!check(re2, form.email, "적합하지 않은 이메일 형식입니다.")) {
	           return false;
	       }
		
	    if(!form.password.value){
			alert("비밀번호를 입력하세요.");
			return false;
			}
		if(!check(re1, form.password,"패스워드는 8~12자의 영문 소문자와 숫자로만 입력")) {
	           return false;
	       }
		if(form.password.value != form.password2.value){
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
			}
		 if(!check(bi, form.birth, "ex)960321 위와 같은 형식의 생년월일을 입력해주세요.")) {
	           return false;
	       }
		 if(!check(tel, form.phone, "하이픈('-')을 제외한 휴대폰 번호를 입력해주세요.")) {
	           return false;
	       }
	   var chk1=document.memberInfo.U_checkAgreement1.checked;
	   if(chk1==""){
	    alert('약관에동의해 주세요');
	    return false;
	   }
	
	}
function check(re, what, message) {
    if(re.test(what.value)) {
        return true;
    }
    alert(message);
    what.value = "";
    what.focus();
    //return false;
}
	
function contentAgree(){
	window.name="parentForm";
	window.open("content", "chkForm", "width=500, height=300, resizable = no, scrollbars=no");
	//수정
}
function contentAgree2(){
	window.name="parentForm";
	window.open("content2", "chkForm", "width=500, height=300, resizable = no, scrollbars=no");
	//수정
}
</script>
</head>
<body>
<p>
<% if(session.getAttribute("log")!=null) {
%>
<script>
window.location="http://localhost:8080/member/main";
</script>
<%
}
%>
<form:form commandName="memberInfo" name="memberInfo" onSubmit="return CheckForm(this)" >
<label for="email">이메일</label></br>
<form:input path="email" placeholder="예) name@domain.com" />
<form:errors path="email" />
</p>

<p>
<label for="password">비밀번호 (8자리 이상 숫자 문자 조합)</label></br>
<form:password path="password" />
<form:errors path="password" /><br/>
</p>

<p>
<label for="password2">비밀번호 확인</label><br/>
<input type="password" name="password2" />
</p>

<p>
<label for="name">이름</label></br>
<form:input path="name" />
<form:errors path="name" />
</p>

<p>
<label for="sexual">성별</label></br>
<form:select path="sexual" items="${listSex}"/>
<form:errors path="sexual" />
</p>

<p>
<label for="birth">생년월일</label></br>
<form:input path="birth" placeholder="예) 970521" />
<form:errors path="birth" />
</p>

<p>
<label for="tel">휴대폰 (-을 빼고 입력해주세요.)</label></br>
<form:select path="teloff" items="${listTel}"/>
<form:input path="phone" placeholder="예) 01012345678" />
<form:errors path="phone" />
</p>

<input name="U_checkAgreement1" type="checkbox" value="" id="U_checkAgreement1" class="inputCheck" /> 
회사의 <a style="text-decoration:underline;cursor:pointer" onclick="contentAgree()">이용약관</a>과 
<a style="text-decoration:underline;cursor:pointer" onclick="contentAgree2()">개인정보보호 방침</a>에 동의 합니다.
<br/><br/>
<input type="submit" value="가입"/>

</form:form>


</body>
</html>