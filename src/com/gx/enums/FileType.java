package com.gx.enums;

public enum FileType {
	
	AGREEMENT_FILE("agreementFile"), 
	SURVEYOR_FILE("surveyorFile"),
	ISTALL_FILE("istallFile"),
	FRONTMONEY_FILE("frontMoneyFile"),
	SEAGREEMENT_FILE("seAgreementFile"),
	SMARTLOCL_FILE("smartLockFile");
	
	
	private String value;//状态值
	
	private FileType(String name){
		this.value = name;
	}

	public String getValue() {
		return value;
	}
	
}
