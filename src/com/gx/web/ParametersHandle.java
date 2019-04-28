package com.gx.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.enums.FileType;
import com.gx.page.Page;
import com.gx.po.ParametersInfoSepChild;
import com.gx.po.Parametersinfo;
import com.gx.po.UserPo;
import com.gx.service.ParametersHandleService;
import com.gx.service.UserService;
import com.gx.utils.DateUtils;

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
	public ModelAndView tolist(String datemin, String datemax, String contactPhoneNumber, Integer currentPage,
			String unitsOrAddress, Integer userID, String stID, String installPerson)
			throws UnsupportedEncodingException {

		if (unitsOrAddress != null && !"".equals(unitsOrAddress)) {
			byte[] b = unitsOrAddress.getBytes("ISO-8859-1");// 用tomcat的格式（iso-8859-1）方式去读。
			unitsOrAddress = new String(b, "utf-8");// 采用utf-8去接string
		}
		if (stID != null && !"".equals(stID)) {
			byte[] b = stID.getBytes("ISO-8859-1");// 用tomcat的格式（iso-8859-1）方式去读。
			stID = new String(b, "utf-8");// 采用utf-8去接string
		}
		if (installPerson != null && !"".equals(installPerson)) {
			byte[] b = installPerson.getBytes("ISO-8859-1");// 用tomcat的格式（iso-8859-1）方式去读。
			installPerson = new String(b, "utf-8");// 采用utf-8去接string
		}

		logger.info("ParametersHandle tolist req:" + datemin + "|" + datemax + "|" + unitsOrAddress + "|"
				+ contactPhoneNumber + "|" + currentPage + "|" + unitsOrAddress + "|" + userID + "|" + stID);
		ModelAndView mv = null;
		if (currentPage == null) {
			currentPage = 1;
		} else if (currentPage == 0) {
			currentPage = 1;
		}
		mv = new ModelAndView("/parametershandle/parametershandle");

		ParametersInfoSepChild req = new ParametersInfoSepChild();

		Page<ParametersInfoSepChild> vo = new Page<ParametersInfoSepChild>();
		vo.setCurrentPage(currentPage);
		try {
			if (!StringUtils.isEmpty(datemin)) {
				String minStr = datemin + " 00:00:00";
				req.setBeginDate(simpleDateFormat.parse(minStr));
			}
			if (!StringUtils.isEmpty(datemax)) {
				String maxStr = datemax + " 23:59:59";
				req.setEndDate(simpleDateFormat.parse(maxStr));
			}
		} catch (Exception e) {
			logger.info("日期转换异常：" + e);
		}
		UserPo userPo = userService.selectById(userID);
		if (userPo != null) {
			req.setStoreID(userPo.getStoreID());
			req.setRoleID(userPo.getRoleID());
		}
		if ("0".equals(req.getRoleID())) {
			req.setStoreID(stID);
		}
		req.setUnitsOrAddress(unitsOrAddress);
		req.setContactPhoneNumber(contactPhoneNumber);
		req.setInstallPerson(installPerson);
		vo = this.parametersHandleService.pageFuzzyselect(vo, req);

		ParametersInfoSepChild res = this.parametersHandleService.statisticsInfo(req);

		mv.addObject("list", vo);
		mv.addObject("min", datemin);
		mv.addObject("max", datemax);
		mv.addObject("agID", contactPhoneNumber);
		mv.addObject("merN", unitsOrAddress);
		mv.addObject("instPerson", installPerson);
		mv.addObject("sID", stID);
		mv.addObject("sumCount", res.getCounts().toString());
		mv.addObject("sumMoney", res.getSumMoney() == null ? "0" : res.getSumMoney().toString());
		mv.addObject("sumDepositMoney", res.getSumDepositMoney() == null ? "0" : res.getSumDepositMoney().toString());

		return mv;
	}

	@RequestMapping("/toadd")
	public ModelAndView toadd() {
		ModelAndView mv = null;
		mv = new ModelAndView("/parametershandle/add");
		return mv;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id) {
		ModelAndView mv = null;
		ParametersInfoSepChild list = parametersHandleService.selectById(id);
		mv = new ModelAndView("/parametershandle/update");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, 
			ParametersInfoSepChild parametersinfo,
			@RequestParam("frontMoneyFile") MultipartFile frontMoneyFile,
			@RequestParam("agreementFile") MultipartFile agreementFile,
			@RequestParam("seAgreementFile") MultipartFile seAgreementFile,
			@RequestParam("surveyorFile") MultipartFile surveyorFile,
			@RequestParam("istallFile") MultipartFile istallFile,
			@RequestParam("smartLockFile") MultipartFile smartLockFile,
			@RequestParam("userID") Integer userID) {

		ModelAndView mv = null;

		// 定金图片
		photosFileSave(parametersinfo, frontMoneyFile, FileType.FRONTMONEY_FILE.getValue());
		// 合同图片1
		photosFileSave(parametersinfo, agreementFile, FileType.AGREEMENT_FILE.getValue());
		// 合同图片2
		photosFileSave(parametersinfo, seAgreementFile, FileType.SEAGREEMENT_FILE.getValue());
		// 测量图片
		photosFileSave(parametersinfo, surveyorFile, FileType.SURVEYOR_FILE.getValue());
		// 安装图片
		photosFileSave(parametersinfo, smartLockFile, FileType.SMARTLOCL_FILE.getValue());
		// 智能锁图片
		photosFileSave(parametersinfo, istallFile, FileType.ISTALL_FILE.getValue());
		// 日期格式处理
		dateStrParse(parametersinfo);

		//前台如果不选店铺，默认为该员工所属店
		if ("0".equals(parametersinfo.getStoreID())) {
			UserPo userPo = userService.selectById(userID);
			parametersinfo.setStoreID(userPo.getStoreID());
		}
		parametersHandleService.insertAll(parametersinfo);
		mv = new ModelAndView("redirect:/ParametersHandle/tolist.do?userID=" + userID);
		return mv;
	}

	

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, 
			ParametersInfoSepChild parametersinfo,
			@RequestParam("frontMoneyFile") MultipartFile frontMoneyFile,
			@RequestParam("agreementFile") MultipartFile agreementFile,
			@RequestParam("seAgreementFile") MultipartFile seAgreementFile,
			@RequestParam("surveyorFile") MultipartFile surveyorFile,
			@RequestParam("istallFile") MultipartFile istallFile,
			@RequestParam("smartLockFile") MultipartFile smartLockFile,
			@RequestParam("userID") Integer userID) {
		ModelAndView mv = null;

		ParametersInfoSepChild p1 = parametersHandleService.selectById(parametersinfo.getId());
		String frontMoneyPath = p1.getFrontMoneyFilePath();
		String agreementPhotoPath = p1.getAgreementPhotoPath();
		String seAgreePhotoPath = p1.getSeAgreementPhotoPath();
		String surveyPath = p1.getSurveyorPhotoPath();
		String istallPath = p1.getIstallPhotoPath();
		String smartLockPath = p1.getSmartLockFilePath();
		
		//定金图片修改
		photosFileUpdate(parametersinfo, frontMoneyFile, "frontMoneyFile", frontMoneyPath);
		//合同图片修改
		photosFileUpdate(parametersinfo, agreementFile,"agreementFile", agreementPhotoPath);
		//合同二图片修改
		photosFileUpdate(parametersinfo, seAgreementFile, "seAgreementFile", seAgreePhotoPath);
		//测量图片修改
		photosFileUpdate(parametersinfo, surveyorFile, "surveyorFile", surveyPath);
		//安装图片修改
		photosFileUpdate(parametersinfo, istallFile, "istallFile", istallPath);
		//智能锁图片修改
		photosFileUpdate(parametersinfo, smartLockFile, "smartLockFile", smartLockPath);
		// 日期格式处理
		dateStrParse(parametersinfo);
		//前台如果不选店铺，默认为该员工所属店
		if ("0".equals(parametersinfo.getStoreID())) {
			UserPo userPo = userService.selectById(userID);
			parametersinfo.setStoreID(userPo.getStoreID());
		}
		parametersHandleService.updateById(parametersinfo);
		mv = new ModelAndView("redirect:/ParametersHandle/tolist.do?userID=" + userID);
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") String id, @RequestParam("userID") Integer userID) {
		ModelAndView mv = null;
		String[] FenGe = id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			parametersHandleService.deleteById(Integer.parseInt(FenGe[i]));
		}
		String storeID = "0";
		UserPo userPo = userService.selectById(userID);
		if (userPo != null) {
			storeID = userPo.getStoreID();
		}
		mv = new ModelAndView("redirect:/ParametersHandle/tolist.do?userID=" + userID);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/selectByAgreementID")
	public Object selectByName(String agreementID) {
		int accout = parametersHandleService.selectByAgreementID(agreementID);
		Gson gson = new Gson();
		return gson.toJson(accout);
	}

	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id, Integer stayregisterdetailsId, String min, String max) {
		ModelAndView mv = null;
		ParametersInfoSepChild list = parametersHandleService.selectById(id);

		mv = new ModelAndView("/parametershandle/particulars");
		mv.addObject("list", list);
		mv.addObject("id", id);
		mv.addObject("min", min);
		mv.addObject("max", max);
		return mv;
	}

	private void dateStrParse(ParametersInfoSepChild parametersinfo) {
		String createDateStr = parametersinfo.getCreateDateStr();
		String payDateStr = parametersinfo.getPayDateStr();
		String surveyorDateStr = parametersinfo.getSurveyorDateStr();
		String installDateStr = parametersinfo.getInstallDateStr();
		String smartLockDateStr = parametersinfo.getSmartLockDateStr();
		logger.info("surveyorDateStr:" + surveyorDateStr + "installDateStr:" + installDateStr + "createDateStr:"
				+ createDateStr + "smartLockDateStr:" + smartLockDateStr + "payDateStr:" + payDateStr);
		try {
			if (!StringUtils.isEmpty(surveyorDateStr)) {
				parametersinfo.setSurveyorDate(simpleDateFormat.parse(surveyorDateStr));
			}
			if (!StringUtils.isEmpty(installDateStr)) {
				parametersinfo.setInstallDate(simpleDateFormat.parse(installDateStr));
			}
			if (!StringUtils.isEmpty(createDateStr)) {
				parametersinfo.setCreateDate(simpleDateFormat.parse(createDateStr));
			}
			 if (!StringUtils.isEmpty(payDateStr)){
			 parametersinfo.setPayDate(simpleDateFormat.parse(payDateStr));
			 }
			 if (!StringUtils.isEmpty(smartLockDateStr)){
			 parametersinfo.setSmartLockDate(simpleDateFormat.parse(smartLockDateStr));
			 }
		} catch (Exception e) {
			logger.info("日期转换异常：" + e);
		}
		parametersinfo.setUpdateDate(new Date());
	}
	private void photosFileUpdate(ParametersInfoSepChild parametersinfo, MultipartFile file, String fileType,String oldFilePath) {
		if (!file.isEmpty()) {
			// 删除原来的文件，新建文件
			if (!StringUtils.isEmpty(oldFilePath)) {
				File oldfile = new File(oldFilePath);
				oldfile.delete();
			}
			photosFileSave(parametersinfo, file, fileType);
		}
	}
	
	private void photosFileSave(ParametersInfoSepChild parametersinfo, MultipartFile file, String fileType) {
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = "/Users/zhangtan/Pictures" + File.separator + DateUtils.getToday() + File.separator
					+ fileType;
			logger.info(fileType + "图片文件上传文件路径：" + path);
			// 上传文件名
			String filename = file.getOriginalFilename();
			logger.info(fileType + "图片文件上传文件名：" + filename);

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
			if (FileType.FRONTMONEY_FILE.getValue().equals(fileType)) {
				parametersinfo.setFrontMoneyFilePath(path + File.separator + filename);
				parametersinfo.setFrontMoneyFileName(filename);
			} else if (FileType.AGREEMENT_FILE.getValue().equals(fileType)) {
				parametersinfo.setAgreementPhotoPath(path + File.separator + filename);
				parametersinfo.setAgreementPhotoName(filename);
			} else if (FileType.SEAGREEMENT_FILE.getValue().equals(fileType)) {
				parametersinfo.setSeAgreementPhotoPath(path + File.separator + filename);
				parametersinfo.setSeAgreementPhotoName(filename);
			} else if (FileType.SURVEYOR_FILE.getValue().equals(fileType)) {
				parametersinfo.setSurveyorPhotoPath(path + File.separator + filename);
				parametersinfo.setSurveyorPhotoName(filename);
			} else if (FileType.ISTALL_FILE.getValue().equals(fileType)) {
				parametersinfo.setIstallPhotoPath(path + File.separator + filename);
				parametersinfo.setIstallPhotoName(filename);
			} else if (FileType.SMARTLOCL_FILE.getValue().equals(fileType)) {
				parametersinfo.setSmartLockFilePath(path + File.separator + filename);
				parametersinfo.setSmartLockFileName(filename);
			}
			logger.info(fileType + "图片文件保存成功！");
		} else {
			logger.info(fileType + "图片文件保存失败！");
		}
	}
	
	// @RequestMapping(value = "/exportfeedback")
	// @ResponseBody
	// public String exportFeedBack(HttpServletResponse response,
	// @RequestParam(value="query", required=false) String searchText,
	// @RequestParam(value="type", required=false) String strType,
	// @RequestParam(value="startDate", required=false) String startDate,
	// @RequestParam(value="endDate", required=false) String endDate){
	//
	// String fileName = "反馈明细"+System.currentTimeMillis()+".xls"; //文件名
	// String sheetName = "反馈明细";//sheet名
	//
	// //String []title = new
	// String[]{"Id","导航图标","反馈类型","内容","联系方式","应用Id","应用版本","反馈时间"};//标题
	// String []title = new String[]{"Id"};//标题
	//
	// List<Parametersinfo> list = parametersHandleService.selectAll();//内容list
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//
	// String [][]values = new String[list.size()][];
	// for(int i=0;i<list.size();i++){
	// values[i] = new String[title.length];
	// //将对象内容转换成string
	// Parametersinfo obj = list.get(i);
	// values[i][0] = obj.getId()+"";
	//// values[i][1] = obj.getFiles();
	//// values[i][2] = obj.getFbType();
	//// values[i][3] = obj.getContent();
	//// values[i][4] = obj.getContactInfo();
	//// values[i][5] = obj.getAppId();
	//// values[i][6] = obj.getVersionName();
	//// values[i][7] = sdf.format(obj.getCreateTime());
	//
	// }
	//
	// HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
	//
	// //将文件存到指定位置
	// try {
	// this.setResponseHeader(response, fileName);
	// OutputStream os = response.getOutputStream();
	// wb.write(os);
	// os.flush();
	// os.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "ok";
	// }
	//
	// public void setResponseHeader(HttpServletResponse response, String fileName)
	// {
	// try {
	// try {
	// fileName = new String(fileName.getBytes(),"ISO8859-1");
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// response.setContentType("application/octet-stream;charset=ISO8859-1");
	// response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	// response.addHeader("Pargam", "no-cache");
	// response.addHeader("Cache-Control", "no-cache");
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }
}
