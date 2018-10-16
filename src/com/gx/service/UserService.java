package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.UserPo;

public interface UserService {

	public UserPo selectLogin(UserPo user);
	
	public int deleteById(Integer id);
	
	
	public int insertAll(UserPo userPo);
	
	
	public	UserPo selectById(Integer id);

	
	public int updateById(UserPo userPo);
	
	
	//分页需要
	public Page<UserPo> pageFuzzyselect(String name,Page<UserPo> vo);
	
    //查询所有数据  非本派所用
    public List<UserPo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<UserPo> selectAjaxList(String name);
    
    //ajax 验证是否存在 此用户名
    public int selectByUserName(String userName);
    
    //根据用户名查找
    public UserPo selectByName(UserPo userPo);
}
