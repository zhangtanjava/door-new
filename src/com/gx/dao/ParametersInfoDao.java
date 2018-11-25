package com.gx.dao;

import com.gx.po.Parametersinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ParametersInfoDao {


	public int selectByAgreementID(String agreementID);

	public int deleteById(Integer id);

	public int insertAll(Parametersinfo Parametersinfo);


	public	Parametersinfo selectById(Integer id);


	public int updateById(Parametersinfo Parametersinfo);

	
	
	//分页模糊查询
    public List<Parametersinfo> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize,
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
    public List<Parametersinfo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<Parametersinfo> selectAjaxList(String userName);

    
    public  Parametersinfo statisticsInfo(Parametersinfo vo);
}
