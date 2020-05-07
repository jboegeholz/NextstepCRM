package de.creatronix.artist3k.controller.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.creatronix.artist3k.controller.form.ApplicationListForm;
import de.creatronix.artist3k.model.ModelController;

public class ApplicationListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ApplicationListForm listForm = (ApplicationListForm) form;
		Collection applications = ModelController.getInstance()
		.getApplicationManager().getAllApplications();
		listForm.setApplications(applications);
		return mapping.findForward("showApplicationList");
	}

}
