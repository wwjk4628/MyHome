<%@page import="himedia.myhome.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<%
UserVo authUser = (UserVo) session.getAttribute("authUser");
%>
<div id="header">
	<h1>My Homepage</h1>
	<c:choose>
		<c:when test="${authUser != null}">
			<ul>
				<li><a href="<%=request.getContextPath()%>/users?a=logout">로그아웃</a></li>
				<li>${authUser.name }님환영합니다.</li>
				<li></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="<c:url value="/users?a=joinform" />">회원가입</a></li>
				<li><a href="<c:url value="/users?a=loginform" />">로그인</a></li>
				
			</ul>
		</c:otherwise>
	</c:choose>
	<%-- <%
	if (authUser != null) {
	%>
	<ul>
		<li><a href="<%=request.getContextPath()%>/users?a=logout">로그아웃</a></li>
		<li>${authUser.name }님환영합니다.</li>
		<li></li>
	</ul>
	<%
	} else {
	%>
	<ul>
		<li><a href="<%=request.getContextPath()%>/users?a=joinform">회원가입</a></li>
		<li><a href="<%=request.getContextPath()%>/users?a=loginform">로그인</a></li>


	</ul>
	<%
	}
	%> --%>
</div>