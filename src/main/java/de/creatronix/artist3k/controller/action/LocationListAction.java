package de.creatronix.artist3k.controller.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import de.creatronix.artist3k.controller.form.LocationListForm;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.LocationManager;
import de.creatronix.artist3k.model.LocationSortByTown;
import de.creatronix.artist3k.model.ModelController;

public class LocationListAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        LocationListForm locationListForm = (LocationListForm) form;
        LocationManager locationManager = ModelController.getInstance().getLocationManager();
        List<Location> locations = locationManager.getAllLocations();
        Collections.sort(locations, new LocationSortByTown());
        locationListForm.setLocations(locations);
        return mapping.findForward("showLocationList");
    }
}
