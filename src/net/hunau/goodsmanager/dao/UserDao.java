/**
 * Shanice
 * net.hunau.goodsmanager.dao
 * UserDao.java
 * 创建人:Shanice
 * 时间：2018年12月7日-下午4:06:52 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.utils.JDBCUtils;

/**
 * 
 * UserDao 创建人:Shanice 
 * 时间：2018年12月7日-下午4:06:52
 * @version 1.0.0
 * 
 */
public class UserDao {

	// 创建对象
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;

	/**
	 * 
	 * 根据用户名,密码来查看user表中的数据及取数据 
	 * 方法名：getUser 
	 * 创建人：Shanice 
	 * 时间：2018年12月7日-下午4:36:29
	 * 手机:15873158820
	 * @param userName
	 * @param password
	 * @return User
	 * @exception 
	 * @since 1.0.0
	 */
	public User getUser(String userName, String password) {
		User user = null;

		// 访问数据库

		String sql = "select userName,pwd,roles from users where userName=? and pwd=md5(?)";
		// 获得对象或数据源
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);
			rs = pst.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("pwd"));
				user.setRoles(rs.getInt("roles"));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pst, conn);
		}

		return user;
	}
	
	/**
	 *
	 * 完成查看用户详情
	 * 方法名：getUser
	 * 创建人：Shanice
	 * 时间：2018年12月8日-下午3:41:23 
	 * 手机:15873158820
	 * @param userName
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	
	public User getUser(String userName) {
		User user = null;

		// 访问数据库

		String sql = "select userName,pwd,validateFlag,roles from users where userName=? ";
		// 获得对象或数据源
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("pwd"));
				user.setRoles(rs.getInt("roles"));
				user.setValidateFlag(rs.getInt("validateFlag"));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pst, conn);
		}

		return user;
	}
	
	/**
	 * 
	 * 根据用户名获取用户的全部信息
	 * 方法名：getUsers
	 * 创建人：Shanice
	 * 时间：2018年12月12日-下午6:47:51 
	 * 手机:15873158820
	 * @return List<User>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		/*String sql = "select userName,pwd,validateFlag,roles from users where userName=? and pwd=md5(?)";*/
		String sql = "select userName,pwd,validateFlag,roles from users ";
		
		User tempUser = null;
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			
			while(rs.next()){
				tempUser = new User();
				tempUser.setUsername(rs.getString("userName"));
				tempUser.setValidateFlag(rs.getInt("validateFlag"));
				tempUser.setPassword(rs.getString("pwd"));
				tempUser.setRoles(rs.getInt("roles"));
				users.add(tempUser);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	
	/**
	 * 修改信息,实现提交功能
	 * 方法名：updateUser
	 * 创建人：Shanice
	 * 时间：2018年12月8日-下午4:31:10 
	 * 手机:15873158820
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateUser(User user){
		String sql = "update users set validateFlag=?,pwd=md5(?),roles=? where userName=?";
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getValidateFlag());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getRoles());
			pst.setString(4, user.getUsername());
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst,conn);
		}
		
	}
	
	
	/**
	 *重新写一个方法 ,让密码不需要再更改
	 * 方法名：updateUsers
	 * 创建人：Shanice
	 * 时间：2018年12月8日-下午5:21:57 
	 * 手机:15873158820
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateUsers(User user){
		/*String sql = "update users set validateFlag=?,pwd=md5(?),roles=? where userName=?";*/
		String sql = "update users set validateFlag=? where userName=?";
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getValidateFlag());
			pst.setString(2, user.getUsername());
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst,conn);
		}
		
	}
	
	
	/**
	 * 添加用户
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addUser
	 * 创建人：Shanice
	 * 时间：2018年12月9日-下午4:15:56 
	 * 手机:15873158820
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addUser(User user){
		String sql = "insert into users (userName,pwd,validateFlag,roles) values(?,md5(?),?,?)";
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getValidateFlag());
			pst.setInt(4, user.getRoles());
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst,conn);
		}
		
	}
	
	/**
	 * 
	 * 测试表中的数据 方便其他人使用 
	 * 方法名：main 
	 * 创建人：Shanice 
	 * 时间：2018年12月7日-下午4:46:01 
	 * 手机:15873158820
	 * @param args void
	 * @exception 
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		List<User> users = ud.getUsers();
		for(int i=0;i<users.size();i++){
			User user =users.get(i);
			System.out.println(user.getRoles());
		}
		
	}

}
