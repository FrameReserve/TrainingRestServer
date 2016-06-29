package com.training.syssetting.entity;

import com.training.core.entity.BaseEntity;

/**
 * 系统配置
 * key_code + key_group 唯一索引
 */
public class SystemConfig extends BaseEntity {

	/**
	 * 配置编码
	 */
	private String key_code;
	
	/**
	 * 分组
	 */
	private String key_group;
	
	/**
	 * 显示名字
	 */
	private String key_name;
	
	/**
	 * 值
	 */
	private String key_value;
	
	/**
	 * 描述
	 */
	private String comment;

	// ---------------------------------------------- getter and setter ---------------------------------------------------------
	public String getKey_code() {
		return key_code;
	}

	public void setKey_code(String key_code) {
		this.key_code = key_code;
	}

	public String getKey_group() {
		return key_group;
	}

	public void setKey_group(String key_group) {
		this.key_group = key_group;
	}

	public String getKey_name() {
		return key_name;
	}

	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}

	public String getKey_value() {
		return key_value;
	}

	public void setKey_value(String key_value) {
		this.key_value = key_value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
