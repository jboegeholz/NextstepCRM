package de.creatronix.artist3k.controller.form;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.ContactPerson;
import de.creatronix.artist3k.model.Location;

public class LocationAddForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6561482312167028052L;
	Location location = new Location();
	Address address = new Address();
	
	public LocationAddForm() {
		location.setAddress(address);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return location.getName();
	}
	
	public String getUrl() {
		return location.getUrl();
	}
	public String getLocationStreet() {
		return location.getAddress().getStreet();
	}
	public void setLocationStreet(String street) {
		location.getAddress().setStreet(street);
	}

	public String getLocationStreetNo() {
		return location.getAddress().getStreetNumber();
	}
	public void setLocationStreetNo(String no) {
		location.getAddress().setStreetNumber(no);
	}

	public String getLocationTown() {
		return location.getAddress().getTown();
	}
	public void setLocationTown(String town) {
		 location.getAddress().setTown(town);
	}

	public String getLocationZipCode() {
		return location.getAddress().getZipcode();
	}
	public void setLocationZipCode(String zip) {
		location.getAddress().setZipcode(zip);
	}

	public String getLocationCountry() {
		return location.getAddress().getCountry();
	}
	public void setLocationCountry(String country) {
		location.getAddress().setCountry(country);
	}
	
	public Set<ContactPerson> getContactPersons() {
		return location.getContactPersons();
	}
	public String getLatitude() {
		return location.getLatitude();
	}
	public String getLocationType() {
		return location.getLocationType();
	}
	public String getLongitude() {
		return location.getLongitude();
	}

	public int hashCode() {
		return location.hashCode();
	}
	public void setAddress(Address address) {
		location.setAddress(address);
	}
	public void setContactPersons(Set<ContactPerson> contactPersons) {
		location.setContactPersons(contactPersons);
	}
	public void setLatitude(String latitude) {
		location.setLatitude(latitude);
	}
	public void setLocationType(String locationType) {
		location.setLocationType(locationType);
	}
	public void setLongitude(String longitude) {
		location.setLongitude(longitude);
	}
	public void setName(String name) {
		location.setName(name);
	}
	public void setUrl(String url) {
		location.setUrl(url);
	}
	public String toString() {
		return location.toString();
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (location.getName() == null || location.getName().trim().equals("")) {
			errors.add("name", new ActionMessage("error.name.required"));
		}
		if (location.getAddress().getStreet() == null || location.getAddress().getStreet().trim().equals("")) {
			errors.add("name", new ActionMessage("error.address.street.required"));
		}
		if (location.getAddress().getStreetNumber()== null || location.getAddress().getStreetNumber().trim().equals("")) {
			errors.add("name", new ActionMessage("error.address.streetno.required"));
		}
		if (location.getAddress().getZipcode() == null || location.getAddress().getZipcode().trim().equals("")) {
			errors.add("name", new ActionMessage("error.address.zipcode.required"));
		}
		if (location.getAddress().getTown() == null || location.getAddress().getTown().trim().equals("")) {
			errors.add("name", new ActionMessage("error.address.town.required"));
		}

		return errors;
	}

}
