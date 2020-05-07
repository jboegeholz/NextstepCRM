package de.creatronix.artist3k.controller.form;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.Location;

public class LocationListForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6653715358101638274L;
	private Collection<Location> locations;

	public Collection<Location> getLocations() {
		return locations;
	}
	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}

}
