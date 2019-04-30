package com.gx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Main")
public class Main {
	
	@RequestMapping("/todata")
	public String tologin(String userID){
		return "redirect:/ParametersHandle/tolist.do?userID="+userID;
	}
	@RequestMapping("/main")
	public String tomian(){
		return "/main/main";
	}
}
