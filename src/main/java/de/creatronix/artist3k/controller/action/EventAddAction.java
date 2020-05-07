package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.EventEditForm;
import de.creatronix.artist3k.exception.EventAlreadyExistsException;
import de.creatronix.artist3k.model.EventManager;
import de.creatronix.artist3k.model.ModelController;

public class EventAddAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(EventAddAction.class);
	
	public ActionForward addEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		return mapping.findForward("showAdd");
	}
	
	public ActionForward saveEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * get the data
		 */
		EventEditForm bookEditForm = (EventEditForm) form;

		/*
		 * get the manager
		 */
		EventManager eventManager = ModelController.getInstance()
				.getEventManager();
//		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("de/creatronix/artist3k/jbpl/processdefinition.xml");
//		ProcessInstance processInstance;
//		processInstance = new ProcessInstance(processDefinition);
//		logger.info(processInstance.getRootToken().getNode().getName());
//		processInstance.signal();
//		logger.info(processInstance.getRootToken().getNode().getName());
		/*
		 * save it to DB
		 */
		try {
			eventManager.saveToDB(bookEditForm.getEvent());
		} catch (EventAlreadyExistsException e) {
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("event.already.exists");
			errors.add("message1", msg);
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

		return mapping.findForward("showList");
	}
	
}
