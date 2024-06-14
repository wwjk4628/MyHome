<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/home.css" />
</head>
<body>
	<div id="container">

		<jsp:include page="/WEB-INF/views/includes/header.jsp">
			<jsp:param value="value1" name="param1" />
			<jsp:param value="value2" name="param2" />
		</jsp:include>

		<jsp:include page="/WEB-INF/views/includes/navigation.jsp">
			<jsp:param value="value1" name="param1" />
			<jsp:param value="value2" name="param2" />
		</jsp:include>

		<div id="wrapper">
			<div id="content">
				<!-- Content 영역 -->
				<%-- <p>
					<a href="<%=request.getContextPath()%>/users?a=loginform">로그인</a>
				</p>
				<p>
					<a href="<%=request.getContextPath()%>/users?a=joinform">회원가입</a>
				</p>
 --%>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>