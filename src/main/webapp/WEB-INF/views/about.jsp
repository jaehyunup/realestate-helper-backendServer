<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="HappySaffy">
  <meta name="author" content="박재현/김상훈">
  <title>Happy House</title>
  <!-- Bootstrap core CSS -->
  <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/static/css/about.css" rel="stylesheet">
  <link href="/static/css/fontinit.css" rel="stylesheet">
  </head>
  
  <body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Happy House</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
          aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/">홈
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="/about">소개</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/sitemap">사이트맵</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/deal">실거래가 검색</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/notice/notify">공지사항</a>
          </li>
          <c:choose>
          <c:when test="${sessionScope.user_auth==null}">
	          <li class="nav-item">
	            <a href="/login" class="text-white nav-link btn btn-info mx-2 md-1">로그인</a>
	          </li>
	          <li class="nav-item">
	            <a href="/user/register" class="text-white nav-link btn btn-success mx-2 md-1">회원가입</a>
	          </li>
	      </c:when>
	      <c:otherwise>
		      <c:if test="${sessionScope.user_auth=='admin'}">	         
		          <li class="nav-item">
		            <a href=/adminPage class="text-white nav-link btn btn-danger mx-2 md-1">관리자메뉴</a>
		          </li>
		      </c:if>
		      <li class="nav-item">
	            <a href="/user/modify?user_id=${sessionScope.user_id}" class="text-white nav-link btn btn-danger mx-2 md-1">회원정보수정</a>
	          </li>
	      	  <li class="nav-item">
	            <a href="/logout" class="text-white nav-link btn btn-danger mx-2 md-1">로그아웃</a>
	          </li>
	      </c:otherwise>
          </c:choose>
        </ul>
        </div>
      </div>
    </nav>
    <!-- Page Content -->
  
  
    <div class="container-fluid-center">
      <!-- Jumbotron Header -->
      <div id="cover">
        <div class="jumbotron jumbotron-fluid" style="width:100%;height: 300rem;;">
          <div class="container">
            <h1 class="title display-3 text-center" style="font-weight:100;">도대체 <strong
                style="font-weight:600;">좋은 집</strong>은 어디에 있나요</h1>
            <!--메인 검색폼-->
          </div>
          <div class="container">
            <h1 class="title display-5 text-center" style="font-weight:100;  padding: 200px 0;">사람들은 항상 <strong
                style="font-weight:600;">좋은 집</strong>에 살고싶어합니다.</h1>
            <!--메인 검색폼-->
          </div>
          <div class="container">
            <h1 class="title display-5 text-center" style="font-weight:100; padding: 200px 0;">하지만 대부분의 사람들은 어디서 <strong
                style="font-weight:600;">정보</strong>를 얻어야하는지 잘 모르죠.</h1>
            <!--메인 검색폼-->
          </div>
          <div class="container">
            <h1 class="title display-5 text-center" style="font-weight:100; padding: 200px 0;">그래서 우리는 모든사람들에게 정보를 <strong
                style="font-weight:600;"><br/>제공</strong>하기로 마음먹었습니다. </h1>
            <!--메인 검색폼-->
          </div>
          <div class="container">
            <h1 class="title display-5 text-center" style="font-weight:100; padding: 200px 0;"><strong
                style="font-weight:600;">지금 시작합니다.</strong></h1>
            <!--메인 검색폼-->
          </div>
          <div class="container">
            <h1 class="title display-3 text-center" style="font-weight:100; padding: 200px 0;"><strong
                style="font-weight:600;">HappyHouse</strong></h1>
            <!--메인 검색폼-->
          </div>
          <div style="background: white; margin: 10px; display: inline-block;">
            <div>

            </div>
            
          </div>
        </div>
      </div>
    </div>
  
    </div>
    <!-- /.container -->
  
    <!-- Footer -->
    <footer class="py-2 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; 박재현&김상훈 2020</p>
      </div>
      <!-- /.container -->
    </footer>
  
    <!-- Bootstrap core JavaScript -->
    <script src="/static/vendor/jquery/jquery.min.js"></script>
    <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  </body>
  
  </html> 
  