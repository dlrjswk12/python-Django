<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>메인</title>
</head>
<body>
메인페이지
<br/>

<%
if(session.getAttribute("log") != null){
%>
<input type="button" value="로그아웃" onclick="logout(); window.location.reload()"/>
<% }else {
%>
<a href="login"><input type="button" value="로그인"/></a>
<% } %>

<script>
//httpRequest 객체 생성
function getXMLHttpRequest(){
    var httpRequest = null;

    if(window.ActiveXObject){
        try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
        } catch(e) {
            try{
                httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) { httpRequest = null; }
        }
    }
    else if(window.XMLHttpRequest){
        httpRequest = new window.XMLHttpRequest();
    }
    return httpRequest;    
}

function logout(){
	httpRequest = getXMLHttpRequest();
	httpRequest.open("POST", "logout.do", true)
	 httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
    httpRequest.send();
}
</script>
</body>
</html>