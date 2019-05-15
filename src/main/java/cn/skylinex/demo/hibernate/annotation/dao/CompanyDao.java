package cn.skylinex.demo.hibernate.annotation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import cn.skylinex.demo.hibernate.annotation.common.dao.BaseDao;
import cn.skylinex.demo.hibernate.annotation.entity.Company;
import cn.skylinex.demo.hibernate.annotation.util.Page;


public class CompanyDao extends BaseDao<Company, Long> implements ICompanyDao {

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * HQL传参
	 * 	1.字符串拼接，不安全，SQL注入
	 */
	public Company findByCompanyName(String companyName) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		//1.字符串拼接，不安全，SQL注入
		//Query query =  session.createQuery("from Company c  where c.companyName = "+companyName);
		
		//2.?占位符，安全，防止SQL注入，只可以按索引传参
		//Query query =  session.createQuery("from Company c where c.companyName like ?");
		//query.setParameter(0, "%"+companyName+"%");		
		
		//3.:Name  命名占位符，安全，防止SQL注入，可以按命名传多个位置的参数
		Query query =  session.createQuery("from Company c where c.companyName like :name");
		query.setParameter("name", "%"+companyName+"%");	
		
		Company result = (Company) query.list().get(0);
		//4.提交事务
		session.getTransaction().commit();

		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * 分页查询
	 */
	public Page<Company> findPage(int pageNumber, int pageSize) {
		//(pageNumber-1)*pageSize=startIndex
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		
		Query totleQuery=  session.createQuery("select count(*) from Company");
		long l=(long) totleQuery.list().get(0);
		int totle = (int)l;
		if(totle>0) {
			Query query =  session.createQuery("from Company");
			List<Company> result = (List<Company>) query.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).list();
			//4.提交事务
			session.getTransaction().commit();
			
			return new Page(pageNumber, pageSize, totle, result);
		}else {
			//return 空Page
			return null;
		}
	}

	@Override
	public Object[] findCompanyName() {
		//Query query =  session.createQuery("select  c.companyName   from Company c");
		return null;
	}

	@Override
	public List<Company> findCompanyName2() {
		//Query query =  session.createQuery("select  new Company(c.companyName)   from Company c");
		return null;
	}

}
