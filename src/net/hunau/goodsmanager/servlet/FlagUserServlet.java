/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * FlagUserServlet.java
 * 创建人:Shanice
 * 时间：2018年12月8日-下午5:36:00 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.biz.UserBiz;

/**
 * 
 * FlagUserServlet
 * 创建人:Shanice
 * 时间：2018年12月8日-下午5:36:00 
 * @version 1.0.0
 * 
 */
public class FlagUserServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		String flag = request.getParameter("op");
		String userName = request.getParameter("userName");
		
		UserBiz ub = new UserBiz();
		ub.iscancelUser(userName, Integer.valueOf(flag));
		
		String toPage = request.getContextPath() + "/content/userManager/userManager.jsp";
		response.sendRedirect(toPage);
	}		
	
	@Override 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
}
