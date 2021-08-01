package com.gx.service.impl;

import java.util.Date;
import java.util.List;

import com.gx.web.Passenger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.PassengerDao;
import com.gx.page.Page;
import com.gx.po.PassengerPo;
import com.gx.service.PassengerService;

@Transactional
@Service(value="passengerService")
public class PassengerServiceImpl implements PassengerService {

	Logger logger = Logger.getLogger(PassengerServiceImpl.class);

	@Autowired
	private PassengerDao passengerDao;
	
	@Override
	public int deleteById(Integer id) {
		return passengerDao.deleteById(id);
	}

	@Override
	public int insertAll(PassengerPo passengerPo) {
		System.out.println("----------");
		passengerPo.setCreateTime(new Date());
		passengerPo.setUpdateTime(new Date());
		logger.info("PassengerServiceImpl insertAll req"+passengerPo);
		return passengerDao.insertAll(passengerPo);
	}

	@Override
	public PassengerPo selectById(Integer id) {
		return passengerDao.selectById(id);
	}

	@Override
	public int updateById(PassengerPo passengerPo) {

		passengerPo.setUpdateTime(new Date());
		return passengerDao.updateById(passengerPo);
	}

	@Override
	public Page<PassengerPo> pageFuzzyselect(String storeID,String name, Page<PassengerPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<PassengerPo> list=passengerDao.pageFuzzyselect(storeID,name, start, vo.getPageSize());
		vo.setResult(list);
		int count=passengerDao.countFuzzyselect(storeID,name);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<PassengerPo> selectAll() {
		return passengerDao.selectAll();
	}

	@Override
	public List<PassengerPo> selectAjaxList(String name) {
		return passengerDao.selectAjaxList(name);
	}

	@Override
	public int selectYZ(String papersNumber) {
		return this.passengerDao.selectYZ(papersNumber);
	}

	@Override
	public int selectByUserName(String userName) {
		return  passengerDao.selectByUserName(userName);
	}

	@Override
	public PassengerPo selectInfoByUserName(String userName) {
		return  passengerDao.selectInfoByUserName(userName);
	}
	
}
