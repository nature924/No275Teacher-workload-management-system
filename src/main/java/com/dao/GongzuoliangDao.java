package com.dao;

import com.entity.GongzuoliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuoliangVO;
import com.entity.view.GongzuoliangView;


/**
 * 工作量
 * 
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
public interface GongzuoliangDao extends BaseMapper<GongzuoliangEntity> {
	
	List<GongzuoliangVO> selectListVO(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
	
	GongzuoliangVO selectVO(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
	
	List<GongzuoliangView> selectListView(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);

	List<GongzuoliangView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
	
	GongzuoliangView selectView(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
	
}
