package de.creatronix.artist3k.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;

public class AddressManager {
	private SessionFactory factory;
	public AddressManager() {
		factory = HibernatePlugIn.getFactory();
	}
	public void saveToDB(Address address) {

		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(address);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}
	public void deleteAddress(Address address) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.delete(address);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
			System.out.println(e.toString());
		} finally {
			hbnSession.close();
		}
	}
	public void updateToDB(Address address) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.saveOrUpdate(address);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}
}
