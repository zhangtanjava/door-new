package com.gx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.ParametersInfoSepChild;

public interface ParametersInfoSepMapper {

    /**
     * 自动生成部分
     */
    int deleteByPrimaryKey(Integer id);//最终版

    int insert(ParametersInfoSepChild record);

    int insertSelective(ParametersInfoSepChild record);//最终版

    ParametersInfoSepChild selectByPrimaryKey(Integer id);//最终版

    int updateByPrimaryKeySelective(ParametersInfoSepChild record);//最终版

    int updateByPrimaryKey(ParametersInfoSepChild record);
    
    /**
     * 原来旧代码
     */
    public int selectByAgreementID(String agreementID);
	
	//分页模糊查询
    public List<ParametersInfoSepChild> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize,
                                             @Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
                                             @Param("unitsOrAddress") String unitsOrAddress,@Param("storeID") String storeID
                                             ,@Param("contactPhoneNumber") String contactPhoneNumber
                                             ,@Param("roleID") String roleID,@Param("installPerson") String installPerson);

    //分页模糊查询总条数
    public int countFuzzyselect(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
                                @Param("unitsOrAddress") String unitsOrAddress,@Param("storeID") String storeID
                                ,@Param("contactPhoneNumber") String contactPhoneNumber
                                ,@Param("roleID") String roleID,@Param("installPerson") String installPerson);
    
   //ajax 验证是否存在 此身份证号码
   public int selectYZ(String roleID);
    //查询所有数据  非本派所用
    public List<ParametersInfoSepChild> selectAll();
    //模糊查询 运用 Ajax 非分页
    public List<ParametersInfoSepChild> selectAjaxList(String userName);
    public  ParametersInfoSepChild statisticsInfo(ParametersInfoSepChild vo);
}