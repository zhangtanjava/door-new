package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.gx.dao.UserDao;
import com.gx.page.Page;
import com.gx.po.UserPo;
import com.gx.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	
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
	public int updateById(UserPo UserPo) {
		return userDao.updateById(UserPo);
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

}
