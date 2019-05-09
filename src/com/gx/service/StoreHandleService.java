package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.WlStore;

public interface StoreHandleService {

	public int deleteById(Integer id);
	
	public int insertAll(WlStore wlStore);
	
	public	WlStore selectById(Integer id);
	
	public int updateById(WlStore wlStore);
	
	//分页需要
	public Page<WlStore> pageFuzzyselect(Page<WlStore> vo,WlStore wlStore);
	
    //查询所有数据  非本派所用
    public List<WlStore> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<WlStore> selectAjaxList(String name);
    
    //form提交验证该型号尺寸是否存在
    public int selectByModelSize(String model,String size);
    
}
