package de.creatronix.artist3k.controller.form;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.User;

public class UserAddForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3731829191857761363L;
	private User user = new User();
	public void setPassword(String password) {
		user.setPassword(password);
	}
	public void setUsername(String username) {
		user.setUsername(username);
	}
	public User getUser() {
		return user;
	}

}
