<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
// 어떤 타입의 객체도 담을 수 있다.
session.setAttribute("sess1", "문자열 세션");
session.setAttribute("sess2", 2024);

// 세션 유지 기한
session.setMaxInactiveInterval(2 * 60* 60);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 변수 저장</h3>
	<p><a href="session_read.jsp">세션 변수 확인</a></p>
</body>
</html>