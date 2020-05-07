package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.ApplicationDetailsForm;
import de.creatronix.artist3k.model.ApplicationManager;
import de.creatronix.artist3k.model.ModelController;



public class ApplicationDetailsAction extends DispatchAction {
	public ActionForward applicationDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Long applicationID = Long.parseLong(request.getParameter("id"));

		ApplicationDetailsForm applicationForm = (ApplicationDetailsForm) form;
		ApplicationManager applicationManager = ModelController.getInstance()
				.getApplicationManager();
		applicationForm.setApplication(applicationManager.loadApplication(applicationID));
		return mapping.findForward("showApplicationDetails");

	}
}
