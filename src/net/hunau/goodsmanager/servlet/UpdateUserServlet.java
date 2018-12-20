/**
 * Shanice
 * net.hunau.goodsmanager.servlet
 * UpdateUser.java
 * 创建人:Shanice
 * 时间：2018年12月8日-下午4:30:05 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;


/**
 * 
 * UpdateUser
 * 创建人:Shanice
 * 时间：2018年12月8日-下午4:30:05 
 * @version 1.0.0
 * 
 */
@WebServlet("/servlet/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleType = request.getParameter("roleType");
		String flag = request.getParameter("validateFlag");
		
		int intFlag = 0;
		if(flag != null){
			intFlag = Integer.parseInt(flag);
		}
		
		//保存变量便于之后的业务处理
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setValidateFlag(intFlag);
		user.setRoles(Integer.parseInt(roleType));
		
		UserDao userDao = new UserDao();
		userDao.updateUser(user);
		
		
		
		String toPage = request.getContextPath() + "/content/userManager/userManager.jsp";
		response.sendRedirect(toPage);
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
