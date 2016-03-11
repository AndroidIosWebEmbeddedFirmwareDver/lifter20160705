package com.wxl.export.lifter.common.event;

/**
 * 
 * @Desc: App通用表,数据项及结构
 * @com.wxl.export.lifter.common.event
 * @HuiyuantongVenusMobileCash-V3.x
 * @MobileCashBaseDBColumns.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:41:47
 */
public class MobileCashBaseDBColumns
{
	/**
	 * 
	 * @Desc: 行政区划数据表
	 * @com.wxl.export.lifter.common.event
	 * @HuiyuantongVenusShopCash-V3.x
	 * @DBColumns.java
	 * @Author:Wxl@Sintn.Inc
	 * @2015-5-22上午11:11:06
	 */
	public static class LocalAreaTable
	{
		public static final String TABLENAME = "heralocalArea";
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_Name = "name";
		public static final String COLUMN_ParentId = "parentId";
		public static final String COLUMN_ShortName = "shortName";
		public static final String COLUMN_LevelType = "levelType";
		public static final String COLUMN_CityCode = "cityCode";
		public static final String COLUMN_ZipCode = "zipCode";
		public static final String COLUMN_MergerName = "mergerName";
		public static final String COLUMN_Lng = "lng";
		public static final String COLUMN_Lat = "lat";
		public static final String COLUMN_Pinyin = "pinyin";
		public static final String COLUMN_AERAJSON = "aeraJson";
	}

}
