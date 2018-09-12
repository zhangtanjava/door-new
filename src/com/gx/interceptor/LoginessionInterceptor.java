package com.gx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gx.service.impl.UserServiceImpl;
import com.sun.istack.internal.logging.Logger;
@Component("loginessionInterceptor")
public class LoginessionInterceptor implements HandlerInterceptor{	
	private static final String LOGIN_URL="/index.jsp"; 
	Logger logger = Logger.getLogger(LoginessionInterceptor.class);
	  @Override 
	  public void postHandle(HttpServletRequest request, 
	      HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception { 
	     
	 
	  } 
	 
	  @Override 
	  public void afterCompletion(HttpServletRequest request, 
	      HttpServletResponse response, Object handler, Exception ex) 
	      throws Exception { 
	 
	  } 
	 
	  @Override 
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler) throws Exception { 
		  logger.info("拦截请求...");
		  System.out.println("拦截请求...");
	    HttpSession session=request.getSession(true); 
	    //session中获取用户名信息 
	    Object obj = session.getAttribute("userPo"); 
	    if (obj==null||"".equals(obj.toString())) { 
	    	logger.info("重定向到登陆页面...");
	      response.sendRedirect(request.getSession().getServletContext().getContextPath()+LOGIN_URL);
	         return false;
	      }
	    return true;
	    }
}
