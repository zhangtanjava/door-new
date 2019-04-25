package com.gx.web;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gx.enums.TemplateName;
import com.gx.po.ParametersInfoSepChild;
import com.gx.service.ParametersHandleService;
import com.gx.utils.Convert2map;
import com.gx.utils.PropertyPlaceholder;
import com.gx.utils.WordProduceUtils;

@Controller
@RequestMapping("/ParametersHandle")
public class WordProduce {
	
	@Autowired
	private ParametersHandleService parametersHandleService;
	@Autowired
	Convert2map convert2map;
	
	Logger logger = Logger.getLogger(ParametersHandle.class);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//private String filePath = "/Users/zhangtan/Desktop/";
	private String filePath = (String) PropertyPlaceholder.getProperty("wordSavePath");
	
	    @RequestMapping(value="/wlInstallWord")
		public ResponseEntity<byte[]> wlInstallWord(HttpServletRequest request,
												@RequestParam("id") Integer id)throws Exception{
			String wordFileName ="wl_azb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
			WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
			logger.info("表格生成初始化...");
			freemark.setTemplateName(TemplateName.WL_INSTALL.getName());
			freemark.setFileName(wordFileName);
			freemark.setFilePath(filePath);
			logger.info("表格生成路径:"+filePath);
			Map<String, Object> map = new HashMap<String, Object>();
			map = convert2map.wlInstall(map,id);//组装map参数
			freemark.createWord(map);//创建生成word文档
			logger.info("表格生成完成");
			//生成文件总路径
			String fullFilePath = filePath+wordFileName;
			//下载文件
			String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
			File file = new File(filepath1);
			HttpHeaders headers = new HttpHeaders();
			String [] fileElements = filepath1.split(File.separator);
			String fileName = fileElements[fileElements.length-1];
			logger.info("文件路径："+filepath1+",文件名："+fileName);
			//下载显示的文件名，解决中文名称乱码问题
			String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
			logger.info("转码后文件名："+downloadFielName);
			//通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("attachment", downloadFielName);
			//application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
					headers, HttpStatus.CREATED);
		}
	
		@RequestMapping(value="/ppInstallWord")
		public ResponseEntity<byte[]> download(HttpServletRequest request,
												@RequestParam("id") Integer id)throws Exception{
			String wordFileName ="pp_azb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
			WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
			logger.info("表格生成初始化...");
			freemark.setTemplateName(TemplateName.PP_INSTALL.getName());
			freemark.setFileName(wordFileName);
			freemark.setFilePath(filePath);
			Map<String, Object> map = new HashMap<String, Object>();
			map = convert2map.wlInstall(map,id);//组装map参数
			freemark.createWord(map);//创建生成word文档
			logger.info("表格生成完成");
			//生成文件总路径
			String fullFilePath = filePath+wordFileName;
			//下载文件
			String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
			File file = new File(filepath1);
			HttpHeaders headers = new HttpHeaders();
			String [] fileElements = filepath1.split(File.separator);
			String fileName = fileElements[fileElements.length-1];
			logger.info("文件路径："+filepath1+",文件名："+fileName);
			//下载显示的文件名，解决中文名称乱码问题
			String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
			logger.info("转码后文件名："+downloadFielName);
			//通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("attachment", downloadFielName);
			//application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
					headers, HttpStatus.CREATED);
		}
		 @RequestMapping(value="/wlSurveyWord")
			public ResponseEntity<byte[]> wlSurveyWord(HttpServletRequest request,
													@RequestParam("id") Integer id)throws Exception{
				String wordFileName ="wl_clb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
				WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
				logger.info("表格生成初始化...");
				freemark.setTemplateName(TemplateName.WL_SURVEY.getName());
				freemark.setFileName(wordFileName);
				freemark.setFilePath(filePath);
				Map<String, Object> map = new HashMap<String, Object>();
				map = convert2map.wlSurveyWord(map,id);//组装map参数
				freemark.createWord(map);//创建生成word文档
				logger.info("表格生成完成");
				//生成文件总路径
				String fullFilePath = filePath+wordFileName;
				//下载文件
				String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(filepath1);
				HttpHeaders headers = new HttpHeaders();
				String [] fileElements = filepath1.split(File.separator);
				String fileName = fileElements[fileElements.length-1];
				logger.info("文件路径："+filepath1+",文件名："+fileName);
				//下载显示的文件名，解决中文名称乱码问题
				String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
				logger.info("转码后文件名："+downloadFielName);
				//通知浏览器以attachment（下载方式）打开图片
				headers.setContentDispositionFormData("attachment", downloadFielName);
				//application/octet-stream ： 二进制流数据（最常见的文件下载）。
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
						headers, HttpStatus.CREATED);
			}
			@RequestMapping(value="/ppSurveyWord")
			public ResponseEntity<byte[]> ppSurveyWord(HttpServletRequest request,
													@RequestParam("id") Integer id)throws Exception{
				String wordFileName ="pp_clb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
				WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
				logger.info("表格生成初始化...");
				freemark.setTemplateName(TemplateName.PP_SURVEY.getName());
				freemark.setFileName(wordFileName);
				freemark.setFilePath(filePath);
				Map<String, Object> map = new HashMap<String, Object>();
				map = convert2map.wlSurveyWord(map,id);//组装map参数
				freemark.createWord(map);//创建生成word文档
				logger.info("表格生成完成");
				//生成文件总路径
				String fullFilePath = filePath+wordFileName;
				//下载文件
				String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(filepath1);
				HttpHeaders headers = new HttpHeaders();
				String [] fileElements = filepath1.split(File.separator);
				String fileName = fileElements[fileElements.length-1];
				logger.info("文件路径："+filepath1+",文件名："+fileName);
				//下载显示的文件名，解决中文名称乱码问题
				String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
				logger.info("转码后文件名："+downloadFielName);
				//通知浏览器以attachment（下载方式）打开图片
				headers.setContentDispositionFormData("attachment", downloadFielName);
				//application/octet-stream ： 二进制流数据（最常见的文件下载）。
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
						headers, HttpStatus.CREATED);
			}
			
			@RequestMapping(value="/wlFixWord")
			public ResponseEntity<byte[]> wlFixWord(HttpServletRequest request,
													@RequestParam("id") Integer id)throws Exception{
				String wordFileName ="wl_fwb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
				WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
				logger.info("表格生成初始化...");
				freemark.setTemplateName(TemplateName.WL_FIX.getName());
				freemark.setFileName(wordFileName);
				freemark.setFilePath(filePath);
				Map<String, Object> map = new HashMap<String, Object>();
				map = convert2map.wlFixWord(map,id);//组装map参数
				freemark.createWord(map);//创建生成word文档
				logger.info("表格生成完成");
				//生成文件总路径
				String fullFilePath = filePath+wordFileName;
				//下载文件
				String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(filepath1);
				HttpHeaders headers = new HttpHeaders();
				String [] fileElements = filepath1.split(File.separator);
				String fileName = fileElements[fileElements.length-1];
				logger.info("文件路径："+filepath1+",文件名："+fileName);
				//下载显示的文件名，解决中文名称乱码问题
				String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
				logger.info("转码后文件名："+downloadFielName);
				//通知浏览器以attachment（下载方式）打开图片
				headers.setContentDispositionFormData("attachment", downloadFielName);
				//application/octet-stream ： 二进制流数据（最常见的文件下载）。
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
						headers, HttpStatus.CREATED);
			}
			@RequestMapping(value="/ppFixWord")
			public ResponseEntity<byte[]> ppFixWord(HttpServletRequest request,
													@RequestParam("id") Integer id)throws Exception{
				String wordFileName ="pp_fwb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
				WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
				logger.info("表格生成初始化...");
				freemark.setTemplateName(TemplateName.PP_FIX.getName());
				freemark.setFileName(wordFileName);
				freemark.setFilePath(filePath);
				Map<String, Object> map = new HashMap<String, Object>();
				map = convert2map.wlFixWord(map,id);//组装map参数
				freemark.createWord(map);//创建生成word文档
				logger.info("表格生成完成");
				//生成文件总路径
				String fullFilePath = filePath+wordFileName;
				//下载文件
				String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(filepath1);
				HttpHeaders headers = new HttpHeaders();
				String [] fileElements = filepath1.split(File.separator);
				String fileName = fileElements[fileElements.length-1];
				logger.info("文件路径："+filepath1+",文件名："+fileName);
				//下载显示的文件名，解决中文名称乱码问题
				String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
				logger.info("转码后文件名："+downloadFielName);
				//通知浏览器以attachment（下载方式）打开图片
				headers.setContentDispositionFormData("attachment", downloadFielName);
				//application/octet-stream ： 二进制流数据（最常见的文件下载）。
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
						headers, HttpStatus.CREATED);
			}
			@RequestMapping(value="/yaKouWord")
			public ResponseEntity<byte[]> yaKouWord(HttpServletRequest request,
													@RequestParam("id") Integer id)throws Exception{
				String wordFileName ="ykb_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".doc";//文件名
				WordProduceUtils freemark = new WordProduceUtils("/ftl/");//ftl模板文件存放路径
				logger.info("表格生成初始化...");
				freemark.setTemplateName(TemplateName.YAKOU.getName());
				freemark.setFileName(wordFileName);
				freemark.setFilePath(filePath);
				Map<String, Object> map = new HashMap<String, Object>();
				map = convert2map.yaKouWord(map,id);//组装map参数
				freemark.createWord(map);//创建生成word文档
				logger.info("表格生成完成");
				//生成文件总路径
				String fullFilePath = filePath+wordFileName;
				//下载文件
				String filepath1=new String(fullFilePath.getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(filepath1);
				HttpHeaders headers = new HttpHeaders();
				String [] fileElements = filepath1.split(File.separator);
				String fileName = fileElements[fileElements.length-1];
				logger.info("文件路径："+filepath1+",文件名："+fileName);
				//下载显示的文件名，解决中文名称乱码问题
				String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
				logger.info("转码后文件名："+downloadFielName);
				//通知浏览器以attachment（下载方式）打开图片
				headers.setContentDispositionFormData("attachment", downloadFielName);
				//application/octet-stream ： 二进制流数据（最常见的文件下载）。
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
						headers, HttpStatus.CREATED);
			}
			
}
