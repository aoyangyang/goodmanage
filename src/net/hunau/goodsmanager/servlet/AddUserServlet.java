/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * AddUserServlet.java
 * 创建人:Shanice
 * 时间：2018年12月9日-下午3:49:54 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;

/**
 * 将addUser.jsp页面填入的新增用户信息插入到数据库中
 * AddUserServlet
 * 创建人:Shanice
 * 时间：2018年12月9日-下午3:49:54 
 * @version 1.0.0
 * 
 */
public class AddUserServlet extends HttpServlet{

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
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		String roleType = req.getParameter("roleType");
		
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		user.setRoles(Integer.valueOf(roleType));
		user.setValidateFlag(1);
		
		UserDao userDao = new UserDao();
		userDao.addUser(user);
		
		String toPage = req.getContextPath() + "/content/userManager/userManager.jsp";
		resp.sendRedirect(toPage);
	}
	
	

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
	
}
