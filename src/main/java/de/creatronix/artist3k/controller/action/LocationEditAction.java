package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import de.creatronix.artist3k.controller.form.LocationEditForm;
import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.AddressManager;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.LocationManager;
import de.creatronix.artist3k.model.ModelController;

public class LocationEditAction extends DispatchAction {
	public ActionForward deleteLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LocationEditForm locationEditForm = (LocationEditForm) form;

		LocationManager locationManager = ModelController.getInstance()
				.getLocationManager();
		String locationName = request.getParameter("name");
		Location location = locationManager.loadLocationByName(locationName);
		AddressManager addressManager = ModelController.getInstance()
				.getAddressManager();
		if (location != null) { // for some reason this method is entered
								// twice?!?
			addressManager.deleteAddress(location.getAddress());
			locationManager.deleteLocation(location);
		}

		return mapping.findForward("showLocationList");
	}

	public ActionForward editLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LocationEditForm locationEditForm = (LocationEditForm) form;

		LocationManager locationManager = ModelController.getInstance()
				.getLocationManager();
		String locationName = request.getParameter("name");
		Location location = locationManager.loadLocationByName(locationName);
		locationEditForm.setLocation(location);

		return mapping.findForward("showLocationEdit");
	}

	public ActionForward updateLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LocationEditForm locationEditForm = (LocationEditForm) form;
		LocationManager locationManager = ModelController.getInstance()
				.getLocationManager();
		//No other way to retrieve the address id?
		//id gets lost on the way to view and back?!?
		Long oldAddressId = locationManager.loadLocationByName(
				locationEditForm.getLocation().getName()).getAddress().getId();
		locationEditForm.getLocation().getAddress().setId(oldAddressId);
		ModelController.getInstance().getLocationManager().updateToDB(
				locationEditForm.getLocation());
		// ModelController.getInstance().getAddressManager().updateToDB(
		// locationEditForm.getLocation().getAddress());
		return mapping.findForward("showLocationList");
	}
}
