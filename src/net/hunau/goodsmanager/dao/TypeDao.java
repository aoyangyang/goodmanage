/**
 * Shanice
 * net.hunau.goodsmanager.dao
 * TypeDao.java
 * 创建人:Shanice
 * 时间：2018年12月9日-下午4:24:41 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.utils.JDBCUtils;

/**
 * 获取所有的商品类型
 * TypeDao
 * 创建人:Shanice
 * 时间：2018年12月9日-下午4:24:41 
 * @version 1.0.0
 * 
 */
public class TypeDao {
		// 创建对象
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public List<GoodsType> scanAllGoodsType(){
		
		List<GoodsType> goodsType = new ArrayList<GoodsType>();
		
		String sql = "select id,typename,typedes from goodstype";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				GoodsType goodstype = new GoodsType();
				goodstype.setId(rs.getInt("id"));
				goodstype.setTypeName(rs.getString("typename"));
				goodstype.setTypeDec(rs.getString("typedes"));
				goodsType.add(goodstype);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pst, conn);
		}
		return goodsType; 
	}
	

	/**
	 * 
	 * 插入数据到数据库
	 * 方法名：addType
	 * 创建人：Shanice
	 * 时间：2018年12月12日-下午4:21:08 
	 * 手机:15873158820
	 * @param goodsType void
	 * @exception 
	 * @since  1.0.0
	 */
	
	public void addType(GoodsType goodsType){
		String sql = "insert into goodstype (id,typename,typedes) values(?,?,?)";
		
	      try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goodsType.getId());
			pst.setString(2, goodsType.getTypeName());
			pst.setString(3, goodsType.getTypeDec());
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
}
