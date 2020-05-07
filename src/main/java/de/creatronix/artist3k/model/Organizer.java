package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Organizer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7665564347906706669L;
	private String name;
	private String url;
	private Address address;
	private Set<ContactPerson> contactPersons = new HashSet<ContactPerson>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<ContactPerson> getContactPersons() {
		return contactPersons;
	}
	public void setContactPersons(Set<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}
}
