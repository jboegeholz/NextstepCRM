package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event implements Serializable, Comparable<Event> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name = "";
    private String url = "";
    private String typeOfAsset = "";
    private Calendar date = null;
    private Calendar endDate = null;
    private Calendar registrationDeadline = null;
    private Organizer organizer;
    private Location location;

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Event() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfAsset() {
        return typeOfAsset;
    }

    public void setTypeOfAsset(String typeOfAsset) {
        this.typeOfAsset = typeOfAsset;
    }

    public Calendar getDate() {
        return date;
    }

    public String getFormattedDate() {
        if (date != null) {
            return new SimpleDateFormat("dd-MM-yyyy").format(getDate().getTime());
        } else
        {
            return null;
        }
    }
    public String getFormattedEndDate() {
        if (endDate != null) {
            return new SimpleDateFormat("dd-MM-yyyy").format(getEndDate().getTime());
        } else
        {
            return null;
        }
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getRegistrationDeadline() {
        return registrationDeadline;
    }

    public String getFormattedRegistrationDeadline() {
        if (registrationDeadline != null) {
            return new SimpleDateFormat("dd-MM-yyyy").format(getRegistrationDeadline().getTime());
        } else
        {
            return null;
        }
    }

    public void setRegistrationDeadline(Calendar registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int compareTo(Event o) {
		return this.name.compareTo(o.getName());
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

}
