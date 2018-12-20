/**
 * Shanice
 * net.hunau.goodsmanager.dao
 * GoodsDao.java
 * 创建人:Shanice
 * 时间：2018年12月9日-下午6:23:23 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.utils.JDBCUtils;

/**
 * 
 * GoodsDao
 * 创建人:Shanice
 * 时间：2018年12月9日-下午6:23:23 
 * @version 1.0.0
 * 
 */
public class GoodsDao {
		// 创建对象
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	
	/**
	 * 
	 * 添加商品到数据库
	 * 方法名：addGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:11:59 
	 * 手机:15873158820
	 * @param Goods void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addGoods(Goods Goods){
		String sql = "insert into goods(goodsName,goodsPrice,goodsCount,goodsDep,goodsType)"
				+ "values(?,?,?,?,?)";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, Goods.getGoodname());
			pst.setDouble(2, Goods.getGoodprice());
			pst.setInt(3, Goods.getGoodcount());
			pst.setString(4, Goods.getGoodDep());
			pst.setInt(5, Goods.getGoodtype());
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,pst, conn);
		}	
	}
	
	/**
	 * 
	 * 获取数据库中的所有商品
	 * 方法名：getGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:10:04 
	 * 手机:15873158820
	 * @return List<Goods>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Goods> getGoods(){
		
		List<Goods> goods = new ArrayList<Goods>();
		String sql = "select * from goods";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodDep(rs.getString("goodsDep"));
				Goods.setGoodtype(rs.getInt("goodsType"));
				goods.add(Goods);
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
		return goods;
	}
	
	
	/**
	 * 
	 * 根据商品名称查询数据库中的商品
	 * 方法名：getGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:10:53 
	 * 手机:15873158820
	 * @param goodsName
	 * @return List<Goods>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Goods> getGoods(String goodsName){
		List<Goods> goods = new ArrayList<Goods>();
		String sql = "select * from goods where goodsName like '%" + goodsName + "%'";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodDep(rs.getString("goodsDep"));
				Goods.setGoodtype(rs.getInt("goodsType"));
				goods.add(Goods);
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
		return goods;
	}
	
	
	/**
	 * 
	 * 根据商品名称查询数据库中的商品
	 * 方法名：getGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:12:49 
	 * 手机:15873158820
	 * @param id
	 * @return Goods
	 * @exception 
	 * @since  1.0.0
	 */
	public Goods getGoods(int id){
		String sql = "select * from goods where goodsID =" + id;
		Goods Goods = new Goods();
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodDep(rs.getString("goodsDep"));
				Goods.setGoodtype(rs.getInt("goodsType"));
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
		return Goods;
	}
	
	/**
	 * 
	 * 删除指定ID的商品
	 * 方法名：delGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午4:57:39 
	 * 手机:15873158820
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	 */
	public void delGoods(int id){
		String sql = "delete from goods where goodsID =" +id;
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst, conn);
		}
	}
	
	/**
	 * 
	 * 用于修改商品的信息
	 * 方法名：updateGoods
	 * 创建人：Shanice
	 * 时间：2018年12月11日-下午1:42:25 
	 * 手机:15873158820
	 * @param Goods void
	 * @exception 
	 * @since  1.0.0
	 */
	public void updateGoods(Goods goods){
		
		String sql = "update goods set goodsName =?,goodsPrice =?,goodsCount =?,goodsDep =?,goodsType =? where goodsID=?";
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			
			System.out.println(goods.getGoodcount());
			
			pst.setString(1, goods.getGoodname());
			pst.setDouble(2, goods.getGoodprice());
			pst.setInt(3, goods.getGoodcount());
			pst.setString(4, goods.getGoodDep());
			pst.setInt(5, goods.getGoodtype());
			pst.setInt(6, goods.getId());
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
