package com.myproject.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproject.entity.Task;
import com.myproject.entity.TaskAndUser;
import com.myproject.entity.User;
import com.myproject.implement.TaskDao;
import com.myproject.implement.UserDao;

@WebServlet(urlPatterns = {"/task","/task/add","/task/edit", "/task/delete",
		"/task/insert","/task/get-task","/update-status", "/task/search"})
public class TaskServlet extends HttpServlet{
	TaskDao taskDao = null;
	UserDao userDao = null;
	String pathIndex = "/WEB-INF/task/index.jsp";
	String pathAdd = "/WEB-INF/task/add.jsp";
	String pathEdit = "/WEB-INF/task/edit.jsp";
	String pathGet = "/WEB-INF/task/get.jsp";
	String pathSearch = "/WEB-INF/task/search.jsp";
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
//			for (Object t : taskDao.getAll()) {
//				System.out.println(t.toString());
//			}
			req.getRequestDispatcher(pathIndex).forward(req, resp);
			break;
		case "/task/add":
			req.setAttribute("listTask", taskDao.getAll());
			req.setAttribute("listUser", userDao.getAll());
			req.getRequestDispatcher(pathAdd).forward(req, resp);
			break;
		case "/task/edit":
			int idEdit = Integer.valueOf(req.getParameter("id"));
			Task task = (Task) taskDao.getById(idEdit);
			req.setAttribute("taskEdit", task);
			req.setAttribute("listUser", userDao.getAll());
			req.getRequestDispatcher(pathEdit).forward(req, resp);
			break;
		case "/task/delete":
			int idDel = Integer.valueOf(req.getParameter("id"));
			taskDao.delete(idDel);
			resp.sendRedirect(req.getContextPath()+"/task");
			break;
		case "/task/get-task":
			int idGet = Integer.valueOf(req.getParameter("id"));
			req.setAttribute("taskGet", taskDao.getById(idGet));
			req.setAttribute("listTask", taskDao.getTaskByTaskID(idGet));
			req.setAttribute("listUser", userDao.getAll());
			req.getRequestDispatcher(pathGet).forward(req, resp);
			break;
		case "/task/search":
			String input = req.getParameter("key");
			req.setAttribute("listTask", taskDao.findShortDesc(input));
			req.setAttribute("listUser", userDao.getAll());
			req.setAttribute("key", input);
			req.getRequestDispatcher(pathIndex).forward(req, resp);
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
			Date startDate = Date.valueOf(req.getParameter("startDate"));
			Date endDate = Date.valueOf(req.getParameter("endDate"));
			int taskId = Integer.valueOf(req.getParameter("taskId"));
			int userIdAdd = Integer.valueOf(req.getParameter("userId"));
			Task task = new Task(shortDesc, desc, startDate, endDate);
			task.setUser_id(userIdAdd);
			task.setTask_id(taskId);
			taskDao.add(task);
			resp.sendRedirect(req.getContextPath()+"/task");
			break;
		case "/task/edit":
			int idEdit = Integer.valueOf(req.getParameter("id"));
			String shortDescEdit = req.getParameter("shortDesc");
			String descEdit = req.getParameter("desc");
			Date startDateEdit = Date.valueOf(req.getParameter("startDate"));
			Date endDateEdit = Date.valueOf(req.getParameter("endDate"));
			int userIdEdit = Integer.parseInt(req.getParameter("userId"));
			Task taskEdit = new Task(shortDescEdit, descEdit, startDateEdit, endDateEdit, userIdEdit);
			taskEdit.setId(idEdit);
			taskDao.update(taskEdit);
			resp.sendRedirect(req.getContextPath()+"/task");
			break;
		case "/task/insert":
			String shortDescT = req.getParameter("shortDesc");
			String descT = req.getParameter("desc");
			int taskIdT = Integer.valueOf(req.getParameter("taskId"));
			int userId = Integer.valueOf(req.getParameter("userId"));
			Date startDateT = Date.valueOf(req.getParameter("startDate"));
			Date endDateT = Date.valueOf(req.getParameter("endDate"));
			Task insertTask = new Task(shortDescT, descT, startDateT, endDateT);
			insertTask.setTask_id(taskIdT);
			insertTask.setUser_id(userId);
			taskDao.add(insertTask);
			resp.sendRedirect(req.getContextPath()+"/task/get-task?id="+taskIdT);
			break;
		case "/update-status":
			HttpSession session = req.getSession();
			User login = (User) session.getAttribute("LOGIN");
			Task updateStt = new Task();
			updateStt.setId(Integer.valueOf(req.getParameter("id")));
			updateStt.setUser_id(login.getId());
			updateStt.setStatus(Integer.valueOf(req.getParameter("status")));
			taskDao.updateStatus(updateStt, updateStt.getUser_id());
			resp.sendRedirect(req.getContextPath()+"/profile");
			break;
		
		default:
			break;
		}
		
		
	}
}
