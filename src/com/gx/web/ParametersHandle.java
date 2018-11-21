package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.Parametersinfo;
import com.gx.po.UserPo;
import com.gx.service.ParametersHandleService;
import com.gx.service.UserService;
import com.gx.utils.DateUtils;
import com.gx.utils.ExcelUtil;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public ModelAndView tolist(String datemin, String datemax,String contactPhoneNumber,
			Integer currentPage,String unitsOrAddress,Integer userID,String stID) throws UnsupportedEncodingException{

		if (unitsOrAddress != null && !"".equals(unitsOrAddress)) {
			byte[] b=unitsOrAddress.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
			unitsOrAddress=new String(b,"utf-8");//采用utf-8去接string
		}
		if (stID != null && !"".equals(stID)) {
			byte[] b=stID.getBytes("ISO-8859-1");//用tomcat的格式（iso-8859-1）方式去读。
			stID=new String(b,"utf-8");//采用utf-8去接string
		}
		
		logger.info("ParametersHandle tolist req:"+datemin+"|"+datemax+"|"+unitsOrAddress+"|"+stID);
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
		if ("0".equals(req.getRoleID())) {
			req.setStoreID(stID);
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
		mv.addObject("sID", stID);
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

//	@RequestMapping(value = "/exportfeedback")
//    @ResponseBody
//    public String exportFeedBack(HttpServletResponse response,
//            @RequestParam(value="query", required=false) String searchText,
//            @RequestParam(value="type", required=false) String strType,
//            @RequestParam(value="startDate", required=false) String startDate,
//            @RequestParam(value="endDate", required=false) String endDate){
//        
//        String fileName = "反馈明细"+System.currentTimeMillis()+".xls"; //文件名 
//        String sheetName = "反馈明细";//sheet名
//        
//        //String []title = new String[]{"Id","导航图标","反馈类型","内容","联系方式","应用Id","应用版本","反馈时间"};//标题
//        String []title = new String[]{"Id"};//标题
//        
//        List<Parametersinfo> list = parametersHandleService.selectAll();//内容list
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        
//        String [][]values = new String[list.size()][];
//        for(int i=0;i<list.size();i++){
//            values[i] = new String[title.length];
//            //将对象内容转换成string
//            Parametersinfo obj = list.get(i);
//            values[i][0] = obj.getId()+"";
////            values[i][1] = obj.getFiles();
////            values[i][2] = obj.getFbType();
////            values[i][3] = obj.getContent();
////            values[i][4] = obj.getContactInfo();
////            values[i][5] = obj.getAppId();
////            values[i][6] = obj.getVersionName();
////            values[i][7] = sdf.format(obj.getCreateTime());
//            
//        }
//        
//        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
//        
//        //将文件存到指定位置  
//        try {  
//             this.setResponseHeader(response, fileName);  
//             OutputStream os = response.getOutputStream();  
//             wb.write(os);  
//             os.flush();  
//             os.close();  
//        } catch (Exception e) {  
//             e.printStackTrace();  
//        }  
//        return "ok";
//    }
//    
//     public void setResponseHeader(HttpServletResponse response, String fileName) {  
//         try {  
//              try {  
//                   fileName = new String(fileName.getBytes(),"ISO8859-1");  
//              } catch (UnsupportedEncodingException e) {  
//                   // TODO Auto-generated catch block  
//                   e.printStackTrace();  
//              }  
//              response.setContentType("application/octet-stream;charset=ISO8859-1");  
//              response.setHeader("Content-Disposition", "attachment;filename="+ fileName);  
//              response.addHeader("Pargam", "no-cache");  
//              response.addHeader("Cache-Control", "no-cache");  
//         } catch (Exception ex) {  
//              ex.printStackTrace();  
//         }  
//    } 
}
