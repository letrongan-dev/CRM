package com.myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.myproject.implement.UserDao;
import com.myproject.entity.User;

@WebServlet(urlPatterns = { "/user", "/user/add", "/user/edit", "/user/delete" })
public class UserServlet extends HttpServlet {

	UserDao userDao = null;
	String pathIndex = "/WEB-INF/user/index.jsp";
	String pathAdd = "/WEB-INF/user/add.jsp";
	String pathEdit = "/WEB-INF/user/edit.jsp";
	
	
    public UserServlet() {
    	userDao = new UserDao();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		//System.out.println(action);
		switch (action) {
		case "/user":
			req.setAttribute("listUser", userDao.getAll());
			req.getRequestDispatcher(pathIndex).forward(req, resp);
			break;
		case "/user/add":
			req.getRequestDispatcher(pathAdd).forward(req, resp);
			break;
		case "/user/edit":
			int idEdit = Integer.valueOf(req.getParameter("id"));
			User userEdit = (User) userDao.getById(idEdit);
			req.setAttribute("userEdit", userEdit);
			req.getRequestDispatcher(pathEdit).forward(req, resp);
			break;
		case "/user/delete":
			int idDel = Integer.valueOf(req.getParameter("id"));
			userDao.delete(idDel);
			resp.sendRedirect(req.getContextPath()+"/user");
			break;
		default:
			break;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		String action = req.getServletPath();
		
		switch (action) {
		case "/user/add":
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
			User user = new User(name, email, hashed, role);
			userDao.add(user);
			break;
		case "/user/edit":
			int idEdit = Integer.parseInt(req.getParameter("id"));
			user = (User) userDao.getById(idEdit);
			user.setEmail(email);
			user.setName(name);
			user.setRole(role);
			userDao.update(user);
			System.out.println(idEdit);
			break;			
		default:
			break;
		}
		resp.sendRedirect(req.getContextPath()+"/user");
	}
}
