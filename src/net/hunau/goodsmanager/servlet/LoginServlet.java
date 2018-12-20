/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * LoginServlet.java
 * 创建人:Shanice
 * 时间：2018年12月7日-下午8:12:44 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.biz.UserBiz;

/**
 * 
 * LoginServlet
 * 创建人:Shanice
 * 时间：2018年12月7日-下午8:12:44 
 * @version 1.0.0
 * 
 */
@WebServlet("/LoginServlet")
	public class LoginServlet extends HttpServlet{
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	//实现服务器和界面的跳转
	public void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException{
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		//保存变量便于之后的业务处理
		User loginUser = new User();
		loginUser.setUsername(userName);
		loginUser.setPassword(password);
		
		UserBiz ub = new UserBiz();
		String toPage = "index.jsp";
		HttpSession session = req.getSession();
		
		try {
			loginUser = ub.login(loginUser);
			session.setAttribute("errorMessage","");
			
			//这里已经放入session了      在过滤器  取   和我那天写的一模一样照着写
			req.getSession().setAttribute("users", loginUser);
			toPage = "main.html";
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("errorMessage",e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		req.getSession().setAttribute("username", userName);
		req.getSession().setAttribute("password", password);
		

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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
