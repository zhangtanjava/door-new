package com.gx.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.po.ParametersInfoSepChild;
import com.gx.po.Parametersinfo;
import com.gx.po.UserPo;
import com.gx.service.ParametersHandleService;
import com.gx.service.UserService;
@Service(value="convert2map")
public class Convert2map {
	@Autowired
	ParametersHandleService parametersHandleService;
	@Autowired
	private UserService userService;
	
	Logger logger = Logger.getLogger(Convert2map.class);
	
	public Map<String, Object> wlInstall(Map<String, Object> map,Integer id) {
		
		ParametersInfoSepChild parametersinfo = parametersHandleService.selectById(id);
		
		UserPo userPo = new UserPo();
		userPo.setUserName(parametersinfo.getOperatorID());
		UserPo userRes  = userService.selectByName(userPo);
		if (userRes != null) {
			map.put("storeID", userRes.getStoreID()==null?"":userRes.getStoreID());
		}
		
		map.put("installDate", DateUtils.get8Str(parametersinfo.getInstallDate()==null?new Date():parametersinfo.getInstallDate()));
		map.put("createDate",  DateUtils.get8Str(parametersinfo.getCreateDate()==null?new Date():parametersinfo.getCreateDate()));
		map.put("doorMod", parametersinfo.getModel()==null?"":parametersinfo.getModel());
		map.put("price", parametersinfo.getSmartLock()==null?"":parametersinfo.getSmartLock());
		StringBuffer direction = new StringBuffer();
		direction.append(parametersinfo.getDoorSize()==null?"":parametersinfo.getDoorSize()).append("|").
		append(parametersinfo.getDirection()==null?"":parametersinfo.getDirection());
		map.put("direction", direction.toString());
		map.put("dm", parametersinfo.getPrice()==null?"":parametersinfo.getPrice());
		//改动了这个两个
		map.put("indoorInfo", parametersinfo.getInstallPerSmark()==null?"":parametersinfo.getInstallPerSmark());
		map.put("payment", parametersinfo.getJjrAmt()==null?"":parametersinfo.getJjrAmt());
		map.put("unitsOrAddress", parametersinfo.getUnitsOrAddress()==null?"":parametersinfo.getUnitsOrAddress());
		map.put("contactPhoneNumber", parametersinfo.getContactPhoneNumber()==null?"":parametersinfo.getContactPhoneNumber());
		map.put("secondPhoneNumber", parametersinfo.getSecondPhoneNumber()==null?"":parametersinfo.getSecondPhoneNumber());
		map.put("surveySmark", parametersinfo.getSurveyorSmark()==null?"":parametersinfo.getSurveyorSmark());
		map.put("installPerSmark", parametersinfo.getInstallPerSmark()==null?"":parametersinfo.getInstallPerSmark());
		return map;
	}
	public Map<String, Object> wlSurveyWord(Map<String, Object> map,Integer id) {
		
		ParametersInfoSepChild parametersinfo = parametersHandleService.selectById(id);
		
		UserPo userPo = new UserPo();
		userPo.setUserName(parametersinfo.getOperatorID());
		UserPo userRes  = userService.selectByName(userPo);
		if (userRes != null) {
			map.put("storeID", userRes.getStoreID()==null?"":userRes.getStoreID());
		}
		map.put("createDate",  DateUtils.get8Str(parametersinfo.getCreateDate()==null?new Date():parametersinfo.getCreateDate()));
		map.put("doorMod", parametersinfo.getModel()==null?"":parametersinfo.getModel());
		map.put("price", parametersinfo.getPrice()==null?"":parametersinfo.getPrice());
		logger.info("定金："+parametersinfo.getDeposit()==null?"":parametersinfo.getDeposit());
		map.put("deposite", parametersinfo.getDeposit()==null?"":parametersinfo.getDeposit());
		BigDecimal price = (BigDecimal) (parametersinfo.getPrice()==null?0:parametersinfo.getPrice());
		BigDecimal deposit = (BigDecimal) (parametersinfo.getDeposit()==null?0:parametersinfo.getDeposit());
		BigDecimal balance = price.subtract(deposit);//余额 = 价格-定金
		map.put("balance", balance);
		map.put("unitsOrAddress", parametersinfo.getUnitsOrAddress()==null?"":parametersinfo.getUnitsOrAddress());
		map.put("contactPhoneNumber", parametersinfo.getContactPhoneNumber()==null?"":parametersinfo.getContactPhoneNumber());
		map.put("holeSize", parametersinfo.getHoleSize()==null?"":parametersinfo.getHoleSize());
		map.put("doorSize", parametersinfo.getDoorSize()==null?"":parametersinfo.getDoorSize());
		map.put("indoorInfo", parametersinfo.getInstallPerSmark()==null?"":parametersinfo.getInstallPerSmark());
		//map.put("cutInfo", parametersinfo.getCutInfo()==null?"":parametersinfo.getCutInfo());
		map.put("cutInfo", "");
		map.put("surveyorSmark",parametersinfo.getSurveyorSmark()==null?"":parametersinfo.getSurveyorSmark());
		return map;
	}
	public Map<String, Object> wlFixWord(Map<String, Object> map,Integer id) {
		
		ParametersInfoSepChild parametersinfo = parametersHandleService.selectById(id);
		
		UserPo userPo = new UserPo();
		userPo.setUserName(parametersinfo.getOperatorID());
		UserPo userRes  = userService.selectByName(userPo);
		if (userRes != null) {
			map.put("storeID", userRes.getStoreID()==null?"":userRes.getStoreID());
		}
		
//		map.put("fxiDate", DateUtils.get8Str(parametersinfo.getFixDate()==null?new Date():parametersinfo.getFixDate()));
		map.put("fxiDate", DateUtils.get8Str(new Date()));
		map.put("createDate",  DateUtils.get8Str(parametersinfo.getCreateDate()==null?new Date():parametersinfo.getCreateDate()));
		map.put("doorMod", parametersinfo.getModel()==null?"":parametersinfo.getModel());
		map.put("installDate",  DateUtils.get8Str(parametersinfo.getInstallDate()==null?new Date():parametersinfo.getInstallDate()));
		StringBuffer direction = new StringBuffer();
		direction.append(parametersinfo.getDoorSize()==null?"":parametersinfo.getDoorSize()).append("|").
		append(parametersinfo.getDirection()==null?"":parametersinfo.getDirection());
		map.put("direction", direction.toString());
		map.put("surveyor", parametersinfo.getSurveyor()==null?"":parametersinfo.getSurveyor());
		map.put("installPerson", parametersinfo.getInstallPerson()==null?"":parametersinfo.getInstallPerson());
		map.put("unitsOrAddress", parametersinfo.getUnitsOrAddress()==null?"":parametersinfo.getUnitsOrAddress());
		map.put("contactPhoneNumber", parametersinfo.getContactPhoneNumber()==null?"":parametersinfo.getContactPhoneNumber());
		map.put("secondPhoneNumber", parametersinfo.getSecondPhoneNumber()==null?"":parametersinfo.getSecondPhoneNumber());
//		map.put("fixObject", parametersinfo.getFixObject()==null?"":parametersinfo.getFixObject());
		map.put("fixObject", "");
		map.put("fixSmark", parametersinfo.getFixSmarkOne()==null?"":parametersinfo.getFixSmarkOne());
		map.put("fixSmarkTwo", parametersinfo.getFixSmarkTwo()==null?"":parametersinfo.getFixSmarkTwo());
		return map;
	}
	
	public Map<String, Object> yaKouWord(Map<String, Object> map,Integer id) {
		
		ParametersInfoSepChild parametersinfo = parametersHandleService.selectById(id);
		
		UserPo userPo = new UserPo();
		userPo.setUserName(parametersinfo.getOperatorID());
		UserPo userRes  = userService.selectByName(userPo);
		if (userRes != null) {
			map.put("storeID", userRes.getStoreID()==null?"":userRes.getStoreID());
		}
		
		map.put("installDate",  DateUtils.get8Str(parametersinfo.getInstallDate()==null?new Date():parametersinfo.getInstallDate()));
		map.put("createDate",  DateUtils.get8Str(parametersinfo.getCreateDate()==null?new Date():parametersinfo.getCreateDate()));
		map.put("doorMod", parametersinfo.getModel()==null?"":parametersinfo.getModel());
		map.put("unitsOrAddress", parametersinfo.getUnitsOrAddress()==null?"":parametersinfo.getUnitsOrAddress());
		map.put("contactPhoneNumber", parametersinfo.getContactPhoneNumber()==null?"":parametersinfo.getContactPhoneNumber());
		map.put("secondPhoneNumber", parametersinfo.getSecondPhoneNumber()==null?"":parametersinfo.getSecondPhoneNumber());
		map.put("holeSize", parametersinfo.getHoleSize()==null?"":parametersinfo.getHoleSize());
//		map.put("colorRequire", parametersinfo.getColorRequire()==null?"":parametersinfo.getColorRequire());
//		map.put("doorBottomInfo", parametersinfo.getDoorBottomInfo()==null?"":parametersinfo.getDoorBottomInfo());
		map.put("colorRequire", "");
		map.put("doorBottomInfo", "");
		map.put("yakouSmark", parametersinfo.getYaKouSmark()==null?"":parametersinfo.getYaKouSmark());
		return map;
	}
}
