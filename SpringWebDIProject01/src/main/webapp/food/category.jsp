<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.container {
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>믿고보는 맛집리스트</h1>
			<c:forEach var="vo" items="${ list }" varStatus="s">
				<c:if test="${ s.index>= 0 && s.index<12 }">
				<div class="col-md-4">
					<div class="thumbnail">
					<a href="#">
					  <img src="${ vo.poster }" style="width:100%"> 
					</a>
					  <div class="caption">
					  	<p>${ vo.title }</p>
					  </div>
					</div>
				</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="row">
			<h1>지역별 맛집리스트</h1>
			<c:forEach var="vo" items="${ list }" varStatus="s">
				<c:if test="${ s.index>= 12 && s.index<18 }">
				<div class="col-md-3">
					<div class="thumbnail">
					<a href="#">
					  <img src="${ vo.poster }" style="width:100%"> 
					</a>
					  <div class="caption">
					  	<p>${ vo.title }</p>
					  </div>
					</div>
				</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="row">
			<h1>머시기머시기 맛집리스트</h1>
			<c:forEach var="vo" items="${ list }" varStatus="s">
				<c:if test="${ s.index>= 18 && s.index<30 }">
				<div class="col-md-3">
					<div class="thumbnail">
					<a href="#">
					  <img src="${ vo.poster }" style="width:100%"> 
					</a>
					  <div class="caption">
					  	<p>${ vo.title }</p>
					  </div>
					</div>
				</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>