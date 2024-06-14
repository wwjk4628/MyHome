<%@page import="himedia.myhome.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%
UserVo authUser = (UserVo) session.getAttribute("authUser");
%>
<div id="header">
	<h1>My Homepage</h1>
	<%
	if (authUser != null) {
	%>
	<ul>
		<li><%=authUser.getName()%>님 환영합니다.</li>
		<li><a href="<%=request.getContextPath()%>/users?a=logout">로그아웃</a></li>
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
	%>
</div>