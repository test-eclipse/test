package cn.skylinex.demo.hibernate.annotation;

import java.util.Date;

import org.junit.Test;

import cn.skylinex.demo.hibernate.annotation.dao.CompanyDao;
import cn.skylinex.demo.hibernate.annotation.dao.EventDao;
import cn.skylinex.demo.hibernate.annotation.dao.ICompanyDao;
import cn.skylinex.demo.hibernate.annotation.dao.IEventDao;
import cn.skylinex.demo.hibernate.annotation.entity.Company;
import cn.skylinex.demo.hibernate.annotation.entity.EvenType;
import cn.skylinex.demo.hibernate.annotation.entity.Event;
import cn.skylinex.demo.hibernate.annotation.entity.Flight;
import cn.skylinex.demo.hibernate.annotation.util.Page;

public class TestAnnotation {
	@Test
	public void testSave() {
		IEventDao eventDao = new EventDao();
		Event event = new Event();
		
		event.setTitle("活动标题");
		event.setEventName("活动名称");
		event.setEvenType(EvenType.TYPE2);
		event.setDate(new Date());
		
		eventDao.save(event);
	}

	// 级联创建
	@Test
	public void testCascadePersist() {
		ICompanyDao companyDao = new CompanyDao();
		Company c = new Company();
		c.setCompanyName("中国航空公司");

		Flight f1 = new Flight();
		f1.setFlightCode("F000001");
		f1.setCompany(c);

		Flight f2 = new Flight();
		f2.setFlightCode("F000002");
		f2.setCompany(c);

		Flight f3 = new Flight();
		f3.setFlightCode("F000003");
		f3.setCompany(c);

		Flight f4 = new Flight();
		f4.setFlightCode("F000004");
		f4.setCompany(c);

		c.getFlights().add(f1);
		c.getFlights().add(f2);
		c.getFlights().add(f3);
		c.getFlights().add(f4);

		companyDao.save(c);
	}
	//@Test
	public void  findByCompanyName() {
		String companyName = "中国";
		ICompanyDao companyDao = new CompanyDao();
		Company c = companyDao.findByCompanyName(companyName);
		
		System.out.println(c);
	}
	
	@Test
	public void  findPage() {
		int pageNumber=1;
		int pageSize=5;
		ICompanyDao companyDao = new CompanyDao();
		Page<Company> page = companyDao.findPage(pageNumber,pageSize);
		for(Company c: page.getResult()) {
			System.out.println(c);
		}
		
	}
}
