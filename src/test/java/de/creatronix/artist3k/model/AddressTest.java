package de.creatronix.artist3k.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.Address;

public class AddressTest {

	private Long addressID;

	@Test
	public void testStoreLoadDeleteAddress() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Address address = new Address();
		address.setCountry("Germany");
		address.setTown("D-Dorf");
		address.setGeoCoordinates("NordSüd");
		address.setStreet("Strasse der Hoffnung");
		address.setStreetNumber("9");
		address.setZipcode("4711");

		addressID = (Long) session.save(address);
		transaction.commit();
		session.close();
		
		System.out.println(addressID);
		//Load
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		address = (Address) session.get(Address.class, addressID);
		transaction.commit();
		session.close();
		assertEquals(address.getTown(), "D-Dorf");
		//Delete
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		address = new Address();
		address.setId(addressID);
		session.delete(address);
		transaction.commit();
		session.close();
		//Load again
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		address = (Address) session.get(Address.class, addressID);
		transaction.commit();
		session.close();
		assertEquals(address, null);
		
	}

	
}
