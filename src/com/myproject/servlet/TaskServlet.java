package com.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.implement.TaskDao;
import com.myproject.implement.UserDao;
import com.myproject.entity.Task;

@WebServlet(urlPatterns = {"/task","/task/add"})
public class TaskServlet extends HttpServlet{
	TaskDao taskDao = null;
	UserDao userDao = null;
	String pathIndex = "/WEB-INF/task/index.jsp";
	String pathAdd = "/WEB-INF/task/add.jsp";
	
	public TaskServlet() {
		taskDao = new TaskDao();
		userDao = new UserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case "/task":
			req.setAttribute("listTask", taskDao.getAll());
			req.getRequestDispatcher(pathIndex).forward(req, resp);
			break;
		case "/task/add":
			req.setAttribute("listUser", userDao.getAll());
			req.getRequestDispatcher(pathAdd).forward(req, resp);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
