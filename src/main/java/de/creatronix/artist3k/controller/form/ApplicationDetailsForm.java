package de.creatronix.artist3k.controller.form;

import java.util.Calendar;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.Application;

public class ApplicationDetailsForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3513646988936286271L;
	private Application application;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getAskedForPosterAndFlyerDate() {
		if (application.getAskedForPosterAndFlyerDate() != null)
			return CalendarDateFormatter.calendar2DateString(application
					.getAskedForPosterAndFlyerDate());
		else
			return null;
	}

	public String getSendPosterAndFlyerDate() {
		if (application.getSendPosterAndFlyerDate() != null)
			return CalendarDateFormatter.calendar2DateString(application
					.getSendPosterAndFlyerDate());
		else
			return null;
	}
	public String getDesiredDate() {
		if (application.getDesiredDate() != null)
			return CalendarDateFormatter.calendar2DateString(application
					.getDesiredDate());
		else
			return null;
	}

	public String getSendDate() {
		if (application.getSendDate() != null)
			return CalendarDateFormatter.calendar2DateString(application
					.getSendDate());
		else
			return null;
	}
}
