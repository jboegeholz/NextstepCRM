package de.creatronix.artist3k.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.EventEditForm;
import de.creatronix.artist3k.exception.EventAlreadyExistsException;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.EventManager;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.LocationManager;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.Organizer;
import de.creatronix.artist3k.model.OrganizerManager;

public class EventEditAction extends DispatchAction {
	public ActionForward editEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		EventEditForm eventEditForm = (EventEditForm) form;
		EventManager eventManager = ModelController.getInstance()
				.getEventManager();
		LocationManager locationManager = ModelController.getInstance()
				.getLocationManager();
		OrganizerManager organizerManager = ModelController.getInstance().getOrganizerManager();
		
		eventEditForm.setEvent(eventManager.loadEventByName(request
				.getParameter("name")));
		eventEditForm.setLocations(locationManager.getAllLocations());
		eventEditForm.setOrganizers(organizerManager.getAllOrganizers());

		return mapping.findForward("showEdit");

	}

	public ActionForward deleteEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		EventEditForm eventEditForm = (EventEditForm) form;

		/*
		 * get the manager
		 */
		EventManager eventManager = ModelController.getInstance()
				.getEventManager();

		eventManager.deleteEvent(eventEditForm.getEvent());

		return mapping.findForward("showList");
	}


	public ActionForward updateEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		EventManager eventManager = ModelController.getInstance().getEventManager();
		
		LocationManager locationManager = ModelController.getInstance().getLocationManager();
		
		OrganizerManager organizerManager = ModelController.getInstance().getOrganizerManager();
		
		EventEditForm eventEditForm = (EventEditForm) form;
		
		Location location = locationManager.loadLocationByName(eventEditForm.getLocationName());
Organizer organizer = organizerManager.loadOrganizerByName(eventEditForm.getOrganizerName());
		Event event = eventEditForm.getEvent();
		
		event.setLocation(location);	
		/*
		 * save it to DB
		 */
		eventManager.updateToDB(event);

		return mapping.findForward("showList");
	}
	public ActionForward updateEventAndAddLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		EventManager eventManager = ModelController.getInstance()
				.getEventManager();
		
		EventEditForm eventEditForm = (EventEditForm) form;
		
		Event event = eventEditForm.getEvent();
		
		eventManager.updateToDB(event);

		return mapping.findForward("showAddLocation");
		
	}
}
