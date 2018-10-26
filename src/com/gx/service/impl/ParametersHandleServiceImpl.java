package com.gx.service.impl;

import com.gx.dao.ParametersInfoDao;
import com.gx.page.Page;
import com.gx.po.Parametersinfo;
import com.gx.po.PassengerPo;
import com.gx.po.TransInfoPo;
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
	private ParametersInfoDao parametersInfoDao;

	@Override
	public int deleteById(Integer id) {
		return parametersInfoDao.deleteById(id);
	}

	@Override
	public int insertAll(Parametersinfo parametersinfo) {

			return parametersInfoDao.insertAll(parametersinfo);


	}

	@Override
	public Parametersinfo selectById(Integer id) {
		return parametersInfoDao.selectById(id);
	}

	@Override
	public int updateById(Parametersinfo Parametersinfo) {
		return parametersInfoDao.updateById(Parametersinfo);
	}

	@Override
	public Page<Parametersinfo> pageFuzzyselect(Page<Parametersinfo> vo,Parametersinfo parametersinfo) {
		logger.info("TranInfoServiceImpl pageFuzzyselect Parametersinfo:"+parametersinfo);
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<Parametersinfo> list=parametersInfoDao.pageFuzzyselect(start, vo.getPageSize(),
				parametersinfo.getBeginDate(),parametersinfo.getEndDate(),parametersinfo.getUnitsOrAddress(),
				parametersinfo.getStoreID(),parametersinfo.getContactPhoneNumber(),parametersinfo.getRoleID());
		vo.setResult(list);
		int count=parametersInfoDao.countFuzzyselect(parametersinfo.getBeginDate(),parametersinfo.getEndDate(),
				parametersinfo.getUnitsOrAddress(),parametersinfo.getStoreID(),parametersinfo.getContactPhoneNumber(),
				parametersinfo.getRoleID());
		vo.setTotal(count);
		return vo;
	}

	@Override
	public Parametersinfo statisticsInfo(Parametersinfo vo) {
		return parametersInfoDao.statisticsInfo(vo);
	}
	
	@Override
	public List<Parametersinfo> selectAll() {
		return parametersInfoDao.selectAll();
	}

	@Override
	public List<Parametersinfo> selectAjaxList(String name) {
		return parametersInfoDao.selectAjaxList(name);
	}

	@Override
	public int selectByAgreementID(String agreementID) {
		return parametersInfoDao.selectByAgreementID(agreementID);
	}

	@Override
	public Parametersinfo selectAllInfo(Parametersinfo vo) {
		return parametersInfoDao.statisticsInfo(vo);
	}
	
}
