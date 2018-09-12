package com.gx.enums;

public enum TemplateName {
	
	WL_INSTALL("王力安装门表格.ftl"), 
	PP_INSTALL("盼盼安装门表格.ftl"),
	WL_SURVEY("王力测量表.ftl"),
	PP_SURVEY("盼盼测量表.ftl"),
	WL_FIX("王力安全门服务单.ftl"),
	PP_FIX("盼盼安全门服务单.ftl"),
	YAKOU("垭口安装单.ftl");
	
	
	private String name;//状态值
	
	private TemplateName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
