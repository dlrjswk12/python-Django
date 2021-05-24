<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<title> 프로필 설정 </title>
<script>
  var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('output');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  };
</script>
</head>

<body>

<% if(session.getAttribute("log")==null){ %>
<script>
window.location = "http://localhost:8080/member/main";
</script>
<%} %>
프로필 정보 수정하기
<br/><br/><br/>
프로필 사진<br/><br/>

<form action="sign/upload" method="post" enctype="multipart/form-data">

<input id="email" name ="email" type="hidden" value="${email}"  />

<div style="width:240px;height:250px;">
<c:if test="${realPath==null}">
    <img id="output" src="../images/pro.PNG" style="width:200px; height:200px"/><br/>
</c:if>
<c:if test="${realPath!=null}">
    <img id="output" src="${realPath}" style="width:200px; height:200px"/><br/>
</c:if>
    <input type="file" id="file" name="file" accept="image/*" onchange="loadFile(event)" />
</div>
<input type="submit" value="프로필 이미지 설정"/>
</form>

<br/><br/>

<form:form commandName="profile" method="post">

<form:input type="hidden" value="${email}" path="email" />

<label for="category">서비스 카테고리</label><br/>
<form:checkboxes items="${serviceCategory}" path="category" value="${member.category}"  /><br/><br/>

<label for="locale">서비스 가능지역</label><br/>
<form:checkboxes items="${serviceLocale}" path="locale" value="${member.locale}"/><br/><br/>

<label for="universe">대학</label> 
<form:input path="universe" value="${member.universe}"/>

 <label for="attending">재학 여부</label>
 <form:select path="attending" items="${attendingList}" value="${member.attending}" /><br/><br/>

<label for="title">수업제목</label><br/>
<form:input path="title" value="${member.title}" /><br/><br/>

<label for="career">경력</label><br/>
<textarea name="career" >${member.career}</textarea><br/><br/>

<label for="teacher">선생님 소개</label><br/>
<textarea name="teacher" >${member.teacher}</textarea><br/><br/>

<label for="clas">수업 방식</label><br/>
<textarea name="clas">${member.clas}</textarea><br/><br/>

<input type="submit" value="등록" />

</form:form>

</body>
</html>