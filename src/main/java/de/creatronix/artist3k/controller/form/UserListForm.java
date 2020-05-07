package de.creatronix.artist3k.controller.form;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserListForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Collection users;

	public Collection getUsers() {
		return users;
	}

	public void setUsers(Collection users) {
		this.users = users;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		users = new ArrayList();
	}

}
