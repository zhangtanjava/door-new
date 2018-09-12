package com.gx.dao;

import com.gx.po.TransInfoPo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TransInfoDao {


	public TransInfoPo selectByname(TransInfoPo transInfoPo);

	public int selectByAgreementID(String agreementID);

	public TransInfoPo selectInfoByAgreementID(String agreementID);
	
	public int deleteById(Integer id);

	public int insertAll(TransInfoPo transInfoPo);


	public	TransInfoPo selectById(Integer id);


	public int updateById(TransInfoPo transInfoPo);

	//分页模糊查询
    public List<TransInfoPo> pageFuzzyselect(@Param("start") int start, @Param("pageSize") int pageSize,
                                             @Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
                                             @Param("agreementID") String agreementID,@Param("storeID") String storeID);

    //分页模糊查询总条数
    public int countFuzzyselect(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
                                @Param("agreementID") String agreementID,@Param("storeID") String storeID);
    
    
   //ajax 验证是否存在 此身份证号码
   public int selectYZ(String roleID);
    
    
    
    
    //查询所有数据  非本派所用
    public List<TransInfoPo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<TransInfoPo> selectAjaxList(String userName);


    public  TransInfoPo statisticsInfo(TransInfoPo vo);
}
