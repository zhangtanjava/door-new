package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.TransInfoPo;
import com.gx.po.UserPo;
import com.gx.service.TranInfoService;
import com.gx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/TranStatistics")
public class TranStatistics {

	Logger logger = Logger.getLogger(TranStatistics.class);

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private TranInfoService tranInfoService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(String datemin, String datemax,String agreementID,Integer currentPage,Integer userID){
		logger.info("TranStatistics tolist req:"+datemin+"|"+datemax+"|"+agreementID+"|"+userID);
		ModelAndView mv=null;
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		mv=new ModelAndView("/transtatistics/transtatistics");

		TransInfoPo req = new TransInfoPo();

		Page<TransInfoPo> vo=new Page<TransInfoPo>();
		vo.setCurrentPage(currentPage);
		try {
			if (!StringUtils.isEmpty(datemin)){
				String minStr=datemin+" 00:00:00";
				req.setBeginDate(simpleDateFormat.parse(minStr));
			}
			if (!StringUtils.isEmpty(datemax)){
				String maxStr=datemax+" 23:59:59";
				req.setEndDate(simpleDateFormat.parse(maxStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}
		UserPo userPo = userService.selectById(userID);
		if (userPo !=null){
			req.setStoreID(userPo.getStoreID());
		}else {
			req.setStoreID("0");//1-8正常店铺
		}
		req.setAgreementID(agreementID);

		vo=this.tranInfoService.pageFuzzyselect(vo,req);


		TransInfoPo res = this.tranInfoService.statisticsInfo(req);

		mv.addObject("list",vo);
		mv.addObject("sumCount",res.getCounts().toString());
		mv.addObject("sumMoney",res.getSumMoney() == null? "0":res.getSumMoney().toString());
		mv.addObject("min",datemin);
		mv.addObject("max",datemax);
		mv.addObject("agID",agreementID);
		return mv;
	}
	

	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/transtatistics/add");
		return mv;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		TransInfoPo list=tranInfoService.selectById(id);
		mv=new ModelAndView("/transtatistics/update");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(TransInfoPo transInfoPo,Integer userID){
		ModelAndView mv=null;
		String payDateStr = transInfoPo.getPayDateStr();
		String playdateStr = transInfoPo.getPlayDateStr();

		try {
			if (!StringUtils.isEmpty(payDateStr)){
				transInfoPo.setPayDate(simpleDateFormat.parse(payDateStr));
			}
			if (!StringUtils.isEmpty(playdateStr)){
				transInfoPo.setPlayDate(simpleDateFormat.parse(playdateStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}
		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			transInfoPo.setStoreID(userPo.getStoreID());
		}else{
			transInfoPo.setStoreID("0");//1-8正常店
		}
		transInfoPo.setCreateDate(new Date());
		transInfoPo.setUpdateDate(new Date());
		tranInfoService.insertAll(transInfoPo);
		mv=new ModelAndView("redirect:/TranStatistics/tolist.do?userID="+userID);
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(TransInfoPo transInfoPo,Integer userID){

		logger.info("TranStatics update req:userID:"+userID+"|transINfoPo:"+transInfoPo);
		ModelAndView mv=null;
		String payDateStr = transInfoPo.getPayDateStr();
		String playdateStr = transInfoPo.getPlayDateStr();

		try {
			if (!StringUtils.isEmpty(payDateStr)){
				transInfoPo.setPayDate(simpleDateFormat.parse(payDateStr));
			}
			if (!StringUtils.isEmpty(playdateStr)){
				transInfoPo.setPlayDate(simpleDateFormat.parse(playdateStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

		transInfoPo.setUpdateDate(new Date());
		tranInfoService.updateById(transInfoPo);
		mv=new ModelAndView("redirect:/TranStatistics/tolist.do?userID="+userID);
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String id,Integer userID){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
				tranInfoService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/TranStatistics/tolist.do?userID="+userID);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/selectByAgreementID")
	public Object selectByName(String agreementID){
		int accout = tranInfoService.selectByAgreementID(agreementID);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}

	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id,Integer stayregisterdetailsId,String min, String max){
		ModelAndView mv=null;
		TransInfoPo list=tranInfoService.selectById(id);

		mv=new ModelAndView("/transtatistics/particulars");
		mv.addObject("list",list);
		mv.addObject("id",id);
		mv.addObject("min",min);
		mv.addObject("max",max);
		return mv;
	}
}
