package de.creatronix.artist3k.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.exception.ApplicationAlreadyExistsException;
import de.creatronix.artist3k.exception.StageActAlreadyExistsException;

public class ApplicationManager {
	private SessionFactory factory;
	Collection<Application> applications;
	private static Logger logger = Logger.getLogger(ApplicationManager.class);

	public ApplicationManager() {
		factory = HibernatePlugIn.getFactory();
	}

	public Collection<Application> getAllApplications() {
		logger.info("get all applicatons");
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		applications = hbnSession.createQuery("select h from Application as h")
				.list();
		hbnSession.getTransaction().commit();

		return applications;
	}

	public void saveToDB(Application application)
			throws ApplicationAlreadyExistsException {
		//Before we save the application we check for duplication
		Collection<Application> apps = getAllApplications();
		for (Iterator iterator = apps.iterator(); iterator.hasNext();) {
			Application app = (Application) iterator.next();
			if ((app.equals(application))) {
				throw new ApplicationAlreadyExistsException();
			}
		}

		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(application);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}

	private Application loadApplicationByEvent(Event event) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			// TODO: get the query to work :-(
			applications = hbnSession.createQuery(
					"from Application as a where a.event='Wacken1'").list();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}
		return null;
	}
	
	public List<Application> loadApplicationByDate(Calendar date) {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		String sql = "FROM Application WHERE desiredDate = :date";
		Query query = hbnSession.createQuery(sql).setParameter("date", date);
		List<Application> list = query.list();
		hbnSession.getTransaction().commit();
		return list;
	}

	public int getNumberOfApplications() {
		int numberOfApplications = 0;
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		Query query = hbnSession.createQuery("select count(a) from Application a");
		numberOfApplications = Integer.parseInt(query.list().toArray()[0].toString());
		hbnSession.getTransaction().commit();
		return numberOfApplications;
	}

	public void deleteApplication(Application application) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.delete(application);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
			System.out.println(e.toString());
		} finally {
			hbnSession.close();
		}

		
	}

	public Application loadApplication(Long applicationID) {
		Session hbnSession = null;
		Application app = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			app = (Application) hbnSession.get(Application.class, applicationID);
			hbnSession.getTransaction().commit();
			if (app == null) {
				logger.debug("Location " + app + " not found!!");
			}
		} catch (HibernateException e) {
			logger.error(e);
		} finally {
			if (hbnSession != null) {
				hbnSession.close();
			}
		}
		return app;
	}

	public void updateToDB(Application app) {
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.saveOrUpdate(app);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}
		
	}
}
