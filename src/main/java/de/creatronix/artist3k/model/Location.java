package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Location implements Serializable, Comparable<Location> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1098249317095304090L;
	private String name;
	private String locationType;
	private String url;
	private Address address;
	private String latitude;
	private String longitude;
	private Set<ContactPerson> contactPersons = new HashSet<ContactPerson>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int compareTo(Location o) {
		return this.name.compareTo(o.getName());
	}

}
