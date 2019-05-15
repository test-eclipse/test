package cn.skylinex.demo.hibernate.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.skylinex.demo.hibernate.hbm.entity.Event;
import cn.skylinex.demo.hibernate.hbm.util.HibernateUtil;


public class EventDao implements IEventDao 
{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
//	public void saveOld(Event event) {
//		//1.创建会话
//		Session session = sessionFactory.openSession();//创建非线程安全会话
//		//2.开始事务
//		session.beginTransaction();
//		try {
//			//3.执行会话  CRUD API
//			session.save(event);
//			//4.提交事务
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//		}finally {
//			session.close();
//		}
//	}
	@Override
	public void save(Event event) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.save(event);
//		
		//4.提交事务
		session.getTransaction().commit();
	}

	@Override
	public void update(Event event) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.update(event);
		//4.提交事务
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(Event event) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.delete(event);
		//4.提交事务
		session.getTransaction().commit();
		
	}

	@Override
	public Event findOne(Long id) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		Event event = session.get(Event.class, id);
		//Event event = session.load(Event.class, id);
		//4.提交事务
		session.getTransaction().commit();
		
		return event;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAll() {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		List<Event> result = session.createQuery("from Event").list();//HQL
		//List<Event> result = session.createSQLQuery("select * from t_event").list();//SQL
		
		//4.提交事务
		session.getTransaction().commit();

		return result;
	}

}
