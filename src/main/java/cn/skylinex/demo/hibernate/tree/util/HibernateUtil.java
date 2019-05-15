package cn.skylinex.demo.hibernate.tree.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 单例模式
 * @author Administrator
 *
 */
public class HibernateUtil 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return null;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
