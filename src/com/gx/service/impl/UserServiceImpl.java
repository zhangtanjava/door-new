package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.gx.dao.UserDao;
import com.gx.page.Page;
import com.gx.po.UserPo;
import com.gx.service.ParametersHandleService;
import com.gx.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private ParametersHandleService parametersHandleService;
	
	@Override
	public UserPo selectLogin(UserPo user) {
		return userDao.selectLogin(user);
	}
	
	@Override
	public int deleteById(Integer id) {
		return userDao.deleteById(id);
	}

	@Override
	public int insertAll(UserPo userPo) {
		UserPo UserPo = userDao.selectByname(userPo);
		if (UserPo == null) {
			return userDao.insertAll(userPo);
		}else {
			logger.info("用户名已存在！");
			return 0;
		}
		
	}

	@Override
	public UserPo selectById(Integer id) {
		return userDao.selectById(id);
	}

	@Override
	@Transactional
	public int updateById(UserPo userPo) {
		UserPo user = selectById(userPo.getId());
		if (!user.getStoreID().equals(userPo.getStoreID())) {//店铺信息做了修改,修改所有和店铺有关的表信息
			parametersHandleService.updateStoreID(user.getStoreID(), userPo.getStoreID());
		}
		return userDao.updateById(userPo);
	}

	@Override
	public Page<UserPo> pageFuzzyselect(String userName, Page<UserPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<UserPo> list=userDao.pageFuzzyselect(userName, start, vo.getPageSize());
		vo.setResult(list);
		int count=userDao.countFuzzyselect(userName);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<UserPo> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<UserPo> selectAjaxList(String name) {
		return userDao.selectAjaxList(name);
	}


	@Override
	public int selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}

	@Override
	public UserPo selectByName(UserPo userPo) {
		return userDao.selectByname(userPo);
	}

}
