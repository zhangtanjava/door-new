package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.WlStoreMapper;
import com.gx.page.Page;
import com.gx.po.WlStore;
import com.gx.service.StoreHandleService;
import com.sun.istack.internal.logging.Logger;

@Transactional
@Service(value="storeHandleService")
public class StoreHandleServiceImpl implements StoreHandleService {
	Logger logger = Logger.getLogger(StoreHandleServiceImpl.class);
	@Autowired
	WlStoreMapper wlStoreMapper;
	
	@Override
	public int deleteById(Integer id) {
		return wlStoreMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertAll(WlStore wlStore) {
		return wlStoreMapper.insertSelective(wlStore);
	}

	@Override
	public WlStore selectById(Integer id) {
		return wlStoreMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateById(WlStore wlStore) {
		return wlStoreMapper.updateByPrimaryKeySelective(wlStore);
	}

	@Override
	public Page<WlStore> pageFuzzyselect(Page<WlStore> vo, WlStore wlStore) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<WlStore> list=wlStoreMapper.pageFuzzyselect(wlStore.getModel(), start, vo.getPageSize());
		vo.setResult(list);
		int count=wlStoreMapper.countFuzzyselect(wlStore);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<WlStore> selectAll() {
		return null;
	}

	@Override
	public List<WlStore> selectAjaxList(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WlStore selectByModelSize(String model, String size) {
		WlStore wlStore = new WlStore();
		wlStore.setModel(model);
		wlStore.setSize(size);
		return wlStoreMapper.selectByModelSize(wlStore);
	}

	@Override
	public int batchUpOrInStoreInfo(List<WlStore> list) {
		return wlStoreMapper.batchUpOrInStoreInfo(list);
	}

	@Override
	public List<WlStore> selectByConditions(WlStore wlStore) {
		return wlStoreMapper.selectByConditions(wlStore);
	}

}
