<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="bookListRForReserve.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>HS도서관</title>

	<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

    <link href="${context}/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${context}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="${context}/js/jquery-1.9.1.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>

    <script src="${context}/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${context}/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <script src="${context}/js/sb-admin-2.js"></script>

    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });

	function fn_cancelReserve(paramReserveNo, paramBookName){
		if(confirm('[' + paramBookName + ']을(를) 예약취소 하시겠습니까?')){
			location.href = "${context}/work/reserve/deleteReserve.do?reserveNo=" + paramReserveNo;
		}
	}

    </script>
</head>
<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<div class="jumbotron jumbotron-info" style="background-color: white;">
			<h1><font color="black"><strong><label class="glyphicon glyphicon glyphicon-pencil"></label>예약현황</strong></font></h1>
                <!-- /.col-lg-12 -->
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                        	<th style="text-align: center;">No</th>
                                            <th style="text-align: center;">도서이미지</th>
                                        	<th style="text-align: center;">도서명</th>
                                            <th style="text-align: center;">출간일</th>
                                        	<th style="text-align: center;">출판사</th>
                                            <th style="text-align: center;">저자</th>
                                        	<th style="text-align: center;">장르</th>
                                            <th style="text-align: center;">대출시작일</th>
                                        	<th style="text-align: center;">반납예정일</th>
                                            <th style="text-align: center;">예약신청</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${dsBookList}" var="dsBookList" varStatus="bookIdx">
	                                        <tr>
	                                        	<td style="text-align: center; vertical-align: middle;"><b>${bookIdx.count}</b></td>
	                                            <td style="text-align: center; vertical-align: middle;">
	                                            	<img id="bookImage" style="height: 150px; width:80px;" src="${context}/bookImage/${dsBookList.BOOK_IMAGE}">
	                                            </td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.BOOK_NAME}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.BOOK_PUBLISH_DATE}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.BOOK_PUBLISHER}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.BOOK_AUTHOR}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.BOOK_GENRE_CD_NM}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.RENT_STA_DATE}</td>
	                                            <td style="text-align: center; vertical-align: middle;">${dsBookList.RENT_END_DATE}</td>
	                                            <td style="text-align: center; vertical-align: middle;">
	                                            	<button type="button" class="btn btn-primary" name ="reserveBtn" onclick="fn_cancelReserve('${dsBookList.RESERVE_NO}', '${dsBookList.BOOK_NAME}')">예약취소신청</button>
	                                            </td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <div class="form-group">
				<div class="col-md-offset-11 col-md-1">
					<button type="button" class="btn btn-success" onclick="fn_back()">뒤로가기</button>
				</div>
			</div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
<!--     </div> -->

	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>