package com.ztps.birthday.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ztps.birthday.core.constant.Constant;
import com.ztps.birthday.glxt.user.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		String uri = request.getRequestURI();
		//判断当前请求地址是否是登录或注册的请求地址
		if (!uri.contains("glxt/user_")) {
			//非登录请求
			if (request.getSession().getAttribute(Constant.USER) != null) {
				
				chain.doFilter(request, response);
				
			} else {
				//没有登录，跳转到登录页面
				response.sendRedirect(request.getContextPath() + "/glxt/user_toLoginUI.action");
			}
		} else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
