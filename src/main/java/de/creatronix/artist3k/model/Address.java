package de.creatronix.artist3k.model;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8257451552350591022L;
	private Long id;
	private String street;
	private String streetNumber;
	private String zipcode;
	private String town;
	private String country;
	private String geoCoordinates;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(String geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
