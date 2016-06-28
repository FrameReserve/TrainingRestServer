package com.training.common.entity;

import com.training.core.entity.BaseEntity;

public class UploadFile extends BaseEntity {

	/**
	 * 文件名
	 */
	private String file_name;
	/**
	 * 缩微图片
	 */
	private String file_thumb;
	/**
	 * 水印图片
	 */
	private String file_wm;
	/**
	 * 文件大小
	 */
	private Integer file_size;
	/**
	 * 关联类型
	 */
	private String ref_class_name;
	/**
	 * 关联Id
	 */
	private String refid;
	/**
	 * 文件类别，0为无，1为文章图片，默认为0，2为商品切换图片，3为商品内容图片，4为系统文章图片，5为积分礼品切换图片，6为积分礼品内容图片
	 */
	private Integer upload_type;
	
	// ------------------------------------- getter and setter --------------------------------------------
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_thumb() {
		return file_thumb;
	}
	public void setFile_thumb(String file_thumb) {
		this.file_thumb = file_thumb;
	}
	public String getFile_wm() {
		return file_wm;
	}
	public void setFile_wm(String file_wm) {
		this.file_wm = file_wm;
	}
	public Integer getFile_size() {
		return file_size;
	}
	public void setFile_size(Integer file_size) {
		this.file_size = file_size;
	}
	public String getRef_class_name() {
		return ref_class_name;
	}
	public void setRef_class_name(String ref_class_name) {
		this.ref_class_name = ref_class_name;
	}
	public String getRefid() {
		return refid;
	}
	public void setRefid(String refid) {
		this.refid = refid;
	}
	public Integer getUpload_type() {
		return upload_type;
	}
	public void setUpload_type(Integer upload_type) {
		this.upload_type = upload_type;
	}
	
}
