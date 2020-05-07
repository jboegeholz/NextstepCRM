package de.creatronix.artist3k.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.exception.EventAlreadyExistsException;

public class EventManager {
	private SessionFactory factory;
	private List<Event> events = null;
	private static Logger logger = Logger.getLogger(EventManager.class);

	public EventManager() {
		factory = HibernatePlugIn.getFactory();
	}

	public List<Event> getAllEvents() {
		logger.info("get all events");
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		events = hbnSession.createQuery("select h from Event as h").list();
		hbnSession.getTransaction().commit();

		return events;
	}

	public Event loadEventByName(String name) {
		Session hbnSession = null;
		Event event = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			event = (Event) hbnSession.get(Event.class, name);
			hbnSession.getTransaction().commit();
			if (event == null) {
				System.out.println("Event " + name + " not found!!");
				logger.debug("Event " + name + " not found!!");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (hbnSession != null) {
				hbnSession.close();
			}
		}
		return event;
	}

	public void saveToDB(Event event) throws EventAlreadyExistsException {
		if (loadEventByName(event.getName()) != null) {
			throw new EventAlreadyExistsException();
		}
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(event);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}

	public void updateToDB(Event event) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.saveOrUpdate(event);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}

	public void deleteEvent(Event event) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.delete(event);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
			System.out.println(e.toString());
		} finally {
			hbnSession.close();
		}

	}

	public List<Event> loadEventsByDate(Calendar date) {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		String sql = "FROM Event WHERE date = :date";
		Query query = hbnSession.createQuery(sql).setParameter("date", date);
		List<Event> list = query.list();
		hbnSession.getTransaction().commit();
		return list;
	}

	public List<Event> loadEventsByRegistrationDeadline(
			Calendar registrationDeadline) {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		String sql = "FROM Event WHERE registrationDeadline = :registrationDeadline";
		Query query = hbnSession.createQuery(sql).setParameter(
				"registrationDeadline", registrationDeadline);
		List<Event> list = query.list();
		hbnSession.getTransaction().commit();
		return list;
	}

	public int getNumberOfEvents()
	{	
		int numberOfEvents = 0;
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		Query query = hbnSession.createQuery("select count(e) from Event e");
		numberOfEvents = Integer.parseInt(query.list().toArray()[0].toString());
		hbnSession.getTransaction().commit();
		return numberOfEvents;
	}
}
