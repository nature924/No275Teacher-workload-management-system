package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 工作量
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-28 11:09:47
 */
@TableName("gongzuoliang")
public class GongzuoliangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzuoliangEntity() {
		
	}
	
	public GongzuoliangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 理论
	 */
					
	private String lilun;
	
	/**
	 * 实验
	 */
					
	private String shiyan;
	
	/**
	 * 实习
	 */
					
	private String shixi;
	
	/**
	 * 课程系数
	 */
					
	private String kechengxishu;
	
	/**
	 * 合班数量
	 */
					
	private String hebanshuliang;
	
	/**
	 * 合班系数
	 */
					
	private String hebanxishu;
	
	/**
	 * 作业增量系数
	 */
					
	private String zuoyezengliangxishu;
	
	/**
	 * 作业增量
	 */
					
	private String zuoyezengliang;
	
	/**
	 * 实验类型系数
	 */
					
	private String shiyanleixingxishu;
	
	/**
	 * 实习调整系数
	 */
					
	private String shixidiaozhengxishu;
	
	/**
	 * 当量学时
	 */
					
	private String dangliangxueshi;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 提交时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tijiaoshijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：理论
	 */
	public void setLilun(String lilun) {
		this.lilun = lilun;
	}
	/**
	 * 获取：理论
	 */
	public String getLilun() {
		return lilun;
	}
	/**
	 * 设置：实验
	 */
	public void setShiyan(String shiyan) {
		this.shiyan = shiyan;
	}
	/**
	 * 获取：实验
	 */
	public String getShiyan() {
		return shiyan;
	}
	/**
	 * 设置：实习
	 */
	public void setShixi(String shixi) {
		this.shixi = shixi;
	}
	/**
	 * 获取：实习
	 */
	public String getShixi() {
		return shixi;
	}
	/**
	 * 设置：课程系数
	 */
	public void setKechengxishu(String kechengxishu) {
		this.kechengxishu = kechengxishu;
	}
	/**
	 * 获取：课程系数
	 */
	public String getKechengxishu() {
		return kechengxishu;
	}
	/**
	 * 设置：合班数量
	 */
	public void setHebanshuliang(String hebanshuliang) {
		this.hebanshuliang = hebanshuliang;
	}
	/**
	 * 获取：合班数量
	 */
	public String getHebanshuliang() {
		return hebanshuliang;
	}
	/**
	 * 设置：合班系数
	 */
	public void setHebanxishu(String hebanxishu) {
		this.hebanxishu = hebanxishu;
	}
	/**
	 * 获取：合班系数
	 */
	public String getHebanxishu() {
		return hebanxishu;
	}
	/**
	 * 设置：作业增量系数
	 */
	public void setZuoyezengliangxishu(String zuoyezengliangxishu) {
		this.zuoyezengliangxishu = zuoyezengliangxishu;
	}
	/**
	 * 获取：作业增量系数
	 */
	public String getZuoyezengliangxishu() {
		return zuoyezengliangxishu;
	}
	/**
	 * 设置：作业增量
	 */
	public void setZuoyezengliang(String zuoyezengliang) {
		this.zuoyezengliang = zuoyezengliang;
	}
	/**
	 * 获取：作业增量
	 */
	public String getZuoyezengliang() {
		return zuoyezengliang;
	}
	/**
	 * 设置：实验类型系数
	 */
	public void setShiyanleixingxishu(String shiyanleixingxishu) {
		this.shiyanleixingxishu = shiyanleixingxishu;
	}
	/**
	 * 获取：实验类型系数
	 */
	public String getShiyanleixingxishu() {
		return shiyanleixingxishu;
	}
	/**
	 * 设置：实习调整系数
	 */
	public void setShixidiaozhengxishu(String shixidiaozhengxishu) {
		this.shixidiaozhengxishu = shixidiaozhengxishu;
	}
	/**
	 * 获取：实习调整系数
	 */
	public String getShixidiaozhengxishu() {
		return shixidiaozhengxishu;
	}
	/**
	 * 设置：当量学时
	 */
	public void setDangliangxueshi(String dangliangxueshi) {
		this.dangliangxueshi = dangliangxueshi;
	}
	/**
	 * 获取：当量学时
	 */
	public String getDangliangxueshi() {
		return dangliangxueshi;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：提交时间
	 */
	public void setTijiaoshijian(Date tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	/**
	 * 获取：提交时间
	 */
	public Date getTijiaoshijian() {
		return tijiaoshijian;
	}

}
