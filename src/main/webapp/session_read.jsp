<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Session 읽기</h3>
	<%
	
	String sess1 = (String)session.getAttribute("sess1");
	Integer sess2 = (Integer)session.getAttribute("sess2");
	%>
	<ul>
		<li>문자열 세션: <%= sess1 %></li>
		<li>정수 세션: <%= sess2 %></li>
	</ul>
	
	<P><a href="session_delete.jsp">세션 삭제</a></P>
	<P><a href="session_write.jsp">세션 기록</a></P>
</body>
</html>