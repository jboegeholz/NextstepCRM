package de.creatronix.artist3k.controller.form;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EventListForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection events;

	public Collection getEvents() {
		return events;
	}


	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		events = new ArrayList();
	}

	public void setEvents(Collection allEvents) {
		this.events = allEvents;

	}
}
