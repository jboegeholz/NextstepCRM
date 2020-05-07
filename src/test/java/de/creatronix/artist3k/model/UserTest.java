package de.creatronix.artist3k.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.ContactPerson;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.User;

public class UserTest {
	@Test
	public void testStoreUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUsername("Alex");
		user.setPassword("Alex");
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
	}

	@Test
	public void testLoadUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, "Alex");
		assertEquals(user.getUsername(), "Alex");
		transaction.commit();
		session.close();
	}
}
