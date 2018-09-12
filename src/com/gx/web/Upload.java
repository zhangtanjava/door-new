package com.gx.web;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/Upload")
public class Upload {
	
	Logger logger = Logger.getLogger(Upload.class);

	
	@RequestMapping(value="/uploadsurveyor",method=RequestMethod.POST)
	public String uploadsurveyor(HttpServletRequest request,
									   @RequestParam("surveyorPhoto") String surveyorPhoto,
									   @RequestParam("surveyorFile") MultipartFile surveyorFile){
		System.out.println(surveyorPhoto);
		//如果文件不为空，写入上传路径
		if(!surveyorFile.isEmpty()) {
			//上传文件路径
			String path = request.getServletContext().getRealPath("/images/");
			logger.info("上传文件路径："+path);
			//上传文件名
			String filename = surveyorFile.getOriginalFilename();
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
			return "success";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/uploadinstall")
	public String uploadinstall(){
		return null;
	}

}
