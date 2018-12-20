/**
 * Shanice
 * net.hunau.goodsmanager.dao
 * RolesDao.java
 * 创建人:Shanice
 * 时间：2018年12月8日-下午3:24:33 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.hunau.goodsmanager.bean.Roles;
import net.hunau.goodsmanager.utils.JDBCUtils;

/**
 * 完成编辑页面的查询
 * RolesDao
 * 创建人:Shanice
 * 时间：2018年12月8日-下午3:24:33 
 * @version 1.0.0
 * 
 */
public class RolesDao {
	// 创建对象
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
		
	public List<Roles> getRoles(){
		List<Roles> roles = new ArrayList<Roles>();
		Roles role = null;
		
		String sql = "select id,roleName,roleDesc from roles";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()) {
				role = new Roles();
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("roleName"));
				role.setRoleDesc(rs.getString("roleDesc"));
				roles.add(role);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs,pst,conn);
		}
		return roles;
	}
	
	public static void main(String[] args){
		RolesDao ud = new RolesDao();
		
		List<Roles> roles = ud.getRoles();
		for(int i=0;i<roles.size();i++){
			Roles role =roles.get(i);
			System.out.println(role.getRoleName());
		}
	}
}
