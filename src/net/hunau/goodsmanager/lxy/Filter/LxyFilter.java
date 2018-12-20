/**
 * Shanice
 * net.hunau.goodsmanager.lxy.Filter
 * LxyFilter.java
 * 创建人:Shanice
 * 时间：2018年12月12日-下午5:24:54 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.lxy.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符编码过滤器
 * LxyFilter
 * 创建人:Shanice
 * 时间：2018年12月12日-下午5:24:54 
 * @version 1.0.0
 * 
 */

public class LxyFilter implements Filter{

	private FilterConfig filterConfig;
	
	public void destroy() {
	}

	@SuppressWarnings("null")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取filter初始化的参数值
		String encoding = filterConfig.getInitParameter("encoding");
		if(null!=encoding || encoding.equals("")){
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
	}

}