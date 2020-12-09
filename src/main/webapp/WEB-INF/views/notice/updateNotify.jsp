<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="HappySsafy">
  <meta name="author" content="박재현/김지현">
  <title>공지사항 수정 - 관리자 모드</title>
  <!-- Bootstrap core CSS -->
  <link href="/staic/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="/static/css/deallist.css" rel="stylesheet">
<link href="/static/css/fontinit.css" rel="stylesheet">
  
  <!-- custom Css -->
</head>
<body>
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-3 col-lg-3"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-lg-12 mx-auto">
              <h3 class="login-heading mb-4">공지사항 수정</h3>
              <form action="updateNotify" method="post" id="updateNoticeForm" >
                <div class="form-label-group">
                  <input type="text" value="${noticeVO.notice_number}" name="notice_number" id="notice_number" class="form-control" placeholder="" required autofocus hidden >
                  <label for="title">공지사항 제목</label>
                  <input type="text" value="${noticeVO.notice_title}" name="notice_title" id="notice_title" class="form-control" placeholder="" required autofocus>
                </div>

                <div class="form-label-group">
                  <label for="descrip">공지사항 내용</label>
                  <input type="text" value="${noticeVO.notice_describ}" name="notice_describ" id="notice_describ" class="form-control" placeholder="" required>
                </div>
                <br><br>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" name="updateNoticeBtn" id="updateNoticeBtn">글 수정</button>
                <br>
              </form>
              <a href="notify" class="text-white btn btn-lg btn-success btn-block btn-login text-uppercase font-weight-bold mb-2" >돌아가기</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- Bootstrap core JavaScript -->
  <script src="/static/vendor/jquery/jquery.min.js"></script>
  <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  <script>
  	$("#updateNoticeBtn").click(function() {
  		if ($('#notice_title').val().trim() == ''){
  			alert('공지 제목을 입력하세요.');
  			$('#notice_title').focus();
	  		return;
  		}
  		if ($('#notice_describ').val().trim() == ''){
  			alert("공지 내용을 입력하세요.");
  			$('#notice_describ').focus();
  			return;
  		}
  		$("#updateNoticeForm").submit();
  	});
  </script>  
</body>

</html>
