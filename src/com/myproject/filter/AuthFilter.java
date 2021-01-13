package com.myproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myproject.entity.User;



@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			// ServletRequest, ServletResponse sang HttpServletRequest, HttpServletResponse
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			String action = req.getServletPath();
			
			if(action.startsWith("/login") || action.startsWith("/logout")) {
				chain.doFilter(request, response);
				return;
			}
				HttpSession session = req.getSession();
				if(session.getAttribute("LOGIN")==null) {
					resp.sendRedirect(req.getContextPath()+"/login");
					return;
				}
				
				User user = (User) session.getAttribute("LOGIN");
				String roleName = user.getRole();
				if(action.startsWith("/user") && !roleName.equals("ADMINISTRATOR")){
					resp.sendRedirect(req.getContextPath()+"/error/403");
					return;
				}
				if(action.startsWith("/task") && roleName.equals("EMPLOYEE")){
					resp.sendRedirect(req.getContextPath()+"/error/403");
					return;
				}
				chain.doFilter(request, response);
			}

	}

