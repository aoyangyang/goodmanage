/**
 * Shanice
 * net.hunau.goodsmanager.core
 * LoginFilter.java
 * 创建人:Shanice
 * 时间：2018年12月12日-下午9:04:54 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;

/**
 * 
 * LoginFilter
 * 创建人:Shanice
 * 时间：2018年12月12日-下午9:04:54 
 * @version 1.0.0
 * 
 */
public class LoginFilter implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest re = (HttpServletRequest) arg0;
		HttpServletResponse rs = (HttpServletResponse) arg1;
		
		User user = (User) re.getSession().getAttribute("users");
		
		if (user==null) {
			String toPage  = re.getContextPath()+"/index.jsp";
			rs.sendRedirect(toPage);
		}
		arg2.doFilter(arg0, arg1);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
