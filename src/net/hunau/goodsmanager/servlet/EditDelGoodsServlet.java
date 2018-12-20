/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * EditDelGoodsServlet.java
 * 创建人:Shanice
 * 时间：2018年12月11日-上午9:35:25 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.GoodsDao;
import net.hunau.goodsmanager.dao.TypeDao;

/**
 * 
 * 删除商品的跳转
 * EditDelGoodsServlet
 * 创建人:Shanice
 * 时间：2018年12月11日-上午9:35:25 
 * @version 1.0.0
 * 
 */
public class EditDelGoodsServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String goodsID =req.getParameter("goodsid");
		//http://localhost/goodmanage/servlet/EditDelGoodsServlet?goodsid=3&op=del
		int intGoodsID = 0;
		if(goodsID != null && goodsID != ""){
			intGoodsID = Integer.parseInt(goodsID);
			
		}
		
		System.out.println(goodsID);
		GoodsDao goodsDao = new GoodsDao();
		HttpSession session = req.getSession();
		String toPage = "ScanGoodServlet";
		
		if("del".equals(op)){
			//删除商品
			goodsDao.delGoods(intGoodsID);
		}else{
			//更新商品
			Goods goods = goodsDao.getGoods(intGoodsID);
			TypeDao typeDao = new TypeDao();
			//拿到全部的用户类型
			List<GoodsType> goodsType = typeDao.scanAllGoodsType();
			GoodsType temp = new GoodsType();
			int i =0;
			for(GoodsType goodstype :  goodsType){
				if(goodstype.getId() == goods.getGoodtype()){
					temp = goodsType.get(0);
					goodsType.set(0, goodstype);
					goodsType.set(i, temp);
					break;
				}
				i++;
			}
			session.setAttribute("goods", goods);
			session.setAttribute("goodsType", goodsType);
		}
		RequestDispatcher rd  = req.getRequestDispatcher(toPage);
		rd.forward(req, resp);
	}

	public void destroy() {
	}

	public void init() throws ServletException {
	}

	
	
	
	
	
	
}
