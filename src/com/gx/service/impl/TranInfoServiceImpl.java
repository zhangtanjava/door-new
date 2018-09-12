package com.gx.service.impl;

import com.gx.dao.TransInfoDao;
import com.gx.page.Page;
import com.gx.po.TransInfoPo;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value="tranInfoService")
public class TranInfoServiceImpl implements com.gx.service.TranInfoService {


	Logger logger = Logger.getLogger(TranInfoServiceImpl.class);
	@Autowired
	private TransInfoDao transInfoDao;

	@Override
	public int deleteById(Integer id) {
		return transInfoDao.deleteById(id);
	}

	@Override
	public int insertAll(TransInfoPo TransInfoPo) {

			return transInfoDao.insertAll(TransInfoPo);


	}

	@Override
	public TransInfoPo selectById(Integer id) {
		return transInfoDao.selectById(id);
	}

	@Override
	public int updateById(TransInfoPo TransInfoPo) {
		return transInfoDao.updateById(TransInfoPo);
	}

	@Override
	public Page<TransInfoPo> pageFuzzyselect(Page<TransInfoPo> vo,TransInfoPo transInfoPo) {
		logger.info("TranInfoServiceImpl pageFuzzyselect transInfoPo:"+transInfoPo);
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<TransInfoPo> list=transInfoDao.pageFuzzyselect(start, vo.getPageSize(),
				transInfoPo.getBeginDate(),transInfoPo.getEndDate(),transInfoPo.getAgreementID(),transInfoPo.getStoreID());
		vo.setResult(list);
		int count=transInfoDao.countFuzzyselect(transInfoPo.getBeginDate(),transInfoPo.getEndDate(),
				transInfoPo.getAgreementID(),transInfoPo.getStoreID());
		vo.setTotal(count);
		return vo;
	}


	@Override
	public List<TransInfoPo> selectAll() {
		return transInfoDao.selectAll();
	}

	@Override
	public List<TransInfoPo> selectAjaxList(String name) {
		return transInfoDao.selectAjaxList(name);
	}

	@Override
	public int selectByAgreementID(String agreementID) {
		return transInfoDao.selectByAgreementID(agreementID);
	}

	@Override
	public TransInfoPo statisticsInfo(TransInfoPo vo) {
		return transInfoDao.statisticsInfo(vo);
	}

	@Override
	public TransInfoPo selectInfoByAgreementID(String agreementID) {
		return transInfoDao.selectInfoByAgreementID(agreementID);
	}
}
