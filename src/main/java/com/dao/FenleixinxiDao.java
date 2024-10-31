package com.dao;

import com.entity.FenleixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FenleixinxiVO;
import com.entity.view.FenleixinxiView;


/**
 * 分类信息
 * 
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
public interface FenleixinxiDao extends BaseMapper<FenleixinxiEntity> {
	
	List<FenleixinxiVO> selectListVO(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
	
	FenleixinxiVO selectVO(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
	
	List<FenleixinxiView> selectListView(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);

	List<FenleixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
	
	FenleixinxiView selectView(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
	
}
