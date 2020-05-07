package de.creatronix.artist3k.model;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.ContactPerson;
import de.creatronix.artist3k.model.Location;

public class LocationTest {
	@Test
	public void testStoreLocation() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Location location = new Location();
		location.setName("Kamp");
		location.setUrl("abc.de");
		Address address = new Address();
		address.setStreet("blub");
		session.save(address);

		location.setAddress(address);
		HashSet<ContactPerson> contactPersons = new HashSet<ContactPerson>();
		ContactPerson contactPerson = new ContactPerson();
		contactPerson.setSurname("dudeldorfer");
		contactPersons.add(contactPerson);
		location.setContactPersons(contactPersons);

		session.save(location);

		transaction.commit();
		session.close();

	}

	@Test
	public void testLoadLocation() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Location location = (Location) session.get(Location.class, "Kamp");
		assertEquals(location.getName(), "Kamp");
		assertEquals(location.getUrl(), "abc.de");
		assertEquals(location.getAddress().getStreet(), "blub");
		assertEquals(location.getContactPersons().iterator().next()
				.getSurname(), "dudeldorfer");
		transaction.commit();
		session.close();

	}

	@Test
	public void testChangeAndLoadLocation() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Location location = (Location) session.get(Location.class, "Kamp");
		assertEquals(location.getName(), "Kamp");
		location.setUrl("cde.de");
		session.update(location);
		session.flush();
		Location loc2 = (Location) session.get(Location.class, "Kamp");
		assertEquals(loc2.getUrl(), "cde.de");
		transaction.commit();
		session.close();

	}

	@Test
	public void testDeleteLocation() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Location location = new Location();

		location.setName("Kamp");
		session.delete(location);
		session.flush();
		transaction.commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		location = (Location) session.get(Location.class, "Kamp");
		transaction.commit();
		session.close();
		assertEquals(null, location);
	}
}
