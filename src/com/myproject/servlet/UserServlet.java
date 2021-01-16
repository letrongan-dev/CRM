package com.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.myproject.implement.TaskDao;
import com.myproject.implement.UserDao;
import com.google.gson.Gson;
import com.myproject.entity.User;

@WebServlet(urlPatterns = { "/user", "/user/add", "/user/edit", "/user/delete" ,"/profile","/available","/available-name"})
public class UserServlet extends HttpServlet {
	TaskDao taskDao = null;
	UserDao userDao = null;
	String pathIndex = "/WEB-INF/user/index.jsp";
	String pathAdd = "/WEB-INF/user/add.jsp";
	String pathEdit = "/WEB-INF/user/edit.jsp";
	String pathProfile = "/WEB-INF/user/profile.jsp";
	
	
    public UserServlet() {
    	userDao = new UserDao();
    	taskDao = new TaskDao();
    }
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		String action = req.getServletPath();
		//System.out.println(action);
		
		Gson gson = new Gson();
        String jsonData = null;
        PrintWriter out = resp.getWriter();
        
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
		case "/profile":
			HttpSession session = req.getSession();
			User login = (User) session.getAttribute("LOGIN");
			req.setAttribute("listTaskUser", taskDao.getTaskByUser(login.getId()));
			req.setAttribute("countStatus1", taskDao.count(1,login.getId()));
			req.setAttribute("countStatus2", taskDao.count(2,login.getId()));
			req.setAttribute("countStatus3", taskDao.count(3,login.getId()));
			req.getRequestDispatcher(pathProfile).forward(req, resp);
			break;
		case "/available":
			boolean isUser;
			String email = req.getParameter("email");
			User user = userDao.findByEmail(email);
			if(user != null) {
				isUser = false;
			}else {
				isUser = true;
			}
//			System.out.println(email);
//			System.out.println(user);
//			System.out.println(isUser);
	        jsonData = gson.toJson(isUser);
	        out.write(jsonData);
	        out.close();
			break;
		case "/available-name":
			boolean isUserByName;
			String name = req.getParameter("name");
			User userByName;
			try {
				userByName = userDao.findByName(name);
				if(userByName != null) {
					isUserByName = false;
				}else {
					isUserByName = true;
				}
//				System.out.println(name);
//				System.out.println(userByName);
//				System.out.println(isUserByName);
				jsonData = gson.toJson(isUserByName);
		        out.write(jsonData);
		        out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
