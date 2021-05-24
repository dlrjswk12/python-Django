<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="statisticsR.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>채용사이트</title>

	<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

    <link href="${context}/css/sb-admin-2.css" rel="stylesheet">
    <link href="${context}/css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${context}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="${context}/js/jquery-1.9.1.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>

    <script src="${context}/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/js/plugins/dataTables/jquery.dataTables.js"></script>

    <script src="${context}/js/sb-admin-2.js"></script>
    <script src="${context}/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="${context}/js/morris.min.js"></script>
    <script src="${context}/js/raphael.js"></script>

    <script>

	var sort;
	var url;

    $(document).ready(function(){
    	var objDonut = JSON.parse('${objDonut}');
    	var objBar = JSON.parse('${objBar}');
    	sort = '${sort}';

    	if('${sort}' != null) $("#sort").val(sort);

    	$("#sort").change(function(){
    		sort = $("#sort").val();

    		if(sort == 'genre'){
				url = "${context}/work/book/retrieveStatisticsForGenre.do";
    		}else if(sort == 'bookStatus'){
    			url = "${context}/work/book/retrieveStatisticsForBookStatus.do";
    		}else if(sort == 'bookPublisher'){
    			url = "${context}/work/book/retrieveStatisticsForBookPublisher.do";
    		}else if(sort == 'author'){
    			url = "${context}/work/book/retrieveStatisticsForAuthor.do";
    		}

    		location.href = url + "?sort=" + sort;
    	});



        Morris.Donut({
            element: 'donutChart',
            data: objDonut,
            resize: true
        });

        Morris.Bar({
            element: 'barChart',
            data: objBar,
            xkey: 'y',
            ykeys: ['a'],
            labels: ['데이터 건수'],
            hideHover: 'auto',
            resize: true
        });


    });

    </script>
</head>
<body>
<jsp:include page="/common/top.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron jumbotron-info" style="background-color: white;">
			<h1><font color="black"><strong>통계</strong>&nbsp;<span class="glyphicon glyphicon glyphicon-pencil"></span></font></h1>
		</div>

		<div class="row">
			<div class="col-md-12">
		   		<h1 class="page-header">
			    	<label class="glyphicon glyphicon-list-alt fa-lg"></label>&nbsp;<i><b>Statistics</b></i>
		        </h1>
	        </div>
	    </div>
		<div class="row">
			<div class="col-md-2">
				<select class="form-control" id="sort" name="sort">
					<option value="genre">장르별</option>
					<option value="bookStatus">도서현황별</option>
					<option value="bookPublisher">출판사별</option>
					<option value="author">저자별</option>
				</select>
			</div>
		</div>
	    <div class="row">
			<div id="donutChart"></div>
	    </div>

		<div class="row">
			<div id="barChart"></div>
	    </div>

		<div class="row">
			<div class="col-md-1 col-md-offset-11">
				<button type="button" class="btn btn-success btn-lg"  style="float:right;" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</div>
<jsp:include page="/common/foot.jsp"></jsp:include>
</body>
</html>