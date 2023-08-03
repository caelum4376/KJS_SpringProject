<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Gravity</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li>ID : <input type="text" name="id" size="10"></li>
        <li>PWD : <input type="password" name="pwd" size="10"></li>
        <li><input type="button" name="pwd" value="로그인"></li>
      </ul>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <ul class="clear">
      <li class="active"><a href="index.html">홈</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="../member/join.do">회원가입</a></li>
          <li><a href="#">아이디찾기</a></li>
          <li><a href="#">비밀번호찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="#">맛집 추천</a></li>
          <li><a href="#">맛집 찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">서울</a>
        <ul>
          <li><a href="#">명소</a></li>
          <li><a href="#">자연</a></li>
          <li><a href="#">쇼핑</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">스토어</a>
        <ul>
          <li><a href="#">상품</a></li>
          <li><a href="#">장바구니</a></li>
        </ul>
      </li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">마이페이지</a></li>
    </ul>
  </nav>
</div>
</body>
</html>