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


import com.dao.FenleixinxiDao;
import com.entity.FenleixinxiEntity;
import com.service.FenleixinxiService;
import com.entity.vo.FenleixinxiVO;
import com.entity.view.FenleixinxiView;

@Service("fenleixinxiService")
public class FenleixinxiServiceImpl extends ServiceImpl<FenleixinxiDao, FenleixinxiEntity> implements FenleixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenleixinxiEntity> page = this.selectPage(
                new Query<FenleixinxiEntity>(params).getPage(),
                new EntityWrapper<FenleixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenleixinxiEntity> wrapper) {
		  Page<FenleixinxiView> page =new Query<FenleixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FenleixinxiVO> selectListVO(Wrapper<FenleixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FenleixinxiVO selectVO(Wrapper<FenleixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FenleixinxiView> selectListView(Wrapper<FenleixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenleixinxiView selectView(Wrapper<FenleixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
