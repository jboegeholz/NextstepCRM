package de.creatronix.artist3k.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;


public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("./hibernate_test.cfg.xml").buildSessionFactory();
			 

		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
