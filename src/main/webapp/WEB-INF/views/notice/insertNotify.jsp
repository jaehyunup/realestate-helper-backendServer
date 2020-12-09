<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="HappySaffy">
  <meta name="author" content="park and kim">
  <title>공지사항 등록 화면</title>
  <!-- Bootstrap core CSS -->
  <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
              <h3 class="login-heading mb-4">공지사항 작성</h3>
              <form action="insertNotify" method="post" id="addNoticeForm">
                <div class="form-label-group">
                  <label for="title">공지사항 제목</label>
                  <input type="text" name="notice_title" id="notice_title" class="form-control" placeholder="" required autofocus>
                </div>

                <div class="form-label-group">
                  <label for="descrip">공지사항 내용</label>
                  <input type="text" name="notice_describ"  id="notice_describ" class="form-control" placeholder="" required>
                </div>
                <br><br>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" name="addNoticeBtn" id="addNoticeBtn">등록 완료</button>
                <br>
              </form>
              	<a href="<c:url value='/notice/notify' />" class="text-white btn btn-lg btn-success btn-block btn-login text-uppercase font-weight-bold mb-2"> 돌아가기</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script>
  	$("#addNoticeBtn").click(function() {
  		if ($('#title').val().trim() == ''){
  			alert('공지 제목을 입력하세요.');
  			$('#title').focus();
	  		return;
  		}
  		if ($('#descrip').val().trim() == ''){
  			alert("공지 내용을 입력하세요.");
  			$('#descrip').focus();
  			return;
  		}
  		$("#addNoticeForm").submit();
  	});
  </script>
</body>

</html>
