package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ContactDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3296039875759772721L;
	private Long id;
	private String email;
	private String cellPhoneNumber;
	private String landlineNumber;
	private Set<Address> addresses = new HashSet<Address>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
