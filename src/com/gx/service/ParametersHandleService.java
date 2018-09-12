package com.gx.service;

import com.gx.page.Page;
import com.gx.po.Parametersinfo;
import com.gx.po.Parametersinfo;

import java.util.List;

public interface ParametersHandleService {


	public int deleteById(Integer id);


	public int insertAll(Parametersinfo Parametersinfo);


	public	Parametersinfo selectById(Integer id);


	public int updateById(Parametersinfo Parametersinfo);


	//分页需要
	public Page<Parametersinfo> pageFuzzyselect(Page<Parametersinfo> vo, Parametersinfo parametersinfo);
	
	public Parametersinfo statisticsInfo(Parametersinfo vo);

	//查询所有数据  非本派所用
	public List<Parametersinfo> selectAll();

	//模糊查询 运用 Ajax 非分页
	public List<Parametersinfo> selectAjaxList(String name);

	//通过合同号查询
	public int selectByAgreementID(String agreementID);

	public  Parametersinfo selectAllInfo(Parametersinfo vo);
	
}
