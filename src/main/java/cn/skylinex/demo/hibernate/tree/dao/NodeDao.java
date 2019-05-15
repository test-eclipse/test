package cn.skylinex.demo.hibernate.tree.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.skylinex.demo.hibernate.tree.entity.Node;
import cn.skylinex.demo.hibernate.tree.util.HibernateUtil;

public class NodeDao implements INodeDao{
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public void save(Node node) {
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		session.save(node);
		session.getTransaction().commit();
	}

	@Override
	public void update(Node node) {
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		session.update(node);
		session.getTransaction().commit();
	}

	@Override
	public void delete(Node node) {
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		session.delete(node);
		session.getTransaction().commit();
		
	}

	@Override
	public Node findOne(Long id) {
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		Node node = session.get(Node.class, id);
		session.getTransaction().commit();
		return node;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Node> findAll() {
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		session.beginTransaction();
		List<Node> result = session.createQuery("from Node").list();//HQL
		session.getTransaction().commit();

		return result;
	}

}
