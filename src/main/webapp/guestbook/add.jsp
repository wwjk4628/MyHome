<%@page import="himedia.myhome.vo.GuestBookVo"%>
<%@page import="himedia.myhome.dao.GuestBookDaoImple"%>
<%@page import="himedia.myhome.dao.GuestBookDao"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 데이터베이스 접속 정보 확인1
ServletContext context = getServletContext();

String dbuser = context.getInitParameter("dbuser");
String dbpass = context.getInitParameter("dbpass");

//	폼 입력 데이터
String name = request.getParameter("name");
String pass = request.getParameter("pass");
String content = request.getParameter("content");

GuestBookDao dao = new GuestBookDaoImple(dbuser, dbpass);
GuestBookVo vo = new GuestBookVo(name, pass, content);
boolean success = dao.insert(vo);

if (success) {	//	INSERT 성공
	response.sendRedirect(request.getContextPath() + "/guestbook/list.jsp");
} else {
		%>
		<h1>Error</h1>
		<p>데이터 입력 중 오류가 발생했습니다</p>
		<%
}

%>
