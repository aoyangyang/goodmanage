/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * AddGoodServlet.java
 * 创建人:Shanice
 * 时间：2018年12月9日-下午10:21:28 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

/**
 * 
 * AddGoodServlet
 * 创建人:Shanice
 * 时间：2018年12月9日-下午10:21:28 
 * @version 1.0.0
 * 
 */
public class AddGoodServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String goodName = req.getParameter("ProductName");
		String goodPrice = req.getParameter("productPrice");
		String goodCount = req.getParameter("productNumber");
		String goodDep = req.getParameter("description");
		String goodType = req.getParameter("goodsType");
		
		Goods goods = new Goods();
		goods.setGoodname(goodName);
		goods.setGoodprice(Double.valueOf(goodPrice));
		goods.setGoodcount(Integer.valueOf(goodCount));
		goods.setGoodtype(Integer.valueOf(goodType));
		goods.setGoodDep(goodDep);
		
		GoodsBiz goodsBiz = new GoodsBiz();
		goodsBiz.addGoods(goods);
		
		String toPage = "ScanGoodServlet";
		
		//服务器端的跳转
		RequestDispatcher rd = req.getRequestDispatcher(toPage);
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}

	
}
