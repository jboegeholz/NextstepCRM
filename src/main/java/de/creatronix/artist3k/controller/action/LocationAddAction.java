package de.creatronix.artist3k.controller.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.LocationAddForm;
import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.AddressManager;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.LocationAlreadyExistsException;
import de.creatronix.artist3k.model.LocationManager;
import de.creatronix.artist3k.model.ModelController;

public class LocationAddAction extends DispatchAction {
	public ActionForward saveLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LocationAddForm locationForm = (LocationAddForm) form;
		Location location = locationForm.getLocation();
		LocationManager locationManager = ModelController.getInstance()
		.getLocationManager();
		AddressManager addressManager = ModelController.getInstance()
		.getAddressManager();
		Address address = location.getAddress();
		
		/*
		 * save it to DB
		 */
		try {
			addressManager.saveToDB(address);
			location.setAddress(address);
			locationManager.saveToDB(location);
			
		} catch (LocationAlreadyExistsException e) {
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("error.location.already.exists");
			errors.add("message1", msg);
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

		return mapping.findForward("showLocationList");
	}
}
