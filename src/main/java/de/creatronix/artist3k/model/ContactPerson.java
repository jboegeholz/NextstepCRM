package de.creatronix.artist3k.model;

import java.io.Serializable;

public class ContactPerson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6811908447358887310L;
	
	private Long id;
	private String title;
	private String surname;
	private String firstname;
	private ContactDetails contactDetails;
	private String function;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
