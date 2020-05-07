package de.creatronix.artist3k.controller.form;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.Event;


public class EventDetailsForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5083771878743780682L;
	static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
		
	}
	public String getDate() {
		if (event.getDate() != null)
			return calendar2DateString(event.getDate());
		else
			return null;
	}
    public String getEndDate() {
        if (event.getEndDate() != null)
            return calendar2DateString(event.getEndDate());
        else
            return null;
    }
    
	public String getName() {
		return event.getName();
	}

	public String getRegistrationDeadline() {
		if (event.getRegistrationDeadline() != null)
			return calendar2DateString(event.getRegistrationDeadline());
		else
			return null;
	}
	public Calendar dateString2Calendar(String s) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Date d1 = df.parse(s);
		cal.setTime(d1);
		return cal;
	}

	public String calendar2DateString(Calendar cal) {
		return df.format(cal.getTime());
	}
}
