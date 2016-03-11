package com.wxl.export.lifter.common.entity;

import com.wxl.export.lifter.common.utils.core.JsonCommonUtils;

import org.apache.http.entity.StringEntity;



/**
 * 
 * @com.wxl.export.lifter.common.entity
 * @HuiyuantongVenusShopCash-V3.x
 * @JsonEntity.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: Object转Json实体
 * @2015-2-4下午3:56:17
 */
public class JsonEntity extends StringEntity {

	public JsonEntity(Object object) throws Exception {
		super(JsonCommonUtils.objectToJson(object), "UTF-8");
		setContentType("application/json");
	}

}
