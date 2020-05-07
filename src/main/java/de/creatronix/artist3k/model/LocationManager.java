package de.creatronix.artist3k.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.exception.EventAlreadyExistsException;

public class LocationManager {
	private SessionFactory factory;
	List<Location> locations;
	private static Logger logger = Logger.getLogger(LocationManager.class);

	public LocationManager() {
		factory = HibernatePlugIn.getFactory();
	}

	public List<Location> getAllLocations() {
		logger.info("get all locations");
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		locations = hbnSession.createQuery("select h from Location as h")
				.list();
		hbnSession.getTransaction().commit();
		return locations;
	}

	public Location loadLocationByName(String name) {
		Session hbnSession = null;
		Location location = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			location = (Location) hbnSession.get(Location.class, name);
			hbnSession.getTransaction().commit();
			if (location == null) {
				System.out.println("Location " + name + " not found!!");
				logger.debug("Location " + name + " not found!!");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (hbnSession != null) {
				hbnSession.close();
			}
		}
		return location;
	}

	public void saveToDB(Location location)
			throws LocationAlreadyExistsException {
		if (loadLocationByName(location.getName()) != null) {
			throw new LocationAlreadyExistsException();
		}
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(location);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}

	public void deleteLocation(Location location) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.delete(location);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
			System.out.println(e.toString());
		} finally {
			hbnSession.close();
		}

	}
	public void updateToDB(Location location) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.update(location);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println(e.toString());
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}
	public int getNumberOfLocations() {
		int numberOfLocations = 0;
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		Query query = hbnSession.createQuery("select count(l) from Location l");
		numberOfLocations = Integer.parseInt(query.list().toArray()[0].toString());
		hbnSession.getTransaction().commit();
		return numberOfLocations;
	}

}
