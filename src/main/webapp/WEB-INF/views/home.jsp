<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/home.css' />" />

</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/includes/header.jsp">
			<c:param name="param1" value="value1"></c:param>
			<c:param name="param2" value="value2"></c:param>
		</c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="param1" value="value1"></c:param>
			<c:param name="param2" value="value2"></c:param>
		</c:import>
		<%-- <jsp:include page="/WEB-INF/views/includes/header.jsp">
			<jsp:param value="value1" name="param1" />
			<jsp:param value="value2" name="param2" />
		</jsp:include>

		<jsp:include page="/WEB-INF/views/includes/navigation.jsp">
			<jsp:param value="value1" name="param1" />
			<jsp:param value="value2" name="param2" />
		</jsp:include> --%>

		<div id="wrapper">
			<div id="content">
				<!-- Content 영역 -->
				
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>