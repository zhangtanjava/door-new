package com.gx.po;

import java.math.BigDecimal;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;

/**
 * @author MrZhang
 * @Description parametersInfo实体类
 */

public class ParametersInfoSepChild extends ParametersInfoSep {
	private static final long serialVersionUID = 1L;

	private String payDateStr; // 交居然日期;

	private String surveyorDateStr; // 测量日期

	private String installDateStr; // 安装日期

	private String smartLockDateStr; // 智能锁安装日期

	private Date beginDate; // 开始时间

	private Date endDate; // 结束时间

	private String createDateStr; // 创建日期/订货日期

	private Integer counts; // 总条数

	private BigDecimal sumMoney; // 总金额

	private BigDecimal sumDepositMoney; // 总定金额

	private String roleID;//角色
	
	public String getPayDateStr() {
		return payDateStr;
	}


	public void setPayDateStr(String payDateStr) {
		this.payDateStr = payDateStr;
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


	public String getSmartLockDateStr() {
		return smartLockDateStr;
	}


	public void setSmartLockDateStr(String smartLockDateStr) {
		this.smartLockDateStr = smartLockDateStr;
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


	public String getCreateDateStr() {
		return createDateStr;
	}


	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
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


	public BigDecimal getSumDepositMoney() {
		return sumDepositMoney;
	}


	public void setSumDepositMoney(BigDecimal sumDepositMoney) {
		this.sumDepositMoney = sumDepositMoney;
	}


	public String getRoleID() {
		return roleID;
	}


	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}


	@Override
	public String toString() {
		return super.toString() + "ParametersInfoSepChild [payDateStr=" + payDateStr + ", surveyorDateStr=" + surveyorDateStr
				+ ", installDateStr=" + installDateStr + ", smartLockDateStr=" + smartLockDateStr + ", beginDate="
				+ beginDate + ", endDate=" + endDate + ", createDateStr=" + createDateStr + ", counts=" + counts
				+ ", sumMoney=" + sumMoney + ", sumDepositMoney=" + sumDepositMoney + ", roleID=" + roleID + "]";
	}

}
