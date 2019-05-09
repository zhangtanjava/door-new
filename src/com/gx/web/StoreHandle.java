package com.gx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.WlStore;
import com.gx.service.StoreHandleService;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/StoreHandle")
public class StoreHandle {
	
	Logger logger = Logger.getLogger(StoreHandle.class);

	@Autowired
	private StoreHandleService storeHandleService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(HttpServletRequest request,Integer currentPage,String txtmodel){
		ModelAndView mv=null;
		mv=new ModelAndView("/store/list");
		Page<WlStore> vo=new Page<WlStore>();
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		if(txtmodel==null)
		{
			txtmodel="";
		}
		vo.setCurrentPage(currentPage);
		WlStore wlStore = new WlStore();
		wlStore.setModel(txtmodel);
		vo=this.storeHandleService.pageFuzzyselect(vo,wlStore);
		
		mv.addObject("list",vo);
		mv.addObject("txtmodel",txtmodel);
		return mv;
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/store/add");
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		WlStore list=storeHandleService.selectById(id);
		mv=new ModelAndView("/store/update");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(WlStore WlStore){
		ModelAndView mv=null;
		storeHandleService.insertAll(WlStore);
		mv=new ModelAndView("redirect:/StoreHandle/tolist.do");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(WlStore WlStore){
		ModelAndView mv=null;
		storeHandleService.updateById(WlStore);
		mv=new ModelAndView("redirect:/StoreHandle/tolist.do");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			storeHandleService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/StoreHandle/tolist.do");
		return mv;
	}
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<WlStore> selectStoreId(){
		List<WlStore> userList = this.storeHandleService.selectAll();
		return userList;
	}
	@ResponseBody
	@RequestMapping(value="/selectByModelSize")
	public Object selectByModelSize(String model,String size){
		int accout = storeHandleService.selectByModelSize(model,size);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}
}
