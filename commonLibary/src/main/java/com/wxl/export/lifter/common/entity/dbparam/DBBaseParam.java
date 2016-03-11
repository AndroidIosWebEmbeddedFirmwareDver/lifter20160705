package com.wxl.export.lifter.common.entity.dbparam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description: 数据库基本参数实体类
 * @ClassName: DBBaseParam
 * @author wxl.sinto.cto
 * @date 2014-9-13 下午2:11:05
 * 
 * @param <object>
 */
public class DBBaseParam<object extends Object>
{

	public int handleType;
	public object object;
	public List<object> objects = new ArrayList<object>();
	public int affectedNum;
	public long datasRows;//表中数据行数
	private Integer pageNumber = 1;
	private Integer pageSize = 20;// 客户端可以指定请求数据数量，默认为20
	private String sortType;
	private Boolean sortByASC = true;// 默认按升序排列
	private Date startDate;
	private Date endDate;
	public Boolean isReadTotal;

	public DBBaseParam()
	{
	}

	public DBBaseParam(Integer pageNumber, Integer pageSize, String sortType, Boolean sortByASC, Date startDate, Date endDate)
	{
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sortType = sortType;
		this.sortByASC = sortByASC;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public String getSortType()
	{
		return sortType;
	}

	public void setSortType(String sortType)
	{
		this.sortType = sortType;
	}

	public Boolean getSortByASC()
	{
		return sortByASC;
	}

	public void setSortByASC(Boolean sortByASC)
	{
		this.sortByASC = sortByASC;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public int getHandleType() {
		return handleType;
	}

	public void setHandleType(int handleType) {
		this.handleType = handleType;
	}

	public object getObject() {
		return object;
	}

	public void setObject(object object) {
		this.object = object;
	}

	public List<object> getObjects() {
		return objects;
	}

	public void setObjects(List<object> objects) {
		this.objects = objects;
	}

	public int getAffectedNum() {
		return affectedNum;
	}

	public void setAffectedNum(int affectedNum) {
		this.affectedNum = affectedNum;
	}

	public long getDatasRows() {
		return datasRows;
	}

	public void setDatasRows(long datasRows) {
		this.datasRows = datasRows;
	}

	public Boolean getReadTotal() {
		return isReadTotal;
	}

	public void setReadTotal(Boolean readTotal) {
		isReadTotal = readTotal;
	}
}
