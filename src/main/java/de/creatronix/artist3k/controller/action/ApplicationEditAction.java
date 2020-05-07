package de.creatronix.artist3k.controller.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import de.creatronix.artist3k.controller.form.ApplicationEditForm;

import de.creatronix.artist3k.model.Application;
import de.creatronix.artist3k.model.ApplicationManager;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.StageAct;
import de.creatronix.artist3k.model.User;

public class ApplicationEditAction extends DispatchAction {
	static Collection<String> appStati = new ArrayList<String>();
	static{
		
		appStati.add("unklar / offen");
		appStati.add("abgesagt / erledigt");
		appStati.add("bestätigt");
		appStati.add("abgespielt");
		
	}
	
	
	public ActionForward editApplication(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		Long applicationID = Long.parseLong(request.getParameter("id"));

		ApplicationEditForm appEditForm = (ApplicationEditForm) form;
		ApplicationManager applicationManager = ModelController.getInstance()
				.getApplicationManager();
		appEditForm.setApplication(applicationManager.loadApplication(applicationID));
		Collection<User> allUser = ModelController.getInstance()
				.getUserManager().getAllUsers();
		Collection<StageAct> allStageActs = ModelController.getInstance()
				.getStageActManager().getAllStageActs();
		Collection<Event> allEvents = ModelController.getInstance()
				.getEventManager().getAllEvents();
		Collection<Location> allLocations = ModelController.getInstance()
				.getLocationManager().getAllLocations();
		appEditForm.setAllUser(allUser);
		appEditForm.setAllStageActs(allStageActs);
		appEditForm.setAllEvents(allEvents);
		appEditForm.setAllLocations(allLocations);
		appEditForm.setApplicationStati(appStati);

		return mapping.findForward("showApplicationEdit");

	}

	public ActionForward deleteApplication(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ApplicationEditForm appEditForm = (ApplicationEditForm) form;

		ApplicationManager appManager = ModelController.getInstance()
				.getApplicationManager();

		appManager.deleteApplication(appEditForm.getApplication());

		return mapping.findForward("showApplicationList");
	}
	public ActionForward updateApplication(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		//Long applicationID = Long.parseLong(request.getParameter("id"));
		
		ApplicationManager appManager = ModelController.getInstance().getApplicationManager();
						
		ApplicationEditForm appForm = (ApplicationEditForm) form;		
		
		User user = ModelController.getInstance().getUserManager().getUser(appForm.getBookerName());
		StageAct stageAct = ModelController.getInstance().getStageActManager().loadStageActByName(appForm.getStageActName());
		Event event = ModelController.getInstance().getEventManager().loadEventByName(appForm.getEventName());
		Location location = ModelController.getInstance().getLocationManager().loadLocationByName(appForm.getLocationName());
		Application app = appForm.getApplication();
		app.setBooker(user);
		app.setStageAct(stageAct);
		app.setEvent(event);
		app.setLocation(location);

		appManager.updateToDB(app);

		return mapping.findForward("showApplicationList");
	}
}
