package com.hewanying.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Basedao {
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//连接数据库
	public static Connection getconn() {
		//创建一个连接对象
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment?uesSSL=false&serverTimezone=UTC","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//增删改返回执行信息
	public static int exectuIUD(String sql,Object[] params) {
		int count = 0;	//执行影响的行数
		
		Connection conn = Basedao.getconn();
		
		//准备SQL语句
		PreparedStatement ps = null;
		try {
			//准备SQL语句
			ps = conn.prepareStatement(sql);
			
			for(int i=0; i<params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null, ps, conn);
		}
		
		return count;
	}
	
	
	//关闭数据库
	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if(rs!=null)	
				rs.close();
			
			if(ps!=null)
				ps.close();
			
			if(conn!=null)
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
