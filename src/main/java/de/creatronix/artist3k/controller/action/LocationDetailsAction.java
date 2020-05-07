package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.EventEditForm;
import de.creatronix.artist3k.controller.form.LocationDetailsForm;
import de.creatronix.artist3k.model.EventManager;
import de.creatronix.artist3k.model.LocationManager;
import de.creatronix.artist3k.model.ModelController;



public class LocationDetailsAction extends DispatchAction {
	public ActionForward locationDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String locationName = request.getParameter("name");
		String charEnc = request.getCharacterEncoding();
		LocationDetailsForm locationForm = (LocationDetailsForm) form;
		LocationManager locationManager = ModelController.getInstance()
				.getLocationManager();
		locationForm.setLocation(locationManager.loadLocationByName(locationName));
		return mapping.findForward("showLocationDetails");

	}
}
