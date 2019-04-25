package com.gx.service.impl;

import com.gx.dao.ParametersInfoSepMapper;
import com.gx.page.Page;
import com.gx.po.ParametersInfoSepChild;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value="parametersHandleService")
public class ParametersHandleServiceImpl implements com.gx.service.ParametersHandleService {


	Logger logger = Logger.getLogger(ParametersHandleServiceImpl.class);
	@Autowired
	private ParametersInfoSepMapper parametersInfoSepMapper;

	@Override
	public int deleteById(Integer id) {
		return parametersInfoSepMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertAll(ParametersInfoSepChild parametersinfo) {
		return parametersInfoSepMapper.insertSelective(parametersinfo);
	}

	@Override
	public ParametersInfoSepChild selectById(Integer id) {
		return parametersInfoSepMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateById(ParametersInfoSepChild Parametersinfo) {
		return parametersInfoSepMapper.updateByPrimaryKeySelective(Parametersinfo);
	}

	@Override
	public Page<ParametersInfoSepChild> pageFuzzyselect(Page<ParametersInfoSepChild> vo,ParametersInfoSepChild parametersinfo) {
		logger.info("TranInfoServiceImpl pageFuzzyselect Parametersinfo:"+parametersinfo);
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<ParametersInfoSepChild> list=parametersInfoSepMapper.pageFuzzyselect(start, vo.getPageSize(),
				parametersinfo.getBeginDate(),parametersinfo.getEndDate(),parametersinfo.getUnitsOrAddress(),
				parametersinfo.getStoreID(),parametersinfo.getContactPhoneNumber(),parametersinfo.getRoleID()
				,parametersinfo.getInstallPerson());
		vo.setResult(list);
		int count=parametersInfoSepMapper.countFuzzyselect(parametersinfo.getBeginDate(),parametersinfo.getEndDate(),
				parametersinfo.getUnitsOrAddress(),parametersinfo.getStoreID(),parametersinfo.getContactPhoneNumber(),
				parametersinfo.getRoleID(),parametersinfo.getInstallPerson());
		vo.setTotal(count);
		return vo;
	}

	@Override
	public ParametersInfoSepChild statisticsInfo(ParametersInfoSepChild vo) {
		return parametersInfoSepMapper.statisticsInfo(vo);
	}
	
	@Override
	public List<ParametersInfoSepChild> selectAll() {
		return parametersInfoSepMapper.selectAll();
	}

	@Override
	public List<ParametersInfoSepChild> selectAjaxList(String name) {
		return parametersInfoSepMapper.selectAjaxList(name);
	}

	@Override
	public int selectByAgreementID(String agreementID) {
		return parametersInfoSepMapper.selectByAgreementID(agreementID);
	}

	@Override
	public ParametersInfoSepChild selectAllInfo(ParametersInfoSepChild vo) {
		return parametersInfoSepMapper.statisticsInfo(vo);
	}
	
}
