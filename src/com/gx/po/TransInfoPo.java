package com.gx.po;

import java.math.BigDecimal;
import java.util.Date;

public class TransInfoPo {

    private Integer id;

    private String agreementID;            //合同ID

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

    private String remarks;                    //备注

    private Date createDate;                //创建时间

    private Date updateDate;           //更新时间

    private String operatorID;           //操作员ID

    private String storeID;            //店

    private String roleID;                //角色id

    private String merName;                //客户

    private Date beginDate;                    //开始时间

    private Date endDate;                    //结束时间

    private Integer counts;                 //总条数

    private BigDecimal sumMoney;               //总金额

    
    public String getDateMoney() {
		return dateMoney;
	}

	public void setDateMoney(String dateMoney) {
		this.dateMoney = dateMoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAgreementID() {
        return agreementID;
    }

    public void setAgreementID(String agreementID) {
        this.agreementID = agreementID;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
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

    @Override
    public String toString() {
        return "TransInfoPo{" +
                "id=" + id +
                ", agreementID='" + agreementID + '\'' +
                ", paymentID='" + paymentID + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", deposit=" + deposit +
                ", playDate=" + playDate +
                ", payDate=" + payDate +
                ", playDateStr=" + playDateStr +
                ", payDateStr=" + payDateStr +
                ", smartLock='" + smartLock + '\'' +
                ", smartCatEye='" + smartCatEye + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", operatorID='" + operatorID + '\'' +
                ", storeID='" + storeID + '\'' +
                ", roleID='" + roleID + '\'' +
                ", merName='" + merName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", counts=" + counts +
                ", sumMoney=" + sumMoney +
                '}';
    }
}
