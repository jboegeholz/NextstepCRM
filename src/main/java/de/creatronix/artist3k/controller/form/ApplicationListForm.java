package de.creatronix.artist3k.controller.form;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ApplicationListForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4833887439749871392L;
	private Collection applications;

	public Collection getApplications() {
		return applications;
	}


	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		applications = new ArrayList();
	}

	public void setApplications(Collection applications) {
		this.applications = applications;

	}
}
