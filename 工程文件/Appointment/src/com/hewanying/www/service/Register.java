package com.hewanying.www.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hewanying.www.po.Appointment;
import com.hewanying.www.po.Tutor;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String institute = request.getParameter("institute");
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		//创建用户实体
		Tutor tutor = new Tutor(id,name,institute,tel,password,identity,null,null);
		
		//加入到数据库的用户表中
		int count = AppointmentDao.insert(tutor);
		
		//成功或失败重定向
		
		if(count>0) {
			response.sendRedirect(""); //转到登录页面（待定）
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户注册失败')");
			out.write("location.herf=''"); //返回注册页面（待定）
			out.write("</script>");
		}
	}

}
