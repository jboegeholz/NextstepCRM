package de.creatronix.artist3k.controller.form;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.ContactPerson;
import de.creatronix.artist3k.model.Location;

public class LocationDetailsForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 575498714683175664L;
	Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocationName() {
		return location.getName();
	}

	public void setLocationName(String locationName) {
		location.setName(locationName);
	}

	public String getLocationStreet() {
		return location.getAddress().getStreet();
	}

	public String getLocationStreetNo() {
		return location.getAddress().getStreetNumber();
	}

	public String getLocationTown() {
		return location.getAddress().getTown();
	}

	public String getLocationZipCode() {
		return location.getAddress().getZipcode();
	}

	public String getLocationCountry() {
		return location.getAddress().getCountry();
	}

	public Collection<ContactPerson> getLocationContacts() {
		return location.getContactPersons();
	}
}
