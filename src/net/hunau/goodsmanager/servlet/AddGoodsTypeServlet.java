/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * AddGoodsTypeServlet.java
 * 创建人:Shanice
 * 时间：2018年12月12日-下午2:46:43 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.TypeDao;

/**
 * 
 * AddGoodsTypeServlet
 * 创建人:Shanice
 * 时间：2018年12月12日-下午2:46:43 
 * @version 1.0.0
 * 
 */
public class AddGoodsTypeServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(4564798);
		req.setCharacterEncoding("UTF-8");		
		
		String typeDec = req.getParameter("typeDec");
		String typeName = req.getParameter("typeName");
		Integer typeID =  Integer.parseInt(req.getParameter("typeID"));
		
		//保存变量于之后的业务处理
		GoodsType goodsType = new  GoodsType();
		
		goodsType.setId(typeID);
		goodsType.setTypeName(typeName);
		goodsType.setTypeDec(typeDec);
		
		TypeDao typeDao = new TypeDao();
		typeDao.addType(goodsType);
		
	
		//转发给商品查询页面
		String toPage = "ScanGoodServlet";
		//服务器端的跳转
		RequestDispatcher rd = req.getRequestDispatcher(toPage);
		System.out.println(toPage);
		rd.forward(req, resp);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
