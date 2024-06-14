<%@ page language="java"
	contentType="text/html;
	charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css"/>
<title>My Home: Join Success</title>
</head>
<body>
	<div id="container">
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
	
	<div id="wrapper">
	<div id="content">
	<h1>Login Success</h1>
	<p>로그인 성공.</p>
<%-- 	<p><a href="<%=request.getContextPath()%>/">My Home</a></p> --%>
	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>

