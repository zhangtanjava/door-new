package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.WlStore;

public interface WlStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WlStore wlStore);

    int insertSelective(WlStore wlStore);

    WlStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WlStore wlStore);

    int updateByPrimaryKey(WlStore wlStore);
    
    int updateLeftAndRight(WlStore wlStore);
  //分页模糊查询
    public List<WlStore> pageFuzzyselect(@Param("model")String model,
    		@Param("start")int start,@Param("pageSize")int pageSize);
    
    //分页模糊查询总条数
    public int countFuzzyselect(WlStore wlStore);
    
    WlStore selectByModelSize(WlStore wlStore);
    
    int batchUpOrInStoreInfo(List<WlStore> list);
    
    List<WlStore> selectByConditions(WlStore wlStore);
}