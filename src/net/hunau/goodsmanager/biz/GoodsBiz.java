/**
 * Shanice
 * net.hunau.goodsmanager.biz
 * GoodsBiz.java
 * 创建人:Shanice
 * 时间：2018年12月9日-下午9:27:34 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.biz;

import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDao;

/**
 * 添加商品到数据库
 * GoodsBiz
 * 创建人:Shanice
 * 时间：2018年12月9日-下午9:27:34 
 * @version 1.0.0
 * 
 */
public class GoodsBiz {
	
	private GoodsDao gd;
	
	public GoodsBiz(){
		gd = new GoodsDao();
	}
	
	public void addGoods(Goods goods){
		gd.addGoods(goods);
	}
	
	
	public List<Goods> getGoods(){
		return gd.getGoods();
	}
	
	/**
	 * 
	 * 判断是根据商品ID还是根据商品名称查询数据库
	 * 方法名：findGoods
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:37:50 
	 * 手机:15873158820
	 * @param condition
	 * @return List<Goods>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Goods> findGoods(Goods condition){
		List<Goods> goods = new ArrayList<Goods>();
		if(condition.getId() != 0){
			goods.add(gd.getGoods(condition.getId()));
		}else if(condition.getGoodname() != null){
			goods.addAll(gd.getGoods(condition.getGoodname()));
		}
		return goods;
	}
	
	
	
	
	
	/**
	 * 添加商品到数据库
	 * 方法名：main
	 * 创建人：Shanice
	 * 时间：2018年12月9日-下午9:27:34 
	 * 手机:15873158820
	 * @param args void
	 * @exception 
	 * @since  1.0.0
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
