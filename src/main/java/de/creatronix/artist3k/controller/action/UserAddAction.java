package de.creatronix.artist3k.controller.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.struts.actions.DispatchAction;
import de.creatronix.artist3k.controller.form.UserAddForm;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.UserAlreadyExistsException;



public class UserAddAction extends DispatchAction {
	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("showAddUser");
	}
	public ActionForward saveUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		UserAddForm userForm = (UserAddForm) form;
		try {
			ModelController.getInstance().getUserManager().saveUser(userForm.getUser());
		} catch (UserAlreadyExistsException e) {
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("application.already.exists");
			errors.add("message1", msg);
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		
		return mapping.findForward("showUserList");
	}
}
