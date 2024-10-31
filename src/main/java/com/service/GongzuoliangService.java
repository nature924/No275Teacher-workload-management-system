package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzuoliangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzuoliangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuoliangView;


/**
 * 工作量
 *
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
public interface GongzuoliangService extends IService<GongzuoliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuoliangVO> selectListVO(Wrapper<GongzuoliangEntity> wrapper);
   	
   	GongzuoliangVO selectVO(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
   	
   	List<GongzuoliangView> selectListView(Wrapper<GongzuoliangEntity> wrapper);
   	
   	GongzuoliangView selectView(@Param("ew") Wrapper<GongzuoliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuoliangEntity> wrapper);
   	
}

