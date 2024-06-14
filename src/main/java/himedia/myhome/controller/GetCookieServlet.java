package himedia.myhome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class GetCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		String actionName = req.getParameter("a");
		if ("delete".equals(actionName)) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie:cookies) {
				if (cookie.getName().equals("testCookie")) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					out.println("<p>testCookie를 삭제했습니다.</p>");
				}
			}
		
			
		} else {
			out.println("<h1>쿠키목록</h1>");
			out.println("<ul>");
			
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie: cookies) {
				out.printf("<li>%s: %s - MaxAge: %d</li>",
						cookie.getName(),
						cookie.getValue(),
						cookie.getMaxAge());
			}
		}
		
	}
	

}
