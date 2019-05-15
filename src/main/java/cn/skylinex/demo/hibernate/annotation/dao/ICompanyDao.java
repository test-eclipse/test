package cn.skylinex.demo.hibernate.annotation.dao;

import java.util.List;

import cn.skylinex.demo.hibernate.annotation.common.dao.IBaseDao;
import cn.skylinex.demo.hibernate.annotation.entity.Company;
import cn.skylinex.demo.hibernate.annotation.util.Page;


public interface ICompanyDao extends IBaseDao<Company, Long> 
{
	public Company findByCompanyName(String companyName);
	
	public Object[] findCompanyName();
	public List<Company>findCompanyName2();
	
	
	public Page<Company>  findPage(int pageNumber ,int pageSize);
}
