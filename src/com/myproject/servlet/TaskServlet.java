package com.myproject.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.implement.TaskDao;
import com.myproject.implement.UserDao;
import com.myproject.entity.Task;

@WebServlet(urlPatterns = {"/task","/task/add","/task/edit", "/task/delete"})
public class TaskServlet extends HttpServlet{
	TaskDao taskDao = null;
	UserDao userDao = null;
	String pathIndex = "/WEB-INF/task/index.jsp";
	String pathAdd = "/WEB-INF/task/add.jsp";
	String pathEdit = "/WEB-INF/task/edit.jsp";
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
		case "/task/edit":
			int idEdit = Integer.valueOf(req.getParameter("id"));
			Task task = (Task) taskDao.getById(idEdit);
			req.setAttribute("taskEdit", task);
			req.getRequestDispatcher(pathEdit).forward(req, resp);
			break;
		case "/task/delete":
			int idDel = Integer.valueOf(req.getParameter("id"));
			taskDao.delete(idDel);
			resp.sendRedirect(req.getContextPath()+"/task");
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		
		
		switch (action) {
		case "/task/add":
			String shortDesc = req.getParameter("shortDesc");
			String desc = req.getParameter("desc");
			int status = Integer.valueOf(req.getParameter("status"));
			int userId = Integer.valueOf(req.getParameter("userId"));
			Date startDate = Date.valueOf(req.getParameter("startDate"));
			Date endDate = Date.valueOf(req.getParameter("endDate"));
			Task task = new Task(shortDesc, desc, startDate, endDate, userId, status);
			taskDao.add(task);
			break;
		case "/task/edit":
			int idEdit = Integer.valueOf(req.getParameter("id"));
			String shortDescEdit = req.getParameter("shortDesc");
			String descEdit = req.getParameter("desc");
			Date startDateEdit = Date.valueOf(req.getParameter("startDate"));
			Date endDateEdit = Date.valueOf(req.getParameter("endDate"));
			Task taskEdit = new Task(shortDescEdit, descEdit, startDateEdit, endDateEdit, idEdit);
			taskDao.update(taskEdit);
			break;
		default:
			break;
		}
		resp.sendRedirect(req.getContextPath()+"/task");
		
	}
}
