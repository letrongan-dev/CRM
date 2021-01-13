package com.myproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.myproject.entity.User;
import com.myproject.implement.UserDao;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet(urlPatterns = {"/login","/logout"})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userDao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/login":
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
			break;
		case "/logout":
			HttpSession session = request.getSession();
			session.removeAttribute("LOGIN");
			response.sendRedirect(request.getContextPath()+"/login");
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userDao.findByEmail(email);
		boolean flag = BCrypt.checkpw(password, user.getPassword());
		
		if(user == null) {
			request.setAttribute("err", "Tài khoản không tồn tại!");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		}else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", user);
				response.sendRedirect(request.getContextPath()+"/profile");
			}else {
				request.setAttribute("err", "Sai email or mật khẩu!");
				request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
			}
		};
	}

}
