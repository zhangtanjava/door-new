package com.gx.web;

import com.sun.istack.internal.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/Download")
public class DownLoad {
	
	Logger logger = Logger.getLogger(DownLoad.class);

	
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
											@RequestParam("filepath") String filepath)throws Exception{
		//下载文件路径
		String filepath1=new String(filepath.getBytes("ISO-8859-1"),"UTF-8");
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
