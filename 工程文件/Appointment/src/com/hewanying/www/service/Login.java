package com.hewanying.www.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hewanying.www.po.Student;
import com.hewanying.www.po.User;

/**
 * 前台用户登录
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		int count = AppointmentDao.selectBy(id, password); //查找该用户是否存在（是否已经注册），返回结果数
		
		if(count > 0) {
			//返回结果数>0,说明登录成功
			HttpSession session = request.getSession(); //存放取出的用户信息
			User user = AppointmentDao.selectAdmin(id, password);//取出整个用户信息
			
			session.setAttribute("id", user);
			session.setAttribute("isLogin", 1);
			
			response.sendRedirect("index.jsp"); //返回到首页
			
		}else {
			//登录失败
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户登录失败！');");
			out.write("location.href='login.jsp';"); //重新回到登录界面
			out.write("</script>");
			out.close();
		}
		
	}

}
