<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러화면</title>
</head>
<body>
<h1>문제가 발생했습니다. 2초후 홈으로 이동합니다.</h1>
<h2>오류원인 : ${errorMsg}</h2>
<script type='text/javascript'>
setTimeout("location.href='/'",2000);
</script>


</body>
</html>