package de.creatronix.artist3k.controller.form;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class StageActListForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5043003352714785335L;
	private Collection stageActs;

	public Collection getStageActs() {
		return stageActs;
	}

	public void setStageActs(Collection stageActs) {
		this.stageActs = stageActs;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		stageActs = new ArrayList();
	}
}
