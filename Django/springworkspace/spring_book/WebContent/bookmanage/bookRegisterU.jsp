<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="bookRegisterC.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>HS도서관</title>

	<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/css/plugins/dataTables.bootstrap.css" rel="stylesheet">
	<link href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet" >
    <link href="${context}/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${context}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<script src="${context}/js/jquery-1.9.1.js"></script>
	<script src="${context}/js/jquery.form.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
    <script src="${context}/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${context}/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <script src="${context}/js/sb-admin-2.js"></script>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

    <script>


    $(document).ready(function() {
        $('#dataTables-example').dataTable();

        fn_init();

		//U페이지 해당
		fn_setDetailInfo();

		$( "#bookPublishDate" ).datepicker({
	    	dateFormat: 'yy-mm-dd',
	    	changeMonth: true,
	        changeYear: true,
	        yearRange: "1980:2015"
	    });

    });

    function fn_setDetailInfo(){
		$("#bookName").val('${dsBook.bookName}');
		$("#bookGenreCd").val('${dsBook.bookGenreCd}');

		$("#bookPublishDate").val('${dsBook.bookPublishDate}');
		$("#bookPublisher").val('${dsBook.bookPublisher}');
		$("#bookAuthor").val('${dsBook.bookAuthor}');

		$("#pic").attr("src", '${context}/bookImage/' + '${dsBook.bookImage}');
		$("#bookImage").val('${dsBook.bookImage}');
	}

	function fn_save(){
		if(confirm("수정하시겠습니까?")){
			if(!fn_validation()) return;

			alert("도서정보가 수정되었습니다.");

			$("#updateBook").submit();
		}
	}

	function fn_upload(){
		$("#ajaxform").ajaxSubmit({
	        type: "POST",
	        dataType: 'text',
	        url: $("#ajaxform").attr("action"),
	        data: $("#ajaxform").serialize(),
	        success: function (data) {
	        	data2 = data.replace(/"/gi, "");
	        	var imageUrl = "${context}/bookImage/" + data2;
	        	$("#pic").attr("src", imageUrl);
	        	$("#bookImage").val(data2);
	        },
	        error: function (xhr, status, error) {
	            alert(error);
	        }
	    });
	}

    </script>
</head>
<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron jumbotron-info" style="background-color: white;">
			<h1><font color="black"><strong>도서등록</strong>&nbsp;<span class="glyphicon glyphicon glyphicon-pencil"></span></font></h1>
		</div>
	</div>
	<div class="container">
	<form id="updateBook" method="post" action="${context}/work/book/updateBook.do" role="form">
		<div class="form-horizontal">
			<div class="form-group" style="margin-top: 5%;">
				<label for="bookName" class="control-label col-md-2"><b>도서명</b></label>
				<div class="col-md-4">
					<input class="form-control" type="text" name="bookName" id="bookName" required="required" autofocus="autofocus"/>
				</div>
			</div>

			<div class="form-group">
				<label for="bookGenreCd" class="control-label col-md-2"><b>장르</b></label>
				<div class="col-md-2">
		        	<select class="form-control" id="bookGenreCd" name="bookGenreCd" required="required">
						<c:forEach items="${dsCode1}" var="code1">
							<option value="${code1.commCd}">${code1.commCdNm}</option>
						</c:forEach>
		     		</select>
	     		</div>
			</div>

			<div class="form-group">
				<label for="bookPublishDate" class="control-label col-md-2"><b>출간일</b></label>
				<div class="col-md-6">
					<input class="form-control" type="text" id="bookPublishDate" name="bookPublishDate" required="required" maxlength="10"/>
				</div>
			</div>

			<div class="form-group">
				<label for="bookPublisher" class="control-label col-md-2"><b>출판사</b></label>
				<div class="col-md-6">
					<input class="form-control" type="text" id="bookPublisher" name="bookPublisher" required="required"/>
				</div>
			</div>

			<div class="form-group">
				<label for="bookAuthor" class="control-label col-md-2"><b>저자</b></label>
				<div class="col-md-6">
					<input class="form-control" type="text" id="bookAuthor" name="bookAuthor" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2"><b>도서이미지</b></label>
				<img id="pic" style="margin-left: 15px;" height="180px" width="150px" src="${context}/backgroundImage/defaultpic.png"><br/>
				<div class="col-md-6">
					<input type="hidden" id="bookImage" name="bookImage" required="required">
				</div>
				<div class="col-md-2">
					<input type="hidden" id="bookCode" name="bookCode" value='${dsBook.bookCode}'>
				</div>
			</div>
		</div>
	</form>

	<form id="ajaxform" action="${context}/work/book/saveFile.do" method="post" enctype="multipart/form-data" role="form">
		<div class="form-group">
		<label class="control-label col-md-2"></label>
			<div class="col-md-6">
				<input class="form-control" type="file" id="imageFile" name="imageFile" onchange="fn_upload()"/>
			</div>
		</div>
		<br><br><br>
		<div class="form-group">
		<label class="control-label col-md-12"></label>
			<div class="col-md-1 col-md-offset-8">
				<button type="button" class="btn btn-success" onclick="fn_save()">수정하기</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-success" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</form>

	</div>

	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>