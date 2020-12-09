<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="HappySsafy">
<meta name="author" content="박재현/김지현">
<style>
.notice:first-child {
	margin-top: 10px;
}

.notice:last-child {
	margin-bottom: 10px;
}

.notice {
	padding: 15px;
	background-color: #fafafa;
	border-left: 6px solid #7f7f84;
	margin-bottom: 10px;
	-webkit-box-shadow: 0 5px 8px -6px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 5px 8px -6px rgba(0, 0, 0, .2);
	box-shadow: 0 5px 8px -6px rgba(0, 0, 0, .2);
}

.notice-sm {
	padding: 10px;
	font-size: 20px;
}

.notice>.desc {
	display: none;
}

.readMore {
	cursor: pointer;
}

.detail {
	font-size: medium;
	margin: 20px;
}
</style>

<title>Happy House - 공지사항</title>
<!-- Bootstrap core CSS -->
<link href="/static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="/static/css/deallist.css" rel="stylesheet">
<link href="/static/css/fontinit.css" rel="stylesheet">

<!--kakao map api-->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=306b5419fdd18e5190a8d2bc257002b0"></script>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Happy House</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/">홈 <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/about">소개</a>
					</li>
					<li class="nav-item "><a class="nav-link" href="/sitemap">사이트맵</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/deal">실거래가
							검색</a></li>
					<li class="nav-item active"><a class="nav-link" href="/notice/notify">공지사항</a>
					</li>
					<c:choose>
						<c:when test="${sessionScope.user_auth==null}">
							<li class="nav-item"><a href="/login"
								class="text-white nav-link btn btn-info mx-2 md-1">로그인</a></li>
							<li class="nav-item"><a href="/user/register"
								class="text-white nav-link btn btn-success mx-2 md-1">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${sessionScope.user_auth=='admin'}">
								<li class="nav-item"><a href=/adminPage
									class="text-white nav-link btn btn-danger mx-2 md-1">관리자메뉴</a>
								</li>
							</c:if>
							<li class="nav-item"><a
								href="/user/modify?user_id=${sessionScope.user_id}"
								class="text-white nav-link btn btn-danger mx-2 md-1">회원정보수정</a>
							</li>
							<li class="nav-item"><a href="/logout"
								class="text-white nav-link btn btn-danger mx-2 md-1">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<!--검색 창-->
	<div class="search-sec">
		<div class="container-fluid">
			<form action="#" method="post" novalidate="novalidate">
				<div class="row">
					<div class="col-lg-12">
						<div class="row justify-content-md-left">
							<h2 style="margin-bottom: 20px;">공지사항</h2>
						</div>
						<c:forEach var="noticeVO" items="${requestScope.list}">
							<div class="notice notice-sm">
								<strong><c:out value="${noticeVO.notice_title}" /></strong> <span
									class="pull-right readMore"
									style="color: rgba(0, 0, 0, .3); font-weight: bold;">자세히</span>
								<a
									href="updateNotify?number=<c:out value='${noticeVO.notice_number}'/>"
									class="btn btn-warning">글수정</a> <a
									value="${noticeVO.notice_number}"
									class="notifyDelbtn btn btn-danger">글삭제</a>
								<div class="desc">
									<p class="detail input">${noticeVO.notice_describ }</p>
								</div>
							</div>
						</c:forEach>


					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="text-right">
		<a href="<c:url value='/notice/insertNotify' />"
			class="btn btn-primary">등록</a>
		<!-- 
		<a href="insertNotify" class="btn btn-primary">글쓰기</a>
		 -->
	</div>
	<!-- Footer -->
	<footer class="py-2 bg-dark " style="position: fixed; bottom: 0;">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; 박재현&김지현
				2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="/static/vendor/jquery/jquery.min.js"></script>
	<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!--kakao map code-->
	<script type="text/javascript" src="js/kakaoMap.js"></script>
	<script>
		$(".notifyDelbtn").each(
				function(index, item) {
					$(item).on(
							"click",
							function() {
								if (confirm("글을 삭제하시겠습니까?")) {
									$(location).attr(
											'href',
											'deleteNotify?number='
													+ $(item).attr("value"));
								}
							})
				})

		$(document).ready(function() {

			$(".readMore").click(function() {
				var This = $(this);
				$(this).next().next().next().toggle(function() {
					if (This.text() == "자세히") {
						This.text("숨기기")
					} else {
						This.text("자세히")
					}
				})
			});
		})
	</script>
</body>

</html>


