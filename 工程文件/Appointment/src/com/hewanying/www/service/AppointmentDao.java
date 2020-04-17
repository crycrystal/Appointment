package com.hewanying.www.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hewanying.www.dao.Basedao;
import com.hewanying.www.po.Administrator;
import com.hewanying.www.po.Appointment;
import com.hewanying.www.po.AppointmentStatus;
import com.hewanying.www.po.Student;
import com.hewanying.www.po.Tutor;
import com.hewanying.www.po.User;

/**
 * 完成用户增删改查的服务层
 * @author 何婉莹
 *
 */
public class AppointmentDao {
	
	/**
	 *将各表加入数据库中
	 */
	
	//统一用户表（登录用?）
	public static int insert(User user) {
		String sql = "insert into administrator values(?, ?, ?)";
		
		Object[] params = {
				user.getId(),
				user.getPassword(),
				user.getIdentity(),
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//网站管理员表
	public static int insert(Administrator ad) {
		String sql = "insert into administrator values(?, ?, ?, ?, ?)";
		
		Object[] params = {
				ad.getId(),
				ad.getName(),
				ad.getTEL(),
				ad.getPassword(),
				ad.getIdentity(),
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//预约请求表
	public static int insert(Appointment ap) {
		String sql = 
			"insert into appointment values(?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), DATE_FORMAT(?,'%Y-%m-%d %H:&i'), ?)";
		
		Object[] params = {
				ap.getId(),
				ap.getStudentId(),
				ap.getTutorId(),
				ap.getSubmitTime(),
				ap.getTime(),
				ap.getStatus()
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//预约请求状态标签表
	public static int insert(AppointmentStatus as) {
		String sql = "insert into appointment_status values(?, ?, ?)";
		
		Object[] params = {
				as.getPend(),
				as.getPass(),
				as.getFail()
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//学生表
	public static int insert(Student st) {
		String sql = 
			"insert into student values(?, ?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d %H:&i'), ?)";
		
		Object[] params = {
				st.getId(),
				st.getName(),
				st.getInstitute(),
				st.getTEL(),
				st.getPassword(),
				st.getIdentity(),
				st.getStatus()
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//导师表
	public static int insert(Tutor tu) {
		String sql = "insert into tutor values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {
				tu.getId(),
				tu.getName(),
				tu.getInstitute(),
				tu.getTEL(),
				tu.getPassword(),
				tu.getIdentity(),
				tu.getAvailableTime(),
				tu.getSchedule()
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	/**
	 * 从数据库中查询各表全部记录
	 */	
	
	//网站管理员表
	public static ArrayList<Administrator> selectAllAd(){
		ArrayList<Administrator> list= new ArrayList<Administrator>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		//准备sql语句
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from administrator order by id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Administrator ad = new Administrator(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("TEL"),
						rs.getString("password"),
						rs.getString("identify")
						);
				list.add(ad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	//预约请求表（分页后可以按页查询）
	public static ArrayList<Appointment> selectAllAp(int cpage, int count){
		//cpage参数是当前页页码，count参数是单页显示的记录数
		
		ArrayList<Appointment> list= new ArrayList<Appointment>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from appointment order by id desc limit ?, ?";
			ps = conn.prepareStatement(sql);
			
			//当前页的第一条记录从上一页最后一条记录开始取起
			ps.setInt(1, (cpage-1)*count);
			ps.setInt(2, count);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Appointment ap = new Appointment(
						rs.getInt("id"),
						rs.getString("student_id"),
						rs.getString("tutor_id"),
						rs.getDate("submit_time"),
						rs.getDate("time"),
						rs.getInt("status")
						);
				list.add(ap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	//预约请求状态标签表
	public static ArrayList<AppointmentStatus> selectAllAs(){
		ArrayList<AppointmentStatus> list= new ArrayList<AppointmentStatus>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from appointment_status";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AppointmentStatus as = new AppointmentStatus(
						rs.getInt("pend"),
						rs.getInt("pass"),
						rs.getInt("fail")
						);
				list.add(as);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	//学生表
	public static ArrayList<Student> selectAllSt(){
		ArrayList<Student> list= new ArrayList<Student>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from student order by id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Student st = new Student(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("institute"),
						rs.getString("TEL"),
						rs.getString("password"),
						rs.getString("identity"),
						rs.getInt("status")
						);
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	//导师表（分页后可以按页查询；可通过关键字keyword模糊查询）
	public static ArrayList<Tutor> selectAllTu(int cpage, int count,String keyword){
		ArrayList<Tutor> list= new ArrayList<Tutor>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		
		try {
			String sql = "";
			
			//先判断用户是否有进行关键字搜索（即判断是否有传递参数）
			if(keyword!=null) {
				//有传递关键字时，通过导师姓名或所属学院模糊查询
				sql = "select * from tutor where concat('tutor.name','tutor.institute') like ? "
						+ "order by id desc limit ?,?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
				
			}else {
				//未传递关键字时，显示导师表所有记录
				sql = "select * from tutor order by id desc limit ?,?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Tutor tu = new Tutor(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("institute"),
						rs.getString("TEL"),
						rs.getString("password"),
						rs.getString("identity"),
						rs.getDate("available_time"),
						rs.getString("schedule")
						);
				list.add(tu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	/**
	 *获得所查询表格的所有记录数
	 */
	
	//实现网站管理员查询所有预约请求，即获取预约申请表的总记录数（实现分页）
	public static int[] totalPageAd(int count) {
		//arr[0]的值为总记录数，arr[1]的值为总页数，参数count为单页显示的记录数
		int arr[]= {0,1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from appointment";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				arr[0] = rs.getInt(1);
				
				if(arr[0]%count==0) {
					arr[1] = arr[0]/count;
				}else {
					//总记录数不能被单页显示记录数整除时，需要新开一页
					arr[1] = arr[0]/count+1;
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
	
		return arr;
	}
	
	//实现学生查询所有导师，即获取导师表的总记录数（实现分页）
	public static int[] totalPageTu(int count,String keyword) {
		//arr[0]的值为总记录数，arr[1]的值为总页数，参数count为单页显示的记录数
		int arr[]= {0,1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from tutor where concat('tutor.name','tutor.institute') like ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else {
				sql = "select count(*) from tutor";
				ps = conn.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			
			while(rs.next()) {
				arr[0] = rs.getInt(1);
				
				if(arr[0]%count==0) {
					arr[1] = arr[0]/count;
				}else {
					//总记录数不能被单页显示记录数整除时，需要新开一页
					arr[1] = arr[0]/count+1;
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
	
		return arr;
	}
	
	/**
	 * 前台用户登录
	 */
	
	//学生登录
	//登录时查找用户，检查是否已经注册
	public static int selectBy(String id, String password) {
		int count = 0; //返回结果数
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "selet count (*) from student where id=? and name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}	
		return count;
	}
	
	//通过用户ID、用户名和密码查询用户信息
	public static User selectAdmin(String id, String password) {
		User user = null;
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;

		try {
			String sql = "select * from tutor where id=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(
						rs.getString("id"),
						rs.getString("password"),
						rs.getString("identity")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return user;	
	}
	
	
	
	
	
}








