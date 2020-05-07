package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9114157334597959938L;

	private String username;
	private String password;
	private ContactPerson contactPerson;

	

	public User() {
	}

	public User(String username, String passwort) {
		this.username = username;
		this.password = passwort;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof User
				&& ((User)arg0).getUsername().equals(this.username))
			return true;
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
