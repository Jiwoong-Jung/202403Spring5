<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과 화면</h1>
${loginRequest.id} 님 환영합니다.<br>
${loginRequest.email}<br>
${str}

<a href="${pageContext.request.contextPath}/">홈으로</a>
</body>
</html>