package com.gx.web;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.WlStore;
import com.gx.service.StoreHandleService;
import com.gx.utils.DateUtils;
import com.gx.utils.ReadExcelUtils;
import com.sun.istack.internal.logging.Logger;

import net.sf.json.JSONArray;
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
	
	@RequestMapping("/addByExcel")
	@ResponseBody//此注解不能省略 否则ajax无法接受返回值
	public JSONArray addByExcel(@RequestParam("inputExcel") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		String filePath = excelFileSave(file);
		String columns[] = {"model","size","left","right"};
		List<Map<String,String>> listMap = ReadExcelUtils.excel2List(filePath,columns);
		List<WlStore> listWs = new ArrayList<WlStore>();
		 //遍历解析出来的list
        for (Map<String,String> map : listMap) {
        	WlStore wlStore = new WlStore();
            for (Entry<String,String> entry : map.entrySet()) {
            	if ("model".equals(entry.getKey())) {
            		wlStore.setModel(entry.getValue());
				}else if ("size".equals(entry.getKey())) {
					wlStore.setSize(entry.getValue());
				}else if ("left".equals(entry.getKey())) {
					wlStore.setOutLeft(StringUtils.isEmpty(entry.getValue())?0:Integer.parseInt(entry.getValue()));
				}else if ("right".equals(entry.getKey())) {
					wlStore.setOutRight(StringUtils.isEmpty(entry.getValue())?0:Integer.parseInt(entry.getValue()));
				}
            	listWs.add(wlStore);
            	System.out.println(wlStore.toString());
            }
        }
        int no = this.storeHandleService.batchUpOrInStoreInfo(listWs);
        System.out.println(no);
        JSONArray json= JSONArray.fromObject(true);
        return json;
	}
	
	private String excelFileSave(MultipartFile file) {
		String fullPath =  "";
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = "/Users/zhangtan/excels" + File.separator + DateUtils.get16Str(new Date());
			logger.info("excel文件上传文件路径：" + path);
			// 上传文件名
			String filename = file.getOriginalFilename();
			logger.info("excel文件上传文件名：" + filename);
			
			fullPath = path+File.separator+filename;
			logger.info("excel文件上传文件名："+fullPath);
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 保存文件路径
			logger.info("excel文件保存成功！");
		} else {
			logger.info("excel文件保存失败！");
		}
		return fullPath;
	}
}
