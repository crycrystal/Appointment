package com.hewanying.www.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 表单验证
 * Servlet Filter implementation class Register
 */
@WebFilter("/register")
public class Register implements Filter {

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//验证
		String id = req.getParameter("id");
		if(id.equals("")) {
			out.write("<script>");
			out.write("alert('工号/学号名称不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		String name = req.getParameter("name");
		if(name.equals("")) {
			out.write("<script>");
			out.write("alert('用户名称不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		String institute = req.getParameter("institute");
		if(institute.equals("")) {
			out.write("<script>");
			out.write("alert('所属学院不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		String tel = req.getParameter("tel");
		if(tel.equals("")) {
			out.write("<script>");
			out.write("alert('电话号码不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		String password = req.getParameter("password");
		if(password.equals("")) {
			out.write("<script>");
			out.write("alert('设置密码不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		String identity = req.getParameter("identity");
		if(identity.equals("")) {
			out.write("<script>");
			out.write("alert('注册用户类型不能为空');");
			out.write("<location.href='reg.jsp';"); //返回注册页面
			out.write("</script>");
			out.close();
			return;
		}
		
		//若注册不通过则直接return
		// pass the request along the filter chain
		chain.doFilter(req, resp);  //若注册通过则使用该条语句
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}


















