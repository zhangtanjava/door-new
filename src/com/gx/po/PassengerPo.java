package com.gx.po;

import java.util.Date;

public class PassengerPo {

	private Integer id;

	private String name;                   //姓名

	private String genderID;              //性别ID

	private String contactPhoneNumber;     //联系电话
	
	private String secondPhoneNumber;     //联系电话2

	private String unitsOrAddress;         //单位或住址
	
	private String remarks;                //备注

	private Date createTime;

	private Date updateTime;

	private String storeID;			//店铺

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
	public String getSecondPhoneNumber() {
		return secondPhoneNumber;
	}

	public void setSecondPhoneNumber(String secondPhoneNumber) {
		this.secondPhoneNumber = secondPhoneNumber;
	}

	@Override
	public String toString() {
		return "PassengerPo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", genderID='" + genderID + '\'' +
				", contactPhoneNumber='" + contactPhoneNumber + '\'' +
				", unitsOrAddress='" + unitsOrAddress + '\'' +
				", remarks='" + remarks + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
