package com.wxl.export.lifter.common.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
 * @com.wxl.export.lifter.common.entity
 * @HuiyuantongVenusShopCash-V3.x
 * @BaseEntity.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 基础实体类
 * @2015-2-4下午3:06:48
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Long id;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;

	protected Boolean deleted = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
