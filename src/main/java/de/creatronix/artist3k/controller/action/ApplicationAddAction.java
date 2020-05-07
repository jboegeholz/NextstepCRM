package de.creatronix.artist3k.controller.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.ApplicationAddForm;
import de.creatronix.artist3k.exception.ApplicationAlreadyExistsException;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.StageAct;
import de.creatronix.artist3k.model.User;

public class ApplicationAddAction extends DispatchAction {

	public ActionForward addApplication(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ApplicationAddForm addForm = (ApplicationAddForm) form;

		Collection<User> allUser = ModelController.getInstance().getUserManager()
				.getAllUsers();
		Collection<StageAct> allStageActs = ModelController.getInstance()
				.getStageActManager().getAllStageActs();
		Collection<Event> allEvents = ModelController.getInstance().getEventManager()
				.getAllEvents();
		Collection<Location> allLocations = ModelController.getInstance().getLocationManager()
		.getAllLocations();
		addForm.setAllUser(allUser);
		addForm.setAllStageActs(allStageActs);
		addForm.setAllEvents(allEvents);
		addForm.setAllLocations(allLocations);
		return mapping.findForward("showAddApplication");
	}

	public ActionForward saveApplication(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ApplicationAddForm appForm = (ApplicationAddForm) form;
		//load all entities by name
		User user = ModelController.getInstance().getUserManager().getUser(appForm.getBookerName());
		StageAct stageAct = ModelController.getInstance().getStageActManager().loadStageActByName(appForm.getStageActName());
		Event event = ModelController.getInstance().getEventManager().loadEventByName(appForm.getEventName());
		Location location = ModelController.getInstance().getLocationManager().loadLocationByName(appForm.getLocationName());
		appForm.getApplication().setBooker(user);
		appForm.getApplication().setStageAct(stageAct);
		appForm.getApplication().setEvent(event);
		appForm.getApplication().setLocation(location);
		try {
			ModelController.getInstance().getApplicationManager().saveToDB(
					appForm.getApplication());
		} catch (ApplicationAlreadyExistsException e) {
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("application.already.exists");
			errors.add("message1", msg);
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		return mapping.findForward("showApplicationList");
	}

}
