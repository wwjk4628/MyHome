package himedia.myhome.controller;

import java.io.IOException;

import himedia.myhome.dao.UsersDao;
import himedia.myhome.dao.UsersDaoOracleImpl;
import himedia.myhome.vo.UserVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// a=joinform -> 가입폼 페이지로 FORWARD
		// a=joinsuccess -> 가입 성공 페이지로 FORWARD
		String actionName = req.getParameter("a");
		if ("joinform".equals(actionName)) {
			// 가입 폼으로 Forward
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		} else if ("joinsuccess".equals(actionName)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else if ("loginform".equals(actionName)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/loginform.jsp");
			rd.forward(req, resp);
		} else if ("loginsuccess".equals(actionName)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else {
			// 홈페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/");
		}
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");

		if ("join".equals(actionName)) {

			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			UsersDao dao = new UsersDaoOracleImpl(dbuser, dbpass);
			UserVo vo = new UserVo(name, password, email, gender);
			boolean success = dao.insert(vo);
			if (success) {
				System.out.println("INSERT SUCCESS");
				resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");

			} else {
				System.out.println("INSERT FAILED");
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "가입 실패");
//				resp.sendRedirect(req.getContextPath() + "/users?a=joinform");
			}

		} else if ("login".equals(actionName)) {
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			UsersDao dao = new UsersDaoOracleImpl(dbuser, dbpass);
			UserVo vo = dao.getUserByIdAndPassword(email, password);
			if (email.equals(vo.getEmail()) && password.equals(vo.getPassword())) {

				resp.sendRedirect(req.getContextPath() + "/users?a=loginsuccess");
			} else {
				System.out.println(vo.getEmail() + vo.getPassword() + password);
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "로그인 실패");
			}

		} else {

			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			super.doPost(req, resp);
		}
	}

}
