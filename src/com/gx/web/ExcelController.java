package com.gx.web;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.gx.po.ParametersInfoSepChild;
import com.gx.po.WlStore;
import com.gx.service.ParametersHandleService;
import com.gx.service.StoreHandleService;
import com.gx.utils.ExcelUtil;


@Controller
@RequestMapping(value="/excel")
public class ExcelController {
	Logger logger = Logger.getLogger(ParametersHandle.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ParametersHandleService parametersHandleService;
	@Autowired
	private StoreHandleService storeHandleService;
	
    @RequestMapping(value = "/exportfeedback")
    @ResponseBody
    public String exportFeedBack(HttpServletResponse response,
            @RequestParam(value="unitsOrAddress", required=false) String unitsOrAddress,
            @RequestParam(value="stID", required=false) String stID,
            @RequestParam(value="datemin", required=false) String datemin,
            @RequestParam(value="datemax", required=false) String datemax,
            @RequestParam(value="installPerson", required=false) String installPerson,
            @RequestParam(value="contactPhoneNumber", required=false) String contactPhoneNumber) throws UnsupportedEncodingException{
    	
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
		
        String fileName = "客户档案信息"+System.currentTimeMillis()+".xls"; //文件名 
        String sheetName = "客户档案信息";//sheet名
        
        String []title = new String[]{"店面","销售员","订货日期","定金图片",
        		"地址","电话1","电话2","合同图片1",
        		"型号","价格","定金","合同图片2",
        		"智能锁","销售备注","交居然日期","交居然金额",
        		"洞口尺寸","门的尺寸","门的方向","测量图片",
        		"测量日期","测量师傅","测量备注",
        		"安装日期","安装师傅","安装备注","门安装图片",
        		"垭口安装","智能猫眼","智能锁安装日期","智能锁安装图片",
        		"售后服务1","售后服务2","售后服务3","售后服务4",
        		"售后服务5","售后服务6","售后服务7","售后服务8",
        		"售后服务9","售后服务10",};//标题
        
        ParametersInfoSepChild parametersinfo = new ParametersInfoSepChild();
        logger.info("datemin:"+datemin+"|datemax:"+datemax);
        try {
			if (!StringUtils.isEmpty(datemin)) {
				String minStr = datemin + " 00:00:00";
				 parametersinfo.setBeginDate(sdf.parse(minStr));
			}
			if (!StringUtils.isEmpty(datemax)) {
				String maxStr = datemax + " 23:59:59";
				parametersinfo.setEndDate(sdf.parse(maxStr));
			}
		} catch (Exception e) {
			logger.info("日期转换异常：" + e);
		}
        parametersinfo.setUnitsOrAddress(unitsOrAddress);
        parametersinfo.setStoreID(stID);
        parametersinfo.setInstallPerson(installPerson);
        parametersinfo.setContactPhoneNumber(contactPhoneNumber);
        logger.info("生成excel表格所需要的查询条件参数："+parametersinfo.toString());
        List<ParametersInfoSepChild> list = parametersHandleService.selectByConditions(parametersinfo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String [][]values = new String[list.size()][];
        for(int i=0;i<list.size();i++){
            values[i] = new String[title.length];
            //将对象内容转换成string
            ParametersInfoSepChild obj = list.get(i);
            values[i][0] = obj.getStoreID();
            values[i][1] = obj.getSaler();
            values[i][2] = obj.getCreateDate()==null?"":sdf.format(obj.getCreateDate());
            values[i][3] = obj.getFrontMoneyFileName();
            values[i][4] = obj.getUnitsOrAddress();
            values[i][5] = obj.getContactPhoneNumber();
            values[i][6] = obj.getSecondPhoneNumber();
            values[i][7] = obj.getAgreementPhotoName();
            values[i][8] = obj.getModel();
            values[i][9] = obj.getPrice()==null?"":obj.getPrice().toString();
            values[i][10] = obj.getDeposit()==null?"":obj.getDeposit().toString();
            values[i][11] = obj.getSeAgreementPhotoName();
            values[i][12] = obj.getSmartLock();
            values[i][13] = obj.getSaleRemarks();
            values[i][14] = obj.getPayDate()==null?"":sdf.format(obj.getPayDate());
            values[i][15] = obj.getJjrAmt()==null?"":obj.getJjrAmt().toString();
            values[i][16] = obj.getHoleSize();
            values[i][17] = obj.getDoorSize();
            values[i][18] = obj.getDirection();
            values[i][19] = obj.getSurveyorPhotoName();
            values[i][20] = obj.getSurveyorDate()==null?"":sdf.format(obj.getSurveyorDate());
            values[i][21] = obj.getSurveyor();
            values[i][22] = obj.getSurveyorSmark();
            values[i][23] = obj.getInstallDate()==null?"":sdf.format(obj.getInstallDate());
            values[i][24] = obj.getInstallPerson();
            values[i][25] = obj.getInstallPerSmark();
            values[i][26] = obj.getIstallPhotoName();
            values[i][27] = obj.getYaKouSmark();
            values[i][28] = obj.getSmartCatEye();
            values[i][29] = obj.getSmartLockDate()==null?"":sdf.format(obj.getSmartLockDate());
            values[i][30] = obj.getSmartLockFileName();
            values[i][31] = obj.getFixSmarkOne();
            values[i][32] = obj.getFixSmarkTwo();
            values[i][33] = obj.getFixSmarkSan();
            values[i][34] = obj.getFixSmarkSi();
            values[i][35] = obj.getFixSmarkWu();
            values[i][36] = obj.getFixSmarkLiu();
            values[i][37] = obj.getFixSmarkQi();
            values[i][38] = obj.getFixSmarkBa();
            values[i][39] = obj.getFixSmarkJiu();
            values[i][40] = obj.getFixSmarkShi();
        }
        
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
        
        //将文件存到指定位置  
        try {  
             this.setResponseHeader(response, fileName);  
             OutputStream os = response.getOutputStream();  
             wb.write(os);  
             os.flush();  
             os.close();  
        } catch (Exception e) {  
             e.printStackTrace();  
        }  
        return "ok";
    }
    
    @RequestMapping(value = "/exportWlStore")
    @ResponseBody
    public String exportWlStore(HttpServletResponse response,
            @RequestParam(value="model", required=false) String model) throws UnsupportedEncodingException{
    	
        String fileName = "库存信息"+System.currentTimeMillis()+".xls"; //文件名 
        String sheetName = "库存信息";//sheet名
        
        String []title = new String[]{"型号","尺寸","外左","外右"};//标题
        
        WlStore wlStore = new WlStore();
        wlStore.setModel(model);
        logger.info("生成excel表格所需要的查询条件参数："+wlStore.toString());
        List<WlStore> list = storeHandleService.selectByConditions(wlStore);
        
        String [][]values = new String[list.size()][];
        for(int i=0;i<list.size();i++){
            values[i] = new String[title.length];
            //将对象内容转换成string
            WlStore obj = list.get(i);
            values[i][0] = obj.getModel();
            values[i][1] = obj.getSize();
            values[i][2] = String.valueOf(obj.getOutLeft());
            values[i][3] = String.valueOf(obj.getOutRight());
            
        }
        
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
        
        //将文件存到指定位置  
        try {  
             this.setResponseHeader(response, fileName);  
             OutputStream os = response.getOutputStream();  
             wb.write(os);  
             os.flush();  
             os.close();  
        } catch (Exception e) {  
             e.printStackTrace();  
        }  
        return "ok";
    }
    
     public void setResponseHeader(HttpServletResponse response, String fileName) {  
         try {  
              try {  
                   fileName = new String(fileName.getBytes(),"ISO8859-1");  
              } catch (UnsupportedEncodingException e) {  
                   // TODO Auto-generated catch block  
                   e.printStackTrace();  
              }  
              response.setContentType("application/octet-stream;charset=ISO8859-1");  
              response.setHeader("Content-Disposition", "attachment;filename="+ fileName);  
              response.addHeader("Pargam", "no-cache");  
              response.addHeader("Cache-Control", "no-cache");  
         } catch (Exception ex) {  
              ex.printStackTrace();  
         }  
    } 
}