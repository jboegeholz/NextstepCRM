package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.creatronix.artist3k.controller.form.UserListForm;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.UserManager;


public class UserListAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        UserListForm userListForm = (UserListForm) form;
        UserManager userManager = ModelController.getInstance().getUserManager();
        userListForm.setUsers(userManager.getAllUsers());
        return mapping.findForward("showUserList");
    }
}
