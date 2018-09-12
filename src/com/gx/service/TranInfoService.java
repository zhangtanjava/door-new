package com.gx.service;

import com.gx.page.Page;
import com.gx.po.TransInfoPo;
import java.util.List;

public interface TranInfoService {


	public int deleteById(Integer id);


	public int insertAll(TransInfoPo TransInfoPo);


	public	TransInfoPo selectById(Integer id);


	public int updateById(TransInfoPo TransInfoPo);


	//分页需要
	public Page<TransInfoPo> pageFuzzyselect(Page<TransInfoPo> vo,TransInfoPo transInfoPo);

	//查询所有数据  非本派所用
	public List<TransInfoPo> selectAll();

	//模糊查询 运用 Ajax 非分页
	public List<TransInfoPo> selectAjaxList(String name);

	//通过合同号查询
	public int selectByAgreementID(String agreementID);

	//通过合同号查询信息
	public TransInfoPo selectInfoByAgreementID(String agreementID);
		
	public  TransInfoPo statisticsInfo(TransInfoPo vo);

}
