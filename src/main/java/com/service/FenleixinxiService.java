package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenleixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenleixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenleixinxiView;


/**
 * 分类信息
 *
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
public interface FenleixinxiService extends IService<FenleixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenleixinxiVO> selectListVO(Wrapper<FenleixinxiEntity> wrapper);
   	
   	FenleixinxiVO selectVO(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
   	
   	List<FenleixinxiView> selectListView(Wrapper<FenleixinxiEntity> wrapper);
   	
   	FenleixinxiView selectView(@Param("ew") Wrapper<FenleixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenleixinxiEntity> wrapper);
   	
}

