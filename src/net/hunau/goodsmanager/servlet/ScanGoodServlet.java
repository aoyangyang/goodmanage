/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * ScanGoodServlet.java
 * 创建人:Shanice
 * 时间：2018年12月10日-下午2:54:16 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

/**
 * 
 * 填入的商品ID或商品名称查询商品
 * ScanGoodServlet
 * 创建人:Shanice
 * 时间：2018年12月10日-下午2:54:16 
 * @version 1.0.0
 * 
 */
public class ScanGoodServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String goodsID = req.getParameter("productID");
		String goodName = req.getParameter("productName");
		List<Goods> goodscan = new ArrayList<Goods>(); 
		GoodsBiz goodsBiz = new GoodsBiz();
		
		if((goodsID == null || goodsID.equals("")) && (goodName == null || goodName.equals(""))){
			goodscan = goodsBiz.getGoods(); 
		}else{
			Goods goods = new Goods();
			
			if((goodsID != null) && (!goodsID.equals(""))){ 
				goods.setId(Integer.valueOf(goodsID));
			}
			
			if((goodName != null) && (!goodName.equals(""))){
				goods.setGoodname(goodName);
			}
			goodscan =  goodsBiz.findGoods(goods);
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("goods", goodscan);
		
		String toPage = "/content/goodsManager/searchGoods.jsp";
		
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
