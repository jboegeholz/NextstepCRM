package de.creatronix.artist3k.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.exception.ApplicationAlreadyExistsException;
import de.creatronix.artist3k.exception.OffDayAlreadyExistsException;

public class CalendarManager {
	private SessionFactory factory;
	private Collection<OffDay> offDays = null;
	public CalendarManager() {
		factory = HibernatePlugIn.getFactory();
	}
	public void saveToDB(OffDay newOffDay)
			throws OffDayAlreadyExistsException {
		// Before we save the application we check for duplication
		Collection<OffDay> offDays = getAllOffDays();
		for (Iterator iterator = offDays.iterator(); iterator.hasNext();) {
			OffDay offDay = (OffDay) iterator.next();
			// apps are equal if stageact and event are the same
			if (offDay.equals(newOffDay)) {
				throw new OffDayAlreadyExistsException();
			}
		}

		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(newOffDay);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}

	public Collection<OffDay> getAllOffDays() {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		offDays = hbnSession.createQuery("select h from OffDay as h").list();
		hbnSession.getTransaction().commit();
		return offDays;
	}
	public List<OffDay> loadOffDaysByDate(Calendar date) {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		String sql = "FROM OffDay WHERE offDay = :date";
		Query query = hbnSession.createQuery(sql).setParameter("date", date);
		List<OffDay> list = query.list();
		hbnSession.getTransaction().commit();
		return list;
	}
}
