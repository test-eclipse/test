package cn.skylinex.demo.hibernate.annotation.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.skylinex.demo.hibernate.annotation.util.HibernateUtil;

public class BaseDao<T,PK extends Serializable> implements IBaseDao<T,PK> 
{
	protected  SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

	//1.声明T泛型的具体类
	private Class<T> clazz;
	//2.默认的构造函数中初始化 T泛型的具体类
	@SuppressWarnings("unchecked")
	public BaseDao() {
		 ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		 clazz = (Class<T>) type.getActualTypeArguments()[0];
//	     System.out.println(this.clazz.getName());
//	     System.out.println(this.clazz.getSimpleName());
//	     System.out.println(this.clazz.getTypeName());
	}
	
	@Override
	public void save(T entity) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		
		//3.执行会话  CRUD API
		session.save(entity);
		
		//4.提交事务
		session.getTransaction().commit();
	}

	@Override
	public void update(T entity) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.update(entity);
		//4.提交事务
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(T entity) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.delete(entity);
		//4.提交事务
		session.getTransaction().commit();
		
	}

	@Override
	public T findOne(PK id) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		T entity = session.get(this.clazz, id);
		//Event event = session.load(Event.class, id);
		//4.提交事务
		session.getTransaction().commit();
		
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		List<T> result = session.createQuery("from " +this.clazz.getSimpleName()).list();//HQL
		//List<Event> result = session.createSQLQuery("select * from t_event").list();//SQL
		
		//4.提交事务
		session.getTransaction().commit();

		return result;
	}

}
