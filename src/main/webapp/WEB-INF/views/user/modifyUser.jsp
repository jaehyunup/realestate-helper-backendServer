<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="HappySaffy">
  <meta name="author" content="박재현/김상훈">
  <title>회원정보수정</title>
  <!-- Bootstrap core CSS -->
  <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- custom Css -->
  <link rel="stylesheet" type="text/css" href="/static/css/login.css">
</head>
<body>
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">회원정보 수정</h3>
              <form action="/user/modify" method="POST">
                <div class="form-label-group">
                  <input type="email" name="user_id" value='${requestScope.user_id}' id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                  <label for="inputEmail">아이디(이메일)</label>
                </div>

                <div class="form-label-group">
                  <input type="password" name="user_pw" value='${requestScope.user_pw}' id="inputPassword" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">(기존 비밀번호)변경할 비밀번호</label>
                </div>
                
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">수정하기</button>
              </form>
              
              <form action="/user/delete" method="POST">
              		<input class="btn btn-lg btn-danger btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" value="회원탈퇴하기"/>
           		    <input type="hidden" id="hidden_id" id="user_id" value='${requestScope.user_id}'>
              </form>
              <a href="/home" class="text-white btn btn-lg btn-success btn-block btn-login text-uppercase font-weight-bold mb-2" >돌아가기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- Bootstrap core JavaScript -->
  <script src="/static/vendor/jquery/jquery.js"></script>
  <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
