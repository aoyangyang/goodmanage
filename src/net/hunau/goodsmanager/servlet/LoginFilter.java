/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * Filter.java
 * 创建人:Shanice
 * 时间：2018年12月7日-下午10:08:55 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * 
 * Filter
 * 创建人:Shanice
 * 时间：2018年12月7日-下午10:08:55 
 * @version 1.0.0
 * 
 */
public class LoginFilter extends HttpServlet {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		//去数据库对比
		
		//登录成功之后
		
		//放到session   setAttribute 是向 session 里面放一个键值对   key——value
		req.getSession().setAttribute("username", username);
		req.getSession().setAttribute("password", password);
		
		/*resp.sendRedirect("/demo1/main/success.html");*/
		req.getRequestDispatcher("/goodmanage/WebRoot/index.jsp").forward(req, resp);
		
	}

	public void destroy() {
	}

	public void init() throws ServletException {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
