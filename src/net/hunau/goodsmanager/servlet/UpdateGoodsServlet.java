/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * UpdateGoodsServlet.java
 * 创建人:Shanice
 * 时间：2018年12月11日-下午2:04:41 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDao;

/**
 * 
 * 获取updateGoods.jsp页面传递过来的商品信息
 * UpdateGoodsServlet
 * 创建人:Shanice
 * 时间：2018年12月11日-下午2:04:41 
 * @version 1.0.0
 * 
 */
public class UpdateGoodsServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		
		
		String productName = req.getParameter("productName");
		Double productPrice = Double.valueOf(req.getParameter("productPrice"));
		Integer productCount = Integer.parseInt(req.getParameter("productCount"));
		String productDep = req.getParameter("productDep");
		Integer productType = Integer.parseInt(req.getParameter("productType"));
		Integer productId =  Integer.parseInt(req.getParameter("productId"));
		
		//保存变量便于之后的业务处理
		Goods goods = new Goods();
		
		goods.setGoodname(productName);
		goods.setGoodprice(productPrice);
		goods.setGoodcount(productCount);
		goods.setGoodDep(productDep);
		goods.setId(productId);
		goods.setGoodtype(productType);
		
		GoodsDao goodsDao = new GoodsDao();
		goodsDao.updateGoods(goods);
		
//		String toPage = req.getContextPath() + "/content/userManager/updateGoods.jsp";
//		resp.sendRedirect(toPage);
		
		HttpSession session = req.getSession();
		session.setAttribute("goods", goods);
		
		String toPage = "ScanGoodServlet";
		
		//服务器端的跳转
		RequestDispatcher rd = req.getRequestDispatcher(toPage);
		rd.forward(req, resp);
	}

	public void destroy() {
	}

	public void init() throws ServletException {
	}
	
	
	
	
}
