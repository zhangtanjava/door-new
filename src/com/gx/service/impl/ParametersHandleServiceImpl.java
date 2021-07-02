package com.gx.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.ParametersInfoSepMapper;
import com.gx.dao.WlStoreMapper;
import com.gx.page.Page;
import com.gx.po.ParametersInfoSepChild;
import com.gx.po.WlStore;
import com.sun.istack.internal.logging.Logger;

@Transactional
@Service(value="parametersHandleService")
public class ParametersHandleServiceImpl implements com.gx.service.ParametersHandleService {

	Logger logger = Logger.getLogger(ParametersHandleServiceImpl.class);
	@Autowired
	private ParametersInfoSepMapper parametersInfoSepMapper;
	@Autowired
	private WlStoreMapper wlStoreMapper;
	
	@Override
	@Transactional
	public int deleteById(Integer id) {
		ParametersInfoSepChild pld = parametersInfoSepMapper.selectByPrimaryKey(id);
		int n;
		if (pld!=null) {
			WlStore wlStore = new WlStore();
			wlStore.setModel(pld.getModel());
			wlStore.setSize(pld.getDoorSize());
			WlStore res = wlStoreMapper.selectByModelSize(wlStore);
			if (res!=null) {
				wlStore.setId(res.getId());
				if (pld.getDirection().contains("左")) {
					wlStore.setOutLeft(1);
				}else if (pld.getDirection().contains("右")) {
					wlStore.setOutRight(1);
				}
				 n = wlStoreMapper.updateLeftAndRight(wlStore);
			}
		}
		int m = parametersInfoSepMapper.deleteByPrimaryKey(id);
		return m;
	}
	/**
	 * 增加一条，库存对应的信息就减少一条
	 * */
	@Override
	@Transactional
	public int insertAll(ParametersInfoSepChild parametersinfo) {
		int n = parametersInfoSepMapper.insertSelective(parametersinfo);
		// 去掉库存逻辑
//		WlStore wlStore = new WlStore();
//		wlStore.setModel(parametersinfo.getModel());
//		wlStore.setSize(parametersinfo.getDoorSize());
//		List<WlStore> list = wlStoreMapper.selectByConditions(wlStore);
//		logger.info("查出的List<WlStore>数量："+list.size());
//		if (list!=null && list.size()==1) {
//			WlStore upStore = new WlStore();
//			upStore.setId(list.get(0).getId());
//			if (!StringUtils.isEmpty(parametersinfo.getDirection())) {
//				if (parametersinfo.getDirection().contains("左")) {
//					upStore.setOutLeft(-1);
//				}else if(parametersinfo.getDirection().contains("右")){
//					upStore.setOutRight(-1);
//				}
//				wlStoreMapper.updateLeftAndRight(upStore);
//			}
//		}
		return n;
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

	@Override
	public List<ParametersInfoSepChild> selectByConditions(ParametersInfoSepChild Parametersinfo) {
		return parametersInfoSepMapper.selectByConditions(Parametersinfo);
	}

	@Override
	public int updateStoreID(String oldStoreID, String newStoreID) {
		return parametersInfoSepMapper.updateStoreID(oldStoreID,newStoreID);
	}
	
}
