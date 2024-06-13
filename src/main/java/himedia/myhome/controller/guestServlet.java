package himedia.myhome.controller;

import java.io.IOException;
import java.util.List;

import himedia.myhome.controller.BaseServlet;
import himedia.myhome.dao.GuestBookDao;
import himedia.myhome.dao.GuestBookDaoImple;
import himedia.myhome.vo.GuestBookVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gb")
public class guestServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 a=form이면 입력 폼으로 이동1
		String actionName = req.getParameter("a");
		if ("form".equals(actionName)) {
			// 사용자 입력 페이지로 FORWARD
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(req, resp);
		} else {
			// 목록 받아오는 부분 -> /el
			GuestBookDao dao = new GuestBookDaoImple(dbuser, dbpass);
			List<GuestBookVo> list = dao.getList();

			// list를 요청 객체에 추가
			req.setAttribute("list", list);
			// list 객체를 jsp로 FORWARD
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/guestbook/index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String actionName = req.getParameter("a");

		if ("add".equals(actionName)) {
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			String content = req.getParameter("content");
			GuestBookDao dao = new GuestBookDaoImple(dbuser, dbpass);
			GuestBookVo vo = new GuestBookVo(name, pass, content);
		
			boolean success = dao.insert(vo);
			if (success) {
				System.out.println("INSERT SUCCESS");
			} else {
				System.out.println("INSERT FAILED");
			}

			resp.sendRedirect(req.getContextPath() + "/gb");
		} else if ("delete".equals(actionName)) {
			String password = req.getParameter("password");
			Long no = Long.parseLong(req.getParameter("no"));
			GuestBookDao dao = new GuestBookDaoImple(dbuser, dbpass);
			GuestBookVo vo = dao.get(no);
			System.out.println(password);
			System.out.println(no);
			System.out.println(vo);
			if (vo.getPass().equals(password)){
			boolean success = dao.delete(password, no);
			if (success){
				System.out.println("DELETE SUCCESS");
			} else {
				System.out.println("DELETE FAILED");
			}
			}

			resp.sendRedirect(req.getContextPath() + "/gb");
		} else {
			super.doPost(req, resp);
		}
	}

}
