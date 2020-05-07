package de.creatronix.artist3k.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;

public class OffDayTest {
	@Test
	public void testStoreOffDay() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		OffDay offDay = new OffDay();
		Calendar date = Calendar.getInstance();
		date.set(2008, 5, 1);
		offDay.setOffDay(date);
		
		User user = new User();
		user.setUsername("Alex");
		user.setPassword("Alex");
		session.saveOrUpdate(user);
		
		offDay.setUser(user);

		session.saveOrUpdate(offDay);
		transaction.commit();
		session.close();
	}

	@Test
	public void testLoadOffDay() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		OffDay offDay = (OffDay) session.get(OffDay.class, new Long(1));
		User user = new User();
		user.setUsername("Alex");
		user.setPassword("Alex");
		Calendar date = Calendar.getInstance();
		date.set(2008, 5, 1);
		assertEquals(offDay.getOffDay().get(Calendar.YEAR), date
				.get(Calendar.YEAR));
		assertEquals(offDay.getOffDay().get(Calendar.MONTH), date
				.get(Calendar.MONTH));
		assertEquals(offDay.getOffDay().get(Calendar.DAY_OF_MONTH), date
				.get(Calendar.DAY_OF_MONTH));
		assertEquals( offDay.getUser().getUsername(), user.getUsername());
		transaction.commit();
		session.close();

	}
	@Test
	public void testLoadOffDayByDate() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	Calendar date = Calendar.getInstance();
	date.set(2008, 5, 1);
	String sql = "FROM OffDay WHERE off_day = :date";
	Query query = session.createQuery(sql).setParameter("date", date);
	List<OffDay> list = query.list();
	OffDay offDay = (OffDay)list.toArray()[0];
	assertEquals(offDay.getOffDay().get(Calendar.YEAR), date
			.get(Calendar.YEAR));
	assertEquals(offDay.getOffDay().get(Calendar.MONTH), date
			.get(Calendar.MONTH));
	assertEquals(offDay.getOffDay().get(Calendar.DAY_OF_MONTH), date
			.get(Calendar.DAY_OF_MONTH));
	transaction.commit();
	session.close();
}
	@Test
	public void testDeleteOffDay() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		OffDay OffDay = new OffDay();
		OffDay.setId(new Long(1));
		session.delete(OffDay);
		transaction.commit();
		session.close();
	}
}
