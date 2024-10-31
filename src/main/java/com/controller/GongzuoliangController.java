package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GongzuoliangEntity;
import com.entity.view.GongzuoliangView;

import com.service.GongzuoliangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 工作量
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
@RestController
@RequestMapping("/gongzuoliang")
public class GongzuoliangController {
    @Autowired
    private GongzuoliangService gongzuoliangService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuoliangEntity gongzuoliang,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date tijiaoshijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date tijiaoshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			gongzuoliang.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzuoliangEntity> ew = new EntityWrapper<GongzuoliangEntity>();
		if(tijiaoshijianstart!=null) ew.ge("tijiaoshijian", tijiaoshijianstart);
        	if(tijiaoshijianend!=null) ew.le("tijiaoshijian", tijiaoshijianend);
		PageUtils page = gongzuoliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoliang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        EntityWrapper<GongzuoliangEntity> ew = new EntityWrapper<GongzuoliangEntity>();
		PageUtils page = gongzuoliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuoliangEntity gongzuoliang){
       	EntityWrapper<GongzuoliangEntity> ew = new EntityWrapper<GongzuoliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuoliang, "gongzuoliang")); 
        return R.ok().put("data", gongzuoliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuoliangEntity gongzuoliang){
        EntityWrapper< GongzuoliangEntity> ew = new EntityWrapper< GongzuoliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuoliang, "gongzuoliang")); 
		GongzuoliangView gongzuoliangView =  gongzuoliangService.selectView(ew);
		return R.ok("查询工作量成功").put("data", gongzuoliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuoliangEntity gongzuoliang = gongzuoliangService.selectById(id);
        return R.ok().put("data", gongzuoliang);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuoliangEntity gongzuoliang = gongzuoliangService.selectById(id);
        return R.ok().put("data", gongzuoliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
    	gongzuoliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoliang);
        gongzuoliangService.insert(gongzuoliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
    	gongzuoliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoliang);
        gongzuoliangService.insert(gongzuoliang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuoliang);
        gongzuoliangService.updateById(gongzuoliang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuoliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GongzuoliangEntity> wrapper = new EntityWrapper<GongzuoliangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = gongzuoliangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
