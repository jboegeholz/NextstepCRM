package de.creatronix.artist3k.model;

import java.io.Serializable;

/*
 * this class represent the entity of an artist which can be member of a band aka stageact
 */
public class Artist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6870641044955039341L;
	private String surname;
	private String firstname;
	private String alias;
	private String instrument;
	private ContactDetails contactDetails;

	public Artist() {
	}

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

}
