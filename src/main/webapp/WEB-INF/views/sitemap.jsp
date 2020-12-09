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
  <link href="/static/css/sitemap.css" rel="stylesheet">
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
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">소개</a>
          </li>
          <li class="nav-item active">
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
        <div class="jumbotron" style="width:100%;height: 300rem;;">
          <div class="container">
              
    <div class="container">
      <h1>HappyHouse 사이트 맵</h1>
      <section id="sec0">
    
        <h2>메인</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="home.html">메인 화면</a></li>
            </ul>
          </div>
        </div>
      </section>
      <section id="sec2">
      <section id="sec1">
    
        <h2>소개</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="about.html">소개</a></li>
              지금 있는 홈페이지의 목표를 소개하는 페이지 입니다
              <li><a href="sitemap.html">사이트맵</a></li>
              Happy House 홈페이지의 사이트맵입니다.
            </ul>
          </div>
        </div>
      </section>
      <section id="sec2">
    
        <h2>아파트 검색</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="deallist.html">아파트 검색</a></li>
              아파트에대한 모든 검색을 수행할 수 있는 곳입니다.
              전체 검색, 상세 검색, 동별 화면, 아파트별 화면을 볼 수 있습니다
              관심지역 동네 업종 정보, 관심지역 대기오염 정보를 알 수 있습니다.
            </ul>
          </div>
        </div>
      </section>
      <section id="sec3">
    
        <h2>공지사항</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="notify.html">공지사항</a></li>
              홈페이지의 공지 내용을 볼 수 있는 화면 입니다.
              공지사항의 등록, 수정, 삭제, 검색이 가능합니다
            </ul>
          </div>
        </div>
      </section>
      <section id="sec4">
    
        <h2>관리자 페이지</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="searchPage.html">관리자 페이지(회원정보 등록, 삭제)</a></li>
              <li><a href="adminPage.html">회원정보 등록</a></li>
              <li><a href="updatePage.html">회원정보 수정</a></li>
              * 관리자만 접속이 가능합니다.<br>
              * 관리자는 회원정보 등록, 수정, 삭제, 검색이 가능합니다
            </ul>
          </div>
        </div>
      </section>
      <section id="sec5">
    
        <h2>로그인/회원가입</h2>
        <div class="row">
          <div class="col-md-3">
            <ul>
              <li><a href="login.html">로그인</a></li>
              <li><a href="join.html">회원가입</a></li>
              <li><a href="passwordforgot.html">비밀번호 찾기</a></li>
            </ul>
          </div>
        </div>
      </section>
    
    </div>
    <!-- /container --></div>
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
  