package de.creatronix.artist3k.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;

public class ApplicationTest {
	static Long id = new Long(0);

	public void test() {
	}

	@Test
	public void testStoreLoadDeleteApplication() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Application application = new Application();
		Event event = new Event();
		event.setName("Wacken");
		application.setEvent(event);
		application.setStatus("Unbeworben");
		application.setDemandedFee(new BigDecimal(20.5));
		application.setReceivedExpenses(new BigDecimal(200.7));
		User user = new User();
		user.setUsername("heinz");
		application.setBooker(user);
		StageAct stageAct = new StageAct();
		stageAct.setName("damn hot shit");
		application.setStageAct(stageAct);
		session.save(application);
		transaction.commit();
		session.close();
		id = application.getId();
		// Load
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		application = (Application) session.get(Application.class, new Long(id));
		transaction.commit();
		session.close();
		assertEquals(application.getEvent().getName(), "Wacken");
		assertEquals(application.getDemandedFee(), new BigDecimal(20.5));
		assertEquals(application.getReceivedExpenses(), new BigDecimal(200.7));
		assertEquals(application.getBooker().getUsername(), "heinz");
		assertEquals(application.getStageAct().getName(), "damn hot shit");

	}
	//@Test
	public void testLoadApplicationByEvent() {

		// save a new app with event and stage act
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Application application = new Application();
		Event event = new Event();
		event.setName("Wacken2");
		application.setEvent(event);
		StageAct stageAct = new StageAct();
		stageAct.setName("damn hot shit");
		application.setStageAct(stageAct);
		session.saveOrUpdate(application);
		transaction.commit();
		session.close();
		// save a second app with event and stage act
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Application application2 = new Application();
		Event event2 = new Event();
		event.setName("Wacken");
		application.setEvent(event2);
		StageAct stageAct2 = new StageAct();
		stageAct.setName("blub");
		application.setStageAct(stageAct2);
		session.saveOrUpdate(application2);
		transaction.commit();
		session.close();
		// Query
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Collection<Application> applications = session.createQuery("from Application as a").list();
		transaction.commit();
		session.close();
		assertTrue(applications.contains(application2));
	}

}
