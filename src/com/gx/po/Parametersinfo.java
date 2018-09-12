package com.gx.po;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
*@author MrZhang
*@Description parametersInfo实体类
*/

public class Parametersinfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String holeSize;//洞口尺寸

	private String doorSize;//门尺寸

	private String direction;//开口方向
	
	private String cutInfo;//割边情况

	private String indoorInfo;//室内情况

	private String surveyor;//测量师

	private String surveyorSmark;//测量师备注

	private Date surveyorDate;//测量日期

	private String woodcase;//木套尺寸

	private String moundlayer;//压条尺寸

	private String installPerson;//安装人员

	private String installPerSmark;//安装备注

	private Date installDate;//安装日期

	private String surveyorPhotoPath;//测量照片

	private String surveyorPhotoName;//测量照片文件名

	private String surveyorPhotoDes;//测量照片描述

	private String istallPhotoPath;//安装照片

	private String istallPhotoName;//测量照片文件名

	private String istallPhotoDes;//安装照片描述
	
	private String agreementPhotoPath;//合同照片

	private String agreementPhotoName;//合同照片文件名

	private String agreementPhotoDes;//合同照片描述

	private String otherSmark;//其它备注

	private String agreementID; //合同id

	private Date beginDate;                    //开始时间

	private Date endDate;                    //结束时间

	private String surveyorDateStr;                //测量日期

	private String installDateStr;           //安装日期

	private String operatorID;           //操作员ID

	private String storeID;            //店

	private String roleID;                //角色id

	private  String merName; //商户名

	private Date createDate; //	创建日期/订货日期

	private String createDateStr; //	创建日期/订货日期

	private Date updateDate;//更新日期
	
	private Date fixDate;//服务日期
	
	private String fixDateStr;//服务日期
	
	private String fixObject;//服务项目
	
	private String fixSmarkOne;//维修备注1
	
	private String fixSmarkTwo;//微信备注2

	private Date yaKouInstallDate;//垭口安装日期
	
	private String yaKouInstallDateStr;//垭口安装日期
	
	private String colorRequire;//颜色要求
	
	private String doorBottomInfo;//门底槛要求
	
	private String yaKouSmark;//垭口安装备注
	
	private String genderID;              //性别ID

	private String contactPhoneNumber;     //联系电话
	
	private String secondPhoneNumber;     //联系电话2

	private String unitsOrAddress;         //单位或住址
	
	private String remarks;                //备注


	    private String paymentID;             //交款凭证ID

	    private String model;                    //型号

	    private BigDecimal price;                  //价钱

	    private BigDecimal deposit;                //定金
	    
	    private String dateMoney;		//日期金额  

	    private Date playDate;                //下单日期

	    private Date payDate;           //交款日期

	    private String playDateStr;                //下单日期

	    private String payDateStr;           //交款日期

	    private String smartLock;            //智能锁

	    private String smartCatEye;                  //智能猫眼

	    private Integer counts;                 //总条数

	    private BigDecimal sumMoney;               //总金额	
	    
	    private BigDecimal sumDepositMoney;      //总定金额
	
	
	public BigDecimal getSumDepositMoney() {
			return sumDepositMoney;
		}

		public void setSumDepositMoney(BigDecimal sumDepositMoney) {
			this.sumDepositMoney = sumDepositMoney;
		}

	public Date getYaKouInstallDate() {
		return yaKouInstallDate;
	}

	public void setYaKouInstallDate(Date yaKouInstallDate) {
		this.yaKouInstallDate = yaKouInstallDate;
	}

	public String getYaKouInstallDateStr() {
		return yaKouInstallDateStr;
	}

	public void setYaKouInstallDateStr(String yaKouInstallDateStr) {
		this.yaKouInstallDateStr = yaKouInstallDateStr;
	}

	public String getColorRequire() {
		return colorRequire;
	}

	public void setColorRequire(String colorRequire) {
		this.colorRequire = colorRequire;
	}

	public String getDoorBottomInfo() {
		return doorBottomInfo;
	}

	public void setDoorBottomInfo(String doorBottomInfo) {
		this.doorBottomInfo = doorBottomInfo;
	}

	public String getYaKouSmark() {
		return yaKouSmark;
	}

	public void setYaKouSmark(String yaKouSmark) {
		this.yaKouSmark = yaKouSmark;
	}

	public String getFixDateStr() {
		return fixDateStr;
	}

	public void setFixDateStr(String fixDateStr) {
		this.fixDateStr = fixDateStr;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getSurveyorPhotoDes() {
		return surveyorPhotoDes;
	}

	public void setSurveyorPhotoDes(String surveyorPhotoDes) {
		this.surveyorPhotoDes = surveyorPhotoDes;
	}

	public String getIstallPhotoDes() {
		return istallPhotoDes;
	}

	public void setIstallPhotoDes(String istallPhotoDes) {
		this.istallPhotoDes = istallPhotoDes;
	}

	public String getSurveyorDateStr() {
		return surveyorDateStr;
	}

	public void setSurveyorDateStr(String surveyorDateStr) {
		this.surveyorDateStr = surveyorDateStr;
	}

	public String getInstallDateStr() {
		return installDateStr;
	}

	public void setInstallDateStr(String installDateStr) {
		this.installDateStr = installDateStr;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoleSize() {
		return holeSize;
	}

	public void setHoleSize(String holeSize) {
		this.holeSize = holeSize;
	}

	public String getDoorSize() {
		return doorSize;
	}

	public void setDoorSize(String doorSize) {
		this.doorSize = doorSize;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getIndoorInfo() {
		return indoorInfo;
	}

	public void setIndoorInfo(String indoorInfo) {
		this.indoorInfo = indoorInfo;
	}

	public String getSurveyor() {
		return surveyor;
	}

	public void setSurveyor(String surveyor) {
		this.surveyor = surveyor;
	}

	public String getSurveyorSmark() {
		return surveyorSmark;
	}

	public void setSurveyorSmark(String surveyorSmark) {
		this.surveyorSmark = surveyorSmark;
	}

	public Date getSurveyorDate() {
		return surveyorDate;
	}

	public void setSurveyorDate(Date surveyorDate) {
		this.surveyorDate = surveyorDate;
	}

	public String getWoodcase() {
		return woodcase;
	}

	public void setWoodcase(String woodcase) {
		this.woodcase = woodcase;
	}

	public String getMoundlayer() {
		return moundlayer;
	}

	public void setMoundlayer(String moundlayer) {
		this.moundlayer = moundlayer;
	}

	public String getInstallPerson() {
		return installPerson;
	}

	public void setInstallPerson(String installPerson) {
		this.installPerson = installPerson;
	}

	public String getInstallPerSmark() {
		return installPerSmark;
	}

	public void setInstallPerSmark(String installPerSmark) {
		this.installPerSmark = installPerSmark;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public String getSurveyorPhotoPath() {
		return surveyorPhotoPath;
	}

	public void setSurveyorPhotoPath(String surveyorPhotoPath) {
		this.surveyorPhotoPath = surveyorPhotoPath;
	}

	public String getIstallPhotoPath() {
		return istallPhotoPath;
	}

	public void setIstallPhotoPath(String istallPhotoPath) {
		this.istallPhotoPath = istallPhotoPath;
	}

	public String getOtherSmark() {
		return otherSmark;
	}

	public void setOtherSmark(String otherSmark) {
		this.otherSmark = otherSmark;
	}

	public String getAgreementID() {
		return agreementID;
	}

	public void setAgreementID(String agreementID) {
		this.agreementID = agreementID;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}
	
	public String getCutInfo() {
		return cutInfo;
	}

	public void setCutInfo(String cutInfo) {
		this.cutInfo = cutInfo;
	}
	public String getSurveyorPhotoName() {
		return surveyorPhotoName;
	}

	public void setSurveyorPhotoName(String surveyorPhotoName) {
		this.surveyorPhotoName = surveyorPhotoName;
	}

	public String getIstallPhotoName() {
		return istallPhotoName;
	}

	public void setIstallPhotoName(String istallPhotoName) {
		this.istallPhotoName = istallPhotoName;
	}

	public Date getFixDate() {
		return fixDate;
	}

	public void setFixDate(Date fixDate) {
		this.fixDate = fixDate;
	}

	public String getFixObject() {
		return fixObject;
	}

	public void setFixObject(String fixObject) {
		this.fixObject = fixObject;
	}

	public String getFixSmarkOne() {
		return fixSmarkOne;
	}

	public void setFixSmarkOne(String fixSmarkOne) {
		this.fixSmarkOne = fixSmarkOne;
	}

	public String getFixSmarkTwo() {
		return fixSmarkTwo;
	}

	public void setFixSmarkTwo(String fixSmarkTwo) {
		this.fixSmarkTwo = fixSmarkTwo;
	}

	public String getGenderID() {
		return genderID;
	}

	public void setGenderID(String genderID) {
		this.genderID = genderID;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getSecondPhoneNumber() {
		return secondPhoneNumber;
	}

	public void setSecondPhoneNumber(String secondPhoneNumber) {
		this.secondPhoneNumber = secondPhoneNumber;
	}

	public String getUnitsOrAddress() {
		return unitsOrAddress;
	}

	public void setUnitsOrAddress(String unitsOrAddress) {
		this.unitsOrAddress = unitsOrAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getDateMoney() {
		return dateMoney;
	}

	public void setDateMoney(String dateMoney) {
		this.dateMoney = dateMoney;
	}

	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getPlayDateStr() {
		return playDateStr;
	}

	public void setPlayDateStr(String playDateStr) {
		this.playDateStr = playDateStr;
	}

	public String getPayDateStr() {
		return payDateStr;
	}

	public void setPayDateStr(String payDateStr) {
		this.payDateStr = payDateStr;
	}

	public String getSmartLock() {
		return smartLock;
	}

	public void setSmartLock(String smartLock) {
		this.smartLock = smartLock;
	}

	public String getSmartCatEye() {
		return smartCatEye;
	}

	public void setSmartCatEye(String smartCatEye) {
		this.smartCatEye = smartCatEye;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getAgreementPhotoPath() {
		return agreementPhotoPath;
	}

	public void setAgreementPhotoPath(String agreementPhotoPath) {
		this.agreementPhotoPath = agreementPhotoPath;
	}

	public String getAgreementPhotoName() {
		return agreementPhotoName;
	}

	public void setAgreementPhotoName(String agreementPhotoName) {
		this.agreementPhotoName = agreementPhotoName;
	}

	public String getAgreementPhotoDes() {
		return agreementPhotoDes;
	}

	public void setAgreementPhotoDes(String agreementPhotoDes) {
		this.agreementPhotoDes = agreementPhotoDes;
	}
	
}

