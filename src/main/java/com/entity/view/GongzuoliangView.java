package com.entity.view;

import com.entity.GongzuoliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工作量
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
@TableName("gongzuoliang")
public class GongzuoliangView  extends GongzuoliangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuoliangView(){
	}
 
 	public GongzuoliangView(GongzuoliangEntity gongzuoliangEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuoliangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
