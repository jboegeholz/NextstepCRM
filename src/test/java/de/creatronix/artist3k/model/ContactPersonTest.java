package de.creatronix.artist3k.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;
import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.ContactDetails;
import de.creatronix.artist3k.model.ContactPerson;

public class ContactPersonTest {
    static Long id = new Long(1);
    @Test
    public void testStoreContactPerson() {
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
        contactDetails.setCellPhoneNumber("0174/6124343");
        contactDetails.setEmail("xxx@yyy.de");
        contactDetails.setLandlineNumber("05731/52144");
        contactDetails.getAddresses().add(address);

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setTitle("Herr");
        contactPerson.setFirstname("Alexander");
        contactPerson.setSurname("Rosin");
        contactPerson.setFunction("Booker");
        contactPerson.setContactDetails(contactDetails);

        session.saveOrUpdate(contactPerson);
        id = contactPerson.getId();
        transaction.commit();
		session.close();
    }

    @Test
    public void testLoadContactPerson() {

    }

    @Test
    public void testDeleteContactPerson() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId(id);
        session.delete(contactPerson);
        transaction.commit();
		session.close();
    }
}
