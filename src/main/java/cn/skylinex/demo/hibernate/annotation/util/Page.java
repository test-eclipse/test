package cn.skylinex.demo.hibernate.annotation.util;

import java.util.ArrayList;
import java.util.List;

public class Page<T> 
{
	private int pageNumber = 1;
	private int pageSize = 25;
	@SuppressWarnings("unused")
	private int startIndex = 0;
	private int totle = 0;
	private List<T> result = new ArrayList<T>();

	public Page(int pageNumber, int pageSize, int totle, List<T> result) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totle = totle;
		this.result = result;
	}
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotle() {
		return totle;
	}
	public void setTotle(int totle) {
		this.totle = totle;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	//计算起始索引
	public int getStartIndex() 
	{
		return (pageNumber-1) * pageSize;
	}
	
	public  Page<T> getNullPage(int pageNumber,int pageSize) {
		return new Page<T>(pageNumber, pageSize, 0, new  ArrayList<T>());
	}
	
}
