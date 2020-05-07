package de.creatronix.artist3k.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.time.Year;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.Location;

public class EventTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStoreEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Event event = new Event();
		event.setName("Aqua Turbo Contest");
		Calendar date = Calendar.getInstance();
		date.set(2008, 5, 1);
		event.setDate(date);
		session.save(event);
		transaction.commit();
		session.close();

	}

	@Test
	public void testAddLocationToEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Event event = (Event) session.load(Event.class, "Aqua Turbo Contest");
		Location location = new Location();
		location.setName("Fronte 79");
		session.save(location);
		event.setLocation(location);
		session.save(event);
		transaction.commit();
		session.close();
	}

	@Test
	public void testLoadEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Event event2 = (Event) session.load(Event.class, "Aqua Turbo Contest");
		Calendar date = Calendar.getInstance();
		date.set(2008, 5, 1);
		assertEquals(event2.getDate().get(Calendar.YEAR), date
				.get(Calendar.YEAR));
		assertEquals(event2.getDate().get(Calendar.MONTH), date
				.get(Calendar.MONTH));
		assertEquals(event2.getDate().get(Calendar.DAY_OF_MONTH), date
				.get(Calendar.DAY_OF_MONTH));
		assertEquals(event2.getLocation().getName(), "Fronte 79");
		transaction.commit();
		session.close();

	}

	@Test
	public void testDeleteEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Event event = new Event();
		event.setName("Aqua Turbo Contest");
		session.delete(event);
		transaction.commit();
		session.close();
	}

	@Test
	public void testLoadEventByDate() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Calendar date = Calendar.getInstance();
		date.set(2008, 5, 1);
		Event event = new Event();
		event.setName("Aqua Turbo Contest");
		event.setDate(date);

		session.save(event);
		transaction.commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String sql = "FROM Event WHERE date = :date";
		Query query = session.createQuery(sql).setParameter("date", date);
		List list = query.list();
		Event event2 = (Event) list.get(0);
		assertEquals(event2.getDate().get(Calendar.YEAR), date
				.get(Calendar.YEAR));
		assertEquals(event2.getDate().get(Calendar.MONTH), date
				.get(Calendar.MONTH));
		assertEquals(event2.getDate().get(Calendar.DAY_OF_MONTH), date
				.get(Calendar.DAY_OF_MONTH));
		transaction.commit();
		session.close();

	}

	@Test
	public void testFormatDate() {

		Event ev = new Event();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2008);
		date.set(Calendar.MONTH, Calendar.MAY);
		date.set(Calendar.DAY_OF_MONTH, 1);
		ev.setDate(date);
		System.out.println(ev.getDate().get(Calendar.YEAR));
		System.out.println(ev.getDate().get(Calendar.MONTH));
		System.out.println(ev.getDate().get(Calendar.DAY_OF_MONTH));
		System.out.println(ev.getFormattedDate());
		assertEquals("01-05-2008", ev.getFormattedDate());

	}

}
