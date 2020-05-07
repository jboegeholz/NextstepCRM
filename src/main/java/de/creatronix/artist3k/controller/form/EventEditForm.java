package de.creatronix.artist3k.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import de.creatronix.artist3k.model.Address;
import de.creatronix.artist3k.model.ContactDetails;
import de.creatronix.artist3k.model.ContactPerson;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.Location;

public class EventEditForm extends ValidatorForm {
    /**
     *
     */
    private static final long serialVersionUID = -5487537475748844482L;
    static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Event event = new Event();
    String locationName;
    String organizerName;
    private Collection locations;
    
    private Collection organizers;

    public Collection getLocations() {
        return this.locations;
    }

    public EventEditForm() {
    }

    private Collection users = new ArrayList();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event Event) {
        this.event = Event;
    }

    public boolean equals(Object arg0) {
        return event.equals(arg0);
    }

    public String toString() {
        return event.toString();
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

    public String getTypeOfAsset() {
        return event.getTypeOfAsset();
    }

    public int hashCode() {
        return event.hashCode();
    }

    public void setDate(String date) {

        try {
            event.setDate(dateString2Calendar(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void setEndDate(String endDate) {

        try {
            event.setEndDate(dateString2Calendar(endDate));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        event.setName(name);
    }

    public void setRegistrationDeadline(String registrationDeadline) {
        try {
            event
                    .setRegistrationDeadline(dateString2Calendar(registrationDeadline));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setTypeOfAsset(String typeOfAsset) {
        event.setTypeOfAsset(typeOfAsset);
    }

    public void setUsers(Collection allUsers) {
        this.users = allUsers;

    }

    public Collection getUsers() {
        return users;
    }

    public Location getLocation() {
        return event.getLocation();
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

    public void setLocations(Collection<Location> allLocations) {
        this.locations = allLocations;

    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if (event.getName() == null || event.getName().trim().equals("")) {
            errors.add("name", new ActionMessage("error.name.required"));
        }
        if((event.getRegistrationDeadline() != null) && (event.getDate() != null))
        {
            if (event.getRegistrationDeadline().after(event.getDate())
               || event.getRegistrationDeadline().equals(event.getDate())) {
                errors.add("date", new ActionMessage("error.regdeadline.after.date"));
            }
        }

        return errors;
    }

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		locationName = null;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public Collection getOrganizers() {
		return organizers;
	}

	public void setOrganizers(Collection organizers) {
		this.organizers = organizers;
	}

	public String getUrl() {
		return event.getUrl();
	}

	public void setUrl(String url) {
		event.setUrl(url);
	}

}