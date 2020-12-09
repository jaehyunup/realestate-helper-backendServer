<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="HappySaffy">
<meta name="author" content="박재현/김상훈">
<title>Happy House</title>
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
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=306b5419fdd18e5190a8d2bc257002b0&libraries=services"></script>
<!-- jQuery -->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<!--장소 리스트 script -->
<script type="text/javascript" src="/static/js/LocationList.js"></script>
</head>

<body>
	<!-- 모달 정의-->
	<div id="modal1" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">상권 및 환경분석 정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- 상권분석-->
					<h2>상권분석 결과</h2>
					<hr>
					<br>
					<div>
						<section id="tabs" class="project-tab">
							<div class="container">
								<div class="row">
									<div class="col-md-12">
										<nav>
											<div class="nav nav-tabs nav-fill" id="nav-tab"
												role="tablist">
												<a class="nav-item nav-link active" id="nav-home-tab"
													data-toggle="tab" href="#nav-home" role="tab"
													aria-controls="nav-home" aria-selected="true">일반음식점</a> <a
													class="nav-item nav-link" id="nav-profile-tab"
													data-toggle="tab" href="#nav-profile" role="tab"
													aria-controls="nav-profile" aria-selected="false">의료시설</a>
												<a class="nav-item nav-link" id="nav-contact-tab"
													data-toggle="tab" href="#nav-contact" role="tab"
													aria-controls="nav-contact" aria-selected="false">편의시설</a>
											</div>
										</nav>
										<div class="tab-content" id="nav-tabContent">
											<div class="tab-pane fade show active" id="nav-home"
												role="tabpanel" aria-labelledby="nav-home-tab">
												<table class="table" cellspacing="0">
													<thead>
														<tr>
															<th>상호명</th>
															<th>주소</th>
															<th>전화번호</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>맛나네 집밥</td>
															<td>강남구 청담동 313-1</td>
															<td>02-524-1543</td>
														</tr>
														<tr>
															<td>소고기 마을</td>
															<td>강남구 청담동 영동대로 12길 22</td>
															<td>02-523-1355</td>
														</tr>
														<tr>
															<td>브로콜리 매니아</td>
															<td>강남구 청담동 77-1</td>
															<td>02-523-5553</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="tab-pane fade" id="nav-profile" role="tabpanel"
												aria-labelledby="nav-profile-tab">
												<table class="table" cellspacing="0">
													<thead>
														<tr>
															<th>상호명</th>
															<th>주소</th>
															<th>전화번호</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>재현 병원</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
														<tr>
															<td>상훈 산부인과</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
														<tr>
															<td>재훈 내과</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="tab-pane fade" id="nav-contact" role="tabpanel"
												aria-labelledby="nav-contact-tab">
												<table class="table" cellspacing="0">
													<thead>
														<tr>
															<th>상호명</th>
															<th>주소</th>
															<th>전화번호</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>GS25</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
														<tr>
															<td>세븐일레븐</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
														<tr>
															<td>CU</td>
															<td>강남구 청담동 32-1</td>
															<td>02-523-1323</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</section>
					</div>
					<br> <br>

					<!--환경분석결과-->

					<div>
						<h2>환경분석결과</h2>
						<hr>
						<br>
						<table class="table" cellspacing="0">
							<thead>
								<tr>
									<th>활동명</th>
									<th>활동기관</th>
									<th>일시</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>쓰레기 배출</td>
									<td>강남구청</td>
									<td>2020.09.21</td>
								</tr>
								<tr>
									<td>쓰레기 소각</td>
									<td>강남 쓰레기센터</td>
									<td>2020.09.19</td>
								</tr>
								<tr>
									<td>분리수거 폐기물 소각</td>
									<td>강남 쓰레기소각장</td>
									<td>2020.09.11</td>
								</tr>
							</tbody>
						</table>
					</div>

					<hr>
					<div></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



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
					<li class="nav-item active"><a class="nav-link" href="/deal">실거래가
							검색</a></li>
					<li class="nav-item"><a class="nav-link" href="/notice/notify">공지사항</a>
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
		<div class="container">
			<form action="#" method="post" novalidate="novalidate">
				<div class="row">
					<div class="col-lg-12">
						<div class="row justify-content-md-left">
							<div class="col-lg-2 col-md-2 col-sm-12 p-0">
								<select class="form-control search-slt" id="sOption1">

								</select>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-12 p-0">
								<select class="form-control search-slt" id="sOption2">

								</select>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-12 p-0">
								<select class="form-control search-slt" id="sOption3">

								</select>
							</div>
							<div class="col-lg-1 col-md-1 col-sm-12 p-0">
								<button id="sBtn" type="button" class="btn btn-primary wrn-btn">
									<i style="color: black" class="fas fa-search"></i>
								</button>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-12 p-0">
								<button id="attBtn" type="button"
									class="btn btn-dark servicebtn">관심지역으로 추가</button>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-12 p-0">
								<button type="button" class="btn btn-dark servicebtn"
									data-toggle="modal" data-target="#modal1">상권/환경분석</button>
							</div>

						</div>
					</div>
				</div>
				<c:if test="${not empty sessionScope.user_id}">
					<div class="row">
						<div class="col-lg-12">
							<blockquote class="blockquote mt-4">
								<h5>
									<strong>${sessionScope.user_id}님의 관심지역 목록</strong>
								</h5>
							</blockquote>
						</div>
						<div id="attentionDiv" class="col-lg-12"></div>
					</div>
				</c:if>
				<c:if test="${empty sessionScope.user_id}">
				<blockquote class="blockquote mt-4">
					<h5>
						<strong>관심지역 모아보기</strong>
					</h5>
	
					<p style="color: red; font-weight: bold;">* 관심지역 기능은 로그인된 사용자에게만 제공됩니다
				</blockquote>
				</c:if>
				
			</form>
		</div>
	</div>

	<script>
		initSido();
		initGugun();
		initDong();
	</script>
	<!--검색버튼 이벤트 script -->
	<script type="text/javascript" src="/static/js/SelectDeal.js"></script>
	<script>
		/* 관심지역 추가*/
		$("#attBtn")
				.on("click",
						function() {
							var at_id = '<c:out value="${sessionScope.user_id}"/>'
							if (at_id != ('')) {
								$
										.ajax({
											url : "attention/put",
											type : "put",
											dataType : "json",
											async : false,
											data : {
												user_id : at_id,
												dong : $("#sOption3 option:selected").html()
											},
											success : function(data) {
												alert("관심지역에 추가되었습니다");
												getAttention();
											},
											error : function(xhr) {
												
												alert('이미 추가된 관심지역입니다\n 상태코드 : '
														+ xhr.status
														+ '\n\n'
														+ xhr.statusText);
											}
										})
							}
						});
		/* 관심지역은document가 로딩될때, user_id를 확인한다 */
		function getAttention() {
			var at_id = '<c:out value="${sessionScope.user_id}"/>'
			if (at_id != '') {
				$
						.ajax({
							url : "attention/list",
							type : "get",
							dataType : "json",
							async : false,
							data : {
								user_id : at_id
							},
							success : function(data) {
								if (data.length == 0) {
									$("#attentionDiv").append(
											$("<p>등록된 관심지역이 없습니다</p>"))
								} else {
									$("#attentionDiv").empty();
									$
											.each(
													data,
													function(index, item) {
														$newAttention = $("<a style='font-weight:bold;' class='btn btn-info my-1 mx-1 text-white'>"
																+ item.dong
																+ "</a>")
														$newAttention
																.on(
																		"click",
																		function() {
																			dealSelectByAttentionList(item.dong);
																		})
														$("#attentionDiv")
																.append(
																		$newAttention)
													})
								}
							},
							error : function(xhr) {
								alert('관심지역을 가져오는중 문제가 발생했습니다.\n상태코드 : '
										+ xhr.status + '\n\n' + xhr.statusText);
							}
						})
			}
		};

		$(document).ready(function() {
			getAttention()
		})
	</script>



	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-7 col-md-12">
				<!-- 관심지역 -->
				
				<!--거래목록 라벨-->
				<blockquote class="blockquote mt-4">
					<h5>
						<strong id="currentDong"></strong>이 소속된 군/구 병원정보
					</h5>
					<div class="row">
						<div class="col-md-3 col-sm-12 p-0 my-2">
							<button id="hospitalBtn" type="button"
								class="btn btn-primary servicebtn">안심 병원보기</button>
						</div>
						<div class="col-md-3 col-sm-12 p-0 mx-2 my-2">
							<button id="clinicBtn" type="button"
								class="btn btn-danger servicebtn">선별 진료소보기</button>
						</div>
					</div>
					<p style="color: red; font-weight: bold;">* 거래목록 클릭시 지도에 거래발생
						주택/아파트 위치를 보여줍니다</p>
				</blockquote>
				<div id="h_table_div" class="col-md-12 mt-4">
					<table id="h_table" class="table table-striped header-fixed">

					</table>
				</div>

				<h5>
					<strong id="currentDong"></strong> 최근거래목록
				</h5>
				<!--페이지네이션-->
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-md-left">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1">이전으로</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">다음으로</a>
						</li>
					</ul>
				</nav>


				<!-- 거래목록 개행, 1행에는 3개의열이 들어감-->
				<div id="dealRow" class="row"></div>
			</div>
			<!--왼쪽 섹터 끝-->

			<!--오른쪽 섹터 시작-->

			<div class="col-lg-4 col-md-12">
				<div class="row">
					<div id="map" class="col-lg-12 col-md-12"
						style="margin-left: 1rem; margin-top: 2rem; height: 35rem; margin-bottom: 10rem;">
					</div>
				</div>
				<!--오른쪽 섹터 끝-->
			</div>
		</div>
		<!-- /.container -->

		<!-- Footer -->
		<footer class="py-2 bg-dark">
			<div class="container">
			</div>
			<!-- /.container -->
		</footer>

		<!-- Bootstrap core JavaScript -->
		<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!--kakao map code-->
		<script type="text/javascript" src="/static/js/kakaoMap.js"></script>
		<script type="text/javascript" src="/static/js/hospital.js"></script>
		<script type="text/javascript" src="/static/js/clinic.js"></script>


		<!--장소 리스트 script -->
		<script type="text/javascript" src="/static/js/LocationList.js"></script>
</body>

</html>