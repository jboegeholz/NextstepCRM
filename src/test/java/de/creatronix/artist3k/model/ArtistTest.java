package de.creatronix.artist3k.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.Artist;
import de.creatronix.artist3k.model.ContactDetails;


public class ArtistTest {
	@Test
	public void testStoreArtist() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Address address = new Address();
		address.setCountry("Germany");
		address.setTown("D-Dorf");
		address.setGeoCoordinates("NordSüd");
		address.setStreet("Strasse der Hoffnung");
		address.setStreetNumber("9");
		address.setZipcode("4711");
		
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.getAddresses().add(address);
		contactDetails.setCellPhoneNumber("0127/123123123");
		contactDetails.setEmail("alex@xxx.com");
		contactDetails.setLandlineNumber("05731/456745");
		
		Artist artist = new Artist();
		artist.setContactDetails(contactDetails);
		artist.setAlias("Alex Amsterdam");
		artist.setFirstname("Alexander");
		artist.setSurname("Rosin");

		session.saveOrUpdate(artist);
		transaction.commit();
		session.close();
		//Load
		 session = HibernateUtil.getSessionFactory().openSession();
		 transaction = session.beginTransaction();
		artist = (Artist) session.get(Artist.class, "Alex Amsterdam");
		assertEquals(artist.getFirstname(), "Alexander");
		assertEquals(artist.getContactDetails().getCellPhoneNumber(), "0127/123123123");
		transaction.commit();
		session.close();
	}
}
