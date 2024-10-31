package com.entity.view;

import com.entity.FenleixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 分类信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
@TableName("fenleixinxi")
public class FenleixinxiView  extends FenleixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FenleixinxiView(){
	}
 
 	public FenleixinxiView(FenleixinxiEntity fenleixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, fenleixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
