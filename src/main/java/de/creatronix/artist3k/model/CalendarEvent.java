package de.creatronix.artist3k.model;

public class CalendarEvent {
private String type;
private String name;
private String linkAction;
private String status;

    public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	public String getLinkAction() {
	return linkAction;
}

public void setLinkAction(String linkAction) {
	this.linkAction = linkAction;
}

	public void setType(String type) {
       this.type = type;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
