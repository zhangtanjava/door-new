package com.gx.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.gx.po.UserPo;
import com.gx.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/Login")
@SessionAttributes({"userPo","userName","retMsg"})
public class Login {
	Logger logger = Logger.getLogger(Login.class);
	@Autowired
	private UserService userService;
	//跳转到登录页面
	@RequestMapping("/tologin")
	public String tologin(){
		return "/login/login";//如果返回时string，跳转到modview处理器，找到相应的jsp资源
	}
	
	//执行login操作，匹配用户名和密码，建立session持久连接
    @RequestMapping(value = "/tomain")
    public String login(UserPo user, Model model, HttpServletRequest request){
    	user = userService.selectLogin(user);
    	HttpSession session = (HttpSession) request.getSession();
//    	其实model和session都是存放信息的地方，不同的地方就是他们的生命周期不同，model是request级别的。
    	if (user != null){
//            model.addAttribute("userPo",user);
//            model.addAttribute("userName", user.getUserName());
    		session.setAttribute("user",user);
    		session.setMaxInactiveInterval(1800);//1800秒，优先级大于web，大于tomcat
            return "redirect:/Main/main.do";
        }else {
            model.addAttribute("message","登录名或密码错误！");
            return "/login/login";
        }
    }
    //logout登出，其实就是删除之前登录时设置的session
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userPo");
        return "redirect:/login/login";
    }
    
	//登录页面提交
//	@RequestMapping("/tomain")
//	public ModelAndView tomain(UserPo user,ModelMap map){
//		ModelAndView mv=null;
//		logger.info("Login requestParamters user:"+user);
//		UserPo u=userService.selectLogin(user);
//
//		if (u!=null) {
//			map.addAttribute("userName", u.getUserName());
//			map.addAttribute("userPo", u);
//			mv=new ModelAndView("/main/main");
//		}else {
//			mv=new ModelAndView("/login/login");
//		}
//		return mv;
//	}
	

}
