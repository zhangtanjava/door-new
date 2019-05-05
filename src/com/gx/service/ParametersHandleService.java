package com.gx.service;

import com.gx.page.Page;
import com.gx.po.ParametersInfoSepChild;
import com.gx.po.ParametersInfoSepChild;

import java.util.List;

public interface ParametersHandleService {


	public int deleteById(Integer id);


	public int insertAll(ParametersInfoSepChild Parametersinfo);


	public	ParametersInfoSepChild selectById(Integer id);


	public int updateById(ParametersInfoSepChild Parametersinfo);
	
	public int updateStoreID(String oldStoreID, String newStoreID);

	public List<ParametersInfoSepChild>  selectByConditions(ParametersInfoSepChild Parametersinfo);
	//分页需要
	public Page<ParametersInfoSepChild> pageFuzzyselect(Page<ParametersInfoSepChild> vo, ParametersInfoSepChild parametersinfo);
	
	public ParametersInfoSepChild statisticsInfo(ParametersInfoSepChild vo);

	//查询所有数据  非本派所用
	public List<ParametersInfoSepChild> selectAll();

	//模糊查询 运用 Ajax 非分页
	public List<ParametersInfoSepChild> selectAjaxList(String name);

	//通过合同号查询
	public int selectByAgreementID(String agreementID);

	public  ParametersInfoSepChild selectAllInfo(ParametersInfoSepChild vo);
	
}
