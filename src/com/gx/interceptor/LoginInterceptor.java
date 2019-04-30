package com.gx.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gx.po.UserPo;
import com.gx.service.impl.ParametersHandleServiceImpl;
import com.sun.istack.internal.logging.Logger;

public class LoginInterceptor implements HandlerInterceptor {
	Logger logger = Logger.getLogger(LoginInterceptor.class); 
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.info("进入登录拦截访问...");
    	//获取请求的地址（根域名以外的部分）
    	String url = request.getRequestURI();
		if (url.contains("/Login/tomain.do")) {
			logger.info("进入登录controller，不需要拦截！");//登录controller会进一步就行判断，所以放进来
			return true;
		}
    	
    	//对于非登录的访问请求，获取session，有就是说明已经登录，没有就是拦截访问并跳转到登录页面
        HttpSession session = request.getSession(false);
        if (session!=null){
        	logger.info("session设置的失效时间:"+session.getMaxInactiveInterval());
        	logger.info("session未过期,可以访问！");
        	if (session.getAttribute("user") != null) {
        		logger.info("user存在,可以访问！");
        		return true;
			}
        }
        logger.info("登录时间超过30分钟，请登录系统！");
        request.setAttribute("message","登录时间超过30分钟，请登录系统！");
        request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request,response);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}