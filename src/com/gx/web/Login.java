package com.gx.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/tologin")
	public String tologin(SessionStatus status,ModelMap map){
		status.setComplete();//清空session
		map.put("userPo", "");
		map.put("userName", "");
		map.put("retMsg", "");
		return "/login/login";
	}
	
	@RequestMapping("/tomain")
	public ModelAndView tomain(UserPo user,ModelMap map){
		ModelAndView mv=null;
		logger.info("Login requestParamters user:"+user);
		UserPo u=userService.selectLogin(user);


		if (u!=null) {
			map.addAttribute("userName", u.getUserName());
			map.addAttribute("userPo", u);
			mv=new ModelAndView("/main/main");
		}else {
			mv=new ModelAndView("/login/login");
		}

		return mv;
	}
	

}
