package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.Parametersinfo;
import com.gx.po.UserPo;
import com.gx.service.ParametersHandleService;
import com.gx.service.UserService;
import com.gx.utils.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/ParametersHandle")
public class ParametersHandle {

	Logger logger = Logger.getLogger(ParametersHandle.class);

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private ParametersHandleService parametersHandleService;
	@Autowired
	private UserService userService;
	@RequestMapping("/tolist")
	public ModelAndView tolist(String datemin, String datemax,String contactPhoneNumber,Integer currentPage,String unitsOrAddress,Integer userID) throws UnsupportedEncodingException{

		if (unitsOrAddress != null && !"".equals(unitsOrAddress)) {
			byte[] b=unitsOrAddress.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
			unitsOrAddress=new String(b,"utf-8");//采用utf-8去接string
		}
	
		logger.info("ParametersHandle tolist req:"+datemin+"|"+datemax+"|"+unitsOrAddress);
		ModelAndView mv=null;
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		mv=new ModelAndView("/parametershandle/parametershandle");

		Parametersinfo req = new Parametersinfo();

		Page<Parametersinfo> vo=new Page<Parametersinfo>();
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
		if (userPo != null){
			req.setStoreID(userPo.getStoreID());
			req.setRoleID(userPo.getRoleID());
		}
		
		req.setUnitsOrAddress(unitsOrAddress);
		req.setContactPhoneNumber(contactPhoneNumber);
		vo=this.parametersHandleService.pageFuzzyselect(vo,req);

		Parametersinfo res = this.parametersHandleService.statisticsInfo(req);
		
		mv.addObject("list",vo);
		mv.addObject("min",datemin);
		mv.addObject("max",datemax);
		mv.addObject("agID",contactPhoneNumber);
		mv.addObject("merN",unitsOrAddress);
		mv.addObject("sumCount",res.getCounts().toString());
		mv.addObject("sumMoney",res.getSumMoney() == null? "0":res.getSumMoney().toString());
		mv.addObject("sumDepositMoney",res.getSumDepositMoney() == null? "0":res.getSumDepositMoney().toString());
		
		return mv;
	}
	

	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/parametershandle/add");
		return mv;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		Parametersinfo list=parametersHandleService.selectById(id);
		mv=new ModelAndView("/parametershandle/update");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, Parametersinfo parametersinfo,
	@RequestParam("surveyorFile") MultipartFile surveyorFile
	,@RequestParam("istallFile") MultipartFile istallFile
	,@RequestParam("agreementFile") MultipartFile agreementFile
			,@RequestParam("userID") Integer userID){

		ModelAndView mv=null;

		//如果合同文件不为空，写入上传路径
		if(!agreementFile.isEmpty()) {
			//上传文件路径
			String path = "/Users/zhangtan/Pictures"+
					File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "agreementFile";
			logger.info("合同图片上传文件路径："+path);
			//上传文件名
			String filename = agreementFile.getOriginalFilename();
            logger.info("合同图片上传文件名："+filename);

			File filepath = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件当中
			try {
				agreementFile.transferTo(new File(path + File.separator + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			parametersinfo.setAgreementPhotoPath(path + File.separator + filename);
			parametersinfo.setAgreementPhotoName(filename);
			logger.info("合同图片保存成功！");
		} else {
			logger.info("合同图片保存失败！");
		}
				
		//如果测量文件不为空，写入上传路径
		if(!surveyorFile.isEmpty()) {
			//上传文件路径
			String path = "/Users/zhangtan/Pictures"+
					File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "surveyorFile";
			logger.info("上传文件路径："+path);
			//上传文件名
			String filename = surveyorFile.getOriginalFilename();
            logger.info("上传文件名："+filename);

			File filepath = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件当中
			try {
				surveyorFile.transferTo(new File(path + File.separator + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			parametersinfo.setSurveyorPhotoPath(path + File.separator + filename);
			parametersinfo.setSurveyorPhotoName(filename);
			logger.info("测量图片保存成功！");
		} else {
			logger.info("测量图片保存失败！");
		}

		//如果安装文件不为空，写入上传路径
		if(!istallFile.isEmpty()) {
			//上传文件路径
			String path = "/Users/zhangtan/Pictures"+
					File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "istallFile";
			logger.info("上传文件路径："+path);
			//上传文件名
			String filename = istallFile.getOriginalFilename();
			logger.info("上传文件名："+filename);
			File filepath = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件当中
			try {
                istallFile.transferTo(new File(path + File.separator + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			parametersinfo.setIstallPhotoPath(path + File.separator + filename);
			parametersinfo.setIstallPhotoName(filename);
			logger.info("安装图片保存成功！");
		} else {
			logger.info("安装图片保存失败！");
		}

		String surveyorDateStr = parametersinfo.getSurveyorDateStr();
		String installDateStr = parametersinfo.getInstallDateStr();
		String createDateStr = parametersinfo.getCreateDateStr();
		String fixDateStr = parametersinfo.getFixDateStr();
		String yaKouInstallDateStr = parametersinfo.getYaKouInstallDateStr();
		String payDateStr = parametersinfo.getPayDateStr();
		logger.info("surveyorDateStr:"+surveyorDateStr+"installDateStr:"+installDateStr+"createDateStr:"+createDateStr
				+"fixDateStr"+fixDateStr+"yaKouInstallDateStr:"+yaKouInstallDateStr+"payDateStr:"+payDateStr);
		try {
			if (!StringUtils.isEmpty(surveyorDateStr)){
				parametersinfo.setSurveyorDate(simpleDateFormat.parse(surveyorDateStr));
			}
			if (!StringUtils.isEmpty(installDateStr)){
				parametersinfo.setInstallDate(simpleDateFormat.parse(installDateStr));
			}
			if (!StringUtils.isEmpty(createDateStr)){
				parametersinfo.setCreateDate(simpleDateFormat.parse(createDateStr));
			}
			if (!StringUtils.isEmpty(fixDateStr)){
				parametersinfo.setFixDate(simpleDateFormat.parse(fixDateStr));
			}
			if (!StringUtils.isEmpty(yaKouInstallDateStr)){
				parametersinfo.setYaKouInstallDate(simpleDateFormat.parse(yaKouInstallDateStr));
			}
			if (!StringUtils.isEmpty(payDateStr)){
				parametersinfo.setPayDate(simpleDateFormat.parse(payDateStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

		parametersinfo.setUpdateDate(new Date());

		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			parametersinfo.setStoreID(userPo.getStoreID());
			parametersinfo.setRoleID(userPo.getRoleID());
		}else{
			//parametersinfo.setStoreID("0");//1-8正常店
			parametersinfo.setRoleID("2");//0 领导 1 员工
		}

		parametersHandleService.insertAll(parametersinfo);

		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do?userID="+userID);
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, Parametersinfo parametersinfo,
                               @RequestParam("surveyorFile") MultipartFile surveyorFile
            ,@RequestParam("istallFile") MultipartFile istallFile
            ,@RequestParam("agreementFile") MultipartFile agreementFile
			,@RequestParam("userID") Integer userID){
		ModelAndView mv=null;

        Parametersinfo parametersinfo1 = parametersHandleService.selectById(parametersinfo.getId());
        String surveyPath = parametersinfo1.getSurveyorPhotoPath();
        String istallPath = parametersinfo1.getIstallPhotoPath();
        String agreementPhotoPath = parametersinfo1.getAgreementPhotoPath();
        //如果文件不为空，写入上传路径
        if(!surveyorFile.isEmpty()) {
			//删除原来的文件，新建文件
			if (!StringUtils.isEmpty(surveyPath)){
				File file = new File(surveyPath);
				file.delete();
			}

            //上传文件路径
            String path = "/Users/zhangtan/Pictures"+
					File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "surveyorFile";
            logger.info("上传文件路径："+path);
            //上传文件名
            String filename = surveyorFile.getOriginalFilename();
            logger.info("上传文件名："+filename);

            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                surveyorFile.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            parametersinfo.setSurveyorPhotoPath(path + File.separator + filename);
			parametersinfo.setSurveyorPhotoName(filename);
            logger.info("测量图片保存成功！");
        } else {
            logger.info("测量图片保存失败！");
        }

        //如果文件不为空，写入上传路径
        if(!istallFile.isEmpty()) {
        	//删除原来文件
			if (!StringUtils.isEmpty(istallPath)){
				File file = new File(istallPath);
				file.delete();
			}

            //上传文件路径
            String path = "/Users/zhangtan/Pictures"+
			File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "istallFile";
            logger.info("上传文件路径："+path);
            //上传文件名
            String filename = istallFile.getOriginalFilename();
            logger.info("上传文件名："+filename);
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                istallFile.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            parametersinfo.setIstallPhotoPath(path + File.separator + filename);
			parametersinfo.setIstallPhotoName(filename);
            logger.info("安装图片保存成功！");
        } else {
            logger.info("安装图片保存失败！");
        }

        //如果文件不为空，写入上传路径
        if(!agreementFile.isEmpty()) {
			//删除原来的文件，新建文件
			if (!StringUtils.isEmpty(agreementPhotoPath)){
				File file = new File(agreementPhotoPath);
				file.delete();
			}

            //上传文件路径
            String path = "/Users/zhangtan/Pictures"+
					File.separator + DateUtils.getToday()+
					File.separator + parametersinfo.getAgreementID()+
					File.separator + "agreementFile";
            logger.info("上传文件路径："+path);
            //上传文件名
            String filename = agreementFile.getOriginalFilename();
            logger.info("上传文件名："+filename);

            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
            	agreementFile.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            parametersinfo.setAgreementPhotoPath(path + File.separator + filename);
            parametersinfo.setAgreementPhotoName(filename);
            logger.info("合同图片保存成功！");
        } else {
            logger.info("合同图片保存失败！");
        }
        

		String surveyorDateStr = parametersinfo.getSurveyorDateStr();
		String installDateStr = parametersinfo.getInstallDateStr();
		String createDateStr = parametersinfo.getCreateDateStr();
		String fixDateStr = parametersinfo.getFixDateStr();
		String yaKouInstallDateStr = parametersinfo.getYaKouInstallDateStr();
		String payDateStr = parametersinfo.getPayDateStr();
		logger.info("surveyorDateStr:"+surveyorDateStr+"installDateStr:"+installDateStr+"createDateStr:"+createDateStr
				+"fixDateStr"+fixDateStr+"yaKouInstallDateStr:"+yaKouInstallDateStr+"payDateStr:"+payDateStr);
		try {
			if (!StringUtils.isEmpty(surveyorDateStr)){
				parametersinfo.setSurveyorDate(simpleDateFormat.parse(surveyorDateStr));
			}
			if (!StringUtils.isEmpty(installDateStr)){
				parametersinfo.setInstallDate(simpleDateFormat.parse(installDateStr));
			}
			if (!StringUtils.isEmpty(createDateStr)){
				parametersinfo.setCreateDate(simpleDateFormat.parse(createDateStr));
			}
			if (!StringUtils.isEmpty(fixDateStr)){
				logger.info("fixDateStr:"+fixDateStr);
				parametersinfo.setFixDate(simpleDateFormat.parse(fixDateStr));
			}
			if (!StringUtils.isEmpty(yaKouInstallDateStr)){
				parametersinfo.setYaKouInstallDate(simpleDateFormat.parse(yaKouInstallDateStr));
			}
			if (!StringUtils.isEmpty(payDateStr)){
				parametersinfo.setPayDate(simpleDateFormat.parse(payDateStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			parametersinfo.setStoreID(userPo.getStoreID());
			parametersinfo.setRoleID(userPo.getRoleID());
		}else{
			parametersinfo.setStoreID("0");//1-8正常店
			parametersinfo.setRoleID("2");//0 领导 1 员工
		}

		parametersinfo.setUpdateDate(new Date());
		parametersHandleService.updateById(parametersinfo);
		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do?userID="+userID);
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id")String id,@RequestParam("userID") Integer userID){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			parametersHandleService.deleteById(Integer.parseInt(FenGe[i]));
		}
		String storeID = "0";
		UserPo userPo = userService.selectById(userID);
		if (userPo != null){
			storeID=userPo.getStoreID();
		}
		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do?userID="+userID);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/selectByAgreementID")
	public Object selectByName(String agreementID){
		int accout = parametersHandleService.selectByAgreementID(agreementID);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}

	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id,Integer stayregisterdetailsId,String min, String max){
		ModelAndView mv=null;
		Parametersinfo list=parametersHandleService.selectById(id);

		mv=new ModelAndView("/parametershandle/particulars");
		mv.addObject("list",list);
		mv.addObject("id",id);
		mv.addObject("min",min);
		mv.addObject("max",max);
		return mv;
	}


}
