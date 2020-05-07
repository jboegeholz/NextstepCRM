package de.creatronix.artist3k.controller.action;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.creatronix.artist3k.controller.form.EventListForm;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.EventManager;
import de.creatronix.artist3k.model.EventSortByDate;
import de.creatronix.artist3k.model.ModelController;



public class EventListAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        EventListForm eventListForm = (EventListForm) form;
        EventManager eventManager = ModelController.getInstance().getEventManager();
        List<Event> events = eventManager.getAllEvents();
        Collections.sort(events, new EventSortByDate());
        eventListForm.setEvents(events);
        return mapping.findForward("showList");
    }
}
