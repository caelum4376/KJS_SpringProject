<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="text-center">
			<a href="../main/main.do" class="btn btn-sm btn-danger">믿고 보는 맛집 리스트</a>
			<a href="../main/main.do?cno=2" class="btn btn-sm btn-success">지역별 인기 맛집 리스트</a>
			<a href="../main/main.do?cno=3" class="btn btn-sm btn-warning">메뉴별 인기 맛집 리스트</a>
		</div>
	</div>
	<div style="height: 20px"></div>
	<div class="row">
		<c:forEach var="vo" items="${ list }" varStatus="s">
			<div class="col-md-4">
				<div class="thumbnail">
				<a href="../food/food_list.do?cno=${ vo.cno }">
				  <img src="${ vo.poster }" style="width:100%"> 
				</a>
				  <div class="caption">
				  	<p>${ vo.title }</p>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="height: 10px"></div>
	<h3>최신 방문 맛집</h3>
	<hr>
	<div class="row">
		<c:forEach var="cvo" items="${ cList }">
			<div class="col-md-2">
				<div class="thumbnail">
				<a href="#">
				  <img src="${ cvo.poster }" style="width:100%"> 
				</a>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>