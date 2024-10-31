package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GongzuoliangDao;
import com.entity.GongzuoliangEntity;
import com.service.GongzuoliangService;
import com.entity.vo.GongzuoliangVO;
import com.entity.view.GongzuoliangView;

@Service("gongzuoliangService")
public class GongzuoliangServiceImpl extends ServiceImpl<GongzuoliangDao, GongzuoliangEntity> implements GongzuoliangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuoliangEntity> page = this.selectPage(
                new Query<GongzuoliangEntity>(params).getPage(),
                new EntityWrapper<GongzuoliangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuoliangEntity> wrapper) {
		  Page<GongzuoliangView> page =new Query<GongzuoliangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzuoliangVO> selectListVO(Wrapper<GongzuoliangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzuoliangVO selectVO(Wrapper<GongzuoliangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzuoliangView> selectListView(Wrapper<GongzuoliangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuoliangView selectView(Wrapper<GongzuoliangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
