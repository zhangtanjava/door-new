package com.gx.utils;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义异常处理器类
 */
public class ExceptionHandler implements HandlerExceptionResolver{
    Logger logger = Logger.getLogger(ExceptionHandler.class);
    /**
     * 处理上传文件大小超过限制抛出的异常
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest req,
                                         HttpServletResponse res, Object ob, Exception ex) {
        ModelAndView mv=new ModelAndView();
        logger.info("上传文件过大。。。");
        //判断异常类型，来跳转不同页面
        if (ex instanceof MaxUploadSizeExceededException){
            //指定错误信息
            mv.addObject("errormessage", "上传文件过大");
            //设置跳转视图
            mv.setViewName("error");
            return mv;
        }
        //其他异常
        return null;
    }
}

