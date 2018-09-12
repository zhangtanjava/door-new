package com.gx.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.gx.po.UserPo;

public interface UserDao {
	
	public UserPo selectLogin(UserPo userPo);
	
	public UserPo selectByname(UserPo userPo);
	
	public int selectByUserName(String userName);
	
	public int deleteById(Integer id);
	
	
	public int insertAll(UserPo userPo);
	
	
	public	UserPo selectById(Integer id);

	
	public int updateById(UserPo userPo);
	
	//分页模糊查询
    public List<UserPo> pageFuzzyselect(@Param("userName")String userName,
    		@Param("start")int start,@Param("pageSize")int pageSize);
    
    //分页模糊查询总条数
    public int countFuzzyselect(@Param("userName")String userName);
    
    
   //ajax 验证是否存在 此身份证号码
   public int selectYZ(String roleID);
    
    
    
    
    //查询所有数据  非本派所用
    public List<UserPo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<UserPo> selectAjaxList(String userName);
}
