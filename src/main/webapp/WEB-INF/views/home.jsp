<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="HappySaffy">
  <meta name="author" content="박재현/김상훈">
  <title>Happy House</title>
  <!-- Bootstrap core CSS -->
<link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/mainpage.css" rel="stylesheet">
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
            <a class="nav-link active" href="/">홈
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">소개</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/sitemap">사이트맵</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/deal">실거래가 검색</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='notice/notify' />">공지사항</a>
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
  <div class="container-fluid">
    <!-- Jumbotron Header -->
    <div id="cover">
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="title display-3 text-center" style="font-weight:100;">내 지역 <strong
              style="font-weight:600;">부동산 시세</strong>검색</h1>
          <p class="lead string-1 text-center">내 주변 부동산 시세는 어떨까요, 검색해보세요</p>
          <!--메인 검색폼-->
          <div class="py-5" style="text-align: center;">
            <form class="form-inline" style="display:block">
              <label class="sr-only" for="location">장소 입력</label>
              <input style="width:40%;height:10%;" type="text" class="form-control mb-2 mr-sm-2" id="location" placeholder="장소 입력">
              <button style="width:10%;height:10%;"type="submit" class="btn btn-primary mb-2" disabled>검색</button>
            </form>
        </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <!-- Page Features -->
<!--     <div class="row"> -->
<!--       <div class="col-lg-3 col-md-6 mb-4"> -->
<!--         <div class="card h-100"> -->
<!--           <div class="card-body"> -->
<!--             <h4 class="card-title">청담 자이</h3> -->
<!--               <p style="font-size:0.7rem;color:#818a91;" class="card-text">서울특별시 강남구 청담동 영동대로138길 12</p> -->
<!--               <p class="card-text"><strong>거래금액</strong> 700,000.000원</p> -->
<!--               <p class="card-text"><strong>면적</strong> 110.82 (m^2)</p> -->
<!--               <p class="card-text"><strong>최근거래일시</strong> 2020.09.21</p> -->
<!--           </div> -->
<!--           <div class="card-footer text-right"> -->
<!--             <a href="#" class="btn btn-primary">자세히 보기</a> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--       <div class="col-lg-3 col-md-6 mb-4"> -->
<!--         <div class="card h-100"> -->
<!--           <div class="card-body"> -->
<!--             <h4 class="card-title">청담 자이</h3> -->
<!--               <p style="font-size:0.7rem;color:#818a91;" class="card-text">서울특별시 강남구 청담동 영동대로138길 12</p> -->
<!--               <p class="card-text"><strong>거래금액</strong> 700,000.000원</p> -->
<!--               <p class="card-text"><strong>면적</strong> 110.82 (m^2)</p> -->
<!--               <p class="card-text"><strong>최근거래일시</strong> 2020.09.21</p> -->
<!--           </div> -->
<!--           <div class="card-footer text-right"> -->
<!--             <a href="#" class="btn btn-primary">자세히 보기</a> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--       <div class="col-lg-3 col-md-6 mb-4"> -->
<!--         <div class="card h-100"> -->
<!--           <div class="card-body"> -->
<!--             <h4 class="card-title">청담 자이</h3> -->
<!--               <p style="font-size:0.7rem;color:#818a91;" class="card-text">서울특별시 강남구 청담동 영동대로138길 12</p> -->
<!--               <p class="card-text"><strong>거래금액</strong> 700,000.000원</p> -->
<!--               <p class="card-text"><strong>면적</strong> 110.82 (m^2)</p> -->
<!--               <p class="card-text"><strong>최근거래일시</strong> 2020.09.21</p> -->
<!--           </div> -->
<!--           <div class="card-footer text-right"> -->
<!--             <a href="#" class="btn btn-primary">자세히 보기</a> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--       <div class="col-lg-3 col-md-6 mb-4"> -->
<!--         <div class="card h-100"> -->
<!--           <div class="card-body"> -->
<!--             <h4 class="card-title">청담 자이</h3> -->
<!--               <p style="font-size:0.7rem;color:#818a91;" class="card-text">서울특별시 강남구 청담동 영동대로138길 12</p> -->
<!--               <p class="card-text"><strong>거래금액</strong> 700,000.000원</p> -->
<!--               <p class="card-text"><strong>면적</strong> 110.82 (m^2)</p> -->
<!--               <p class="card-text"><strong>최근거래일시</strong> 2020.09.21</p> -->
<!--           </div> -->
<!--           <div class="card-footer text-right"> -->
<!--             <a href="#" class="btn btn-primary">자세히 보기</a> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
    </div>
    <!-- /.row -->

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
  <script src="/static//vendor/jquery/jquery.min.js"></script>
  <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script>$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
  })</script>
</body>

</html> 
