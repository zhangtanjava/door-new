package com.gx.web;


import javax.servlet.http.HttpServletRequest;

import com.gx.po.UserPo;
import com.gx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.PassengerPo;
import com.gx.service.PassengerService;

@Controller
@RequestMapping("/Passenger")
public class Passenger {

	Logger logger = Logger.getLogger(Passenger.class);

	@Autowired
	private PassengerService passengerService;
	@Autowired
	private UserService userService;

	@RequestMapping("/tolist")
	public ModelAndView tolist(HttpServletRequest request,Integer currentPage,String txtname,Integer userID){
		logger.info("Passenger tolist req:userID"+userID);
		ModelAndView mv=null;
		mv=new ModelAndView("/passenger/list");
		Page<PassengerPo> vo=new Page<PassengerPo>();
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		if(txtname==null)
		{
			txtname="";
		}
		String storeID ="0";
		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			storeID=userPo.getStoreID();
		}

		vo.setCurrentPage(currentPage);
		vo=this.passengerService.pageFuzzyselect(storeID,txtname, vo);
		mv.addObject("list",vo);
		mv.addObject("txtname",txtname);
		return mv;
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/passenger/add");
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		PassengerPo list=passengerService.selectById(id);
		mv=new ModelAndView("/passenger/update");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(PassengerPo passengerPo
			,Integer userID){

		logger.info("Passenger add req:"+passengerPo+"..userID:"+userID);
		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			passengerPo.setStoreID(userPo.getStoreID());
		}else{
			passengerPo.setStoreID("0");//1-8正常店
		}

		ModelAndView mv=null;
		try {
			passengerService.insertAll(passengerPo);
		}catch (Exception e){
			logger.info("添加用户信息异常："+e.getMessage());
		}

		mv=new ModelAndView("redirect:/Passenger/tolist.do?userID="+userID);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(PassengerPo passengerPo,Integer userID){
		ModelAndView mv=null;
		passengerService.updateById(passengerPo);
		mv=new ModelAndView("redirect:/Passenger/tolist.do?userID="+userID);
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id,Integer userID){
		logger.info("Passenger delete req:"+id+"|"+userID);
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			passengerService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/Passenger/tolist.do?userID="+userID);
		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/YZ")
	public Object YZ(String papersNumber){
		int YorN=passengerService.selectYZ(papersNumber);
		Gson gson =new Gson();
		return gson.toJson(YorN);
	}

	@ResponseBody
	@RequestMapping(value="/selectByUserName")
	public Object selectByName(String userName){
		int accout = passengerService.selectByUserName(userName);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}
}
