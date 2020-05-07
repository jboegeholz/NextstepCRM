package de.creatronix.artist3k.model;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.db.HibernateUtil;

public class UserManager {
	private SessionFactory factory;
	private Collection<User> users = null;

	public UserManager() {
		factory = HibernatePlugIn.getFactory();
	}

	public boolean verifyUserLogin(String username, String password, User user) {
		return (user != null && username.equals(user.getUsername()) && password
				.equals(user.getPassword()));
	}

	public User getUser(String username) {
		Session hbnSession = null;
		User user = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			user = (User) hbnSession.get(User.class, username);
			hbnSession.getTransaction().commit();
			if (user == null) {
				System.out.println("User " + username + " not found!!");
			} else {
				// hbnSession.beginTransaction();
				// user = (User) hbnSession.load(User.class, username);
				// hbnSession.getTransaction().commit();
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (hbnSession != null) {
				hbnSession.close();
			}
		}
		return user;
	}
	public Collection<User> getAllUsers() {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		users = hbnSession.createQuery("select h from User as h").list();
		hbnSession.getTransaction().commit();
	
		return users;
	}
	public void testStoreUser() {
		Session hbnSession = HibernateUtil.getSessionFactory()
				.openSession();
		hbnSession.beginTransaction();

		User user = new User();
		user.setUsername("Alex");
		user.setPassword("Alex");
		hbnSession.saveOrUpdate(user);
		User user2 = new User();
		user2.setUsername("Joern");
		user2.setPassword("joern");
		hbnSession.saveOrUpdate(user2);
		hbnSession.getTransaction().commit();
	}
	public void saveUser(User newUser)
		throws UserAlreadyExistsException {
			//Before we save the application we check for duplication
			Collection<User> users = getAllUsers();
			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
				User user = iterator.next();
				if ((user.equals(newUser))) {
					throw new UserAlreadyExistsException();
				}
			}

			Session hbnSession = null;
			try {
				hbnSession = factory.openSession();
				hbnSession.beginTransaction();
				hbnSession.save(newUser);
				hbnSession.flush();
				hbnSession.getTransaction().commit();
			} catch (HibernateException e) {
				hbnSession.getTransaction().rollback();
			} finally {
				hbnSession.close();
			}
	}
}
