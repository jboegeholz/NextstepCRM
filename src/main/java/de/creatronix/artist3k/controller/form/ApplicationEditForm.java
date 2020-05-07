package de.creatronix.artist3k.controller.form;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collection;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.Application;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.Location;
import de.creatronix.artist3k.model.StageAct;
import de.creatronix.artist3k.model.User;

public class ApplicationEditForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -880554331576378228L;
	private Application application = new Application();
	private String bookerName;
	private String stageActName;
	private String eventName;
	private String locationName;
	private Collection<User> allUser;
	private Collection<StageAct> allStageActs;
	private Collection<Event> allEvents;
	private Collection<Location> allLocations;
	private Collection<String> applicationStati;

	public Long getId() {
		return application.getId();
	}
	public void setId(Long id) {
		application.setId(id);
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public void setAllUser(Collection<User> allUser) {
		this.allUser = allUser;
		
	}
	public void setAllStageActs(Collection<StageAct> allStageActs) {
		this.allStageActs = allStageActs;
		
	}
	public void setAllEvents(Collection<Event> allEvents) {
		this.allEvents = allEvents;
		
	}
	public void setAllLocations(Collection<Location> allLocations) {
		this.allLocations = allLocations;
		
	}
	public String getBookerName() {
		return bookerName;
	}
	public void setBookerName(String bookerName) {
		this.bookerName = bookerName;
	}
	public String getStageActName() {
		return stageActName;
	}
	public void setStageActName(String stageActName) {
		this.stageActName = stageActName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Collection<User> getAllUser() {
		return allUser;
	}
	public Collection<StageAct> getAllStageActs() {
		return allStageActs;
	}
	public Collection<Event> getAllEvents() {
		return allEvents;
	}
	public Collection<Location> getAllLocations() {
		return allLocations;
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
	public void setSendDate(String sendDate) {
		try {
			application
					.setSendDate(CalendarDateFormatter.dateString2Calendar(sendDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDesiredDate(String desiredDate) {
		try {
			application
					.setDesiredDate(CalendarDateFormatter.dateString2Calendar(desiredDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setAskedForPosterAndFlyerDate(String askedForPosterAndFlyerDate) {
		try {
			application
					.setAskedForPosterAndFlyerDate(CalendarDateFormatter.dateString2Calendar(askedForPosterAndFlyerDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSendPosterAndFlyerDate(String sendPosterAndFlyerDate) {
		try {
			application
					.setSendPosterAndFlyerDate(CalendarDateFormatter.dateString2Calendar(sendPosterAndFlyerDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDemandedFee(String demandedFee) {
		if (demandedFee.matches("[0-9]+")) {
			application.setDemandedFee(new BigDecimal(demandedFee));
		} else
			application.setDemandedFee(new BigDecimal(0));
	}

	public void setLodgingCosts(String lodgingCosts) {
		if (lodgingCosts.matches("[0-9]+"))
			application.setLodgingCosts(new BigDecimal(lodgingCosts));
		else
			application.setLodgingCosts(new BigDecimal(0));
	}

	public void setReceivedExpenses(String receivedExpenses) {
		if (receivedExpenses.matches("[0-9]+"))
			application.setReceivedExpenses(new BigDecimal(receivedExpenses));
		else
			application.setReceivedExpenses(new BigDecimal(0));
	}

	public void setReceivedFee(String receivedFee) {
		if (receivedFee.matches("[0-9]+"))
			application.setReceivedFee(new BigDecimal(receivedFee));
		else
			application.setReceivedFee(new BigDecimal(0));
	}

	public void setTransportationCosts(String transportationCosts) {
		if (transportationCosts.matches("[0-9]+"))
			application.setTransportationCosts(new BigDecimal(transportationCosts));
		else
			application.setTransportationCosts(new BigDecimal(0));
	}

	public void setNumberOfSentFlyers(String numberOfSentFlyers) {
		application.setNumberOfSentFlyers(numberOfSentFlyers);
	}

	public void setNumberOfSentPosters(String numberOfSentPosters) {
		application.setNumberOfSentPosters(numberOfSentPosters);
	}
	public String getStatus() {
		return application.getStatus();
	}
	public void setStatus(String status) {
		application.setStatus(status);
	}
	public Collection<String> getApplicationStati() {
		return applicationStati;
	}
	public void setApplicationStati(Collection<String> applicationStati) {
		this.applicationStati = applicationStati;
	}
	public String getDemandedFee() {
		return application.getDemandedFee().toString();
	}
	public String getLodgingCosts() {
		return application.getLodgingCosts().toString();
	}
	public String getReceivedExpenses() {
		return application.getReceivedExpenses().toString();
	}
	public String getReceivedFee() {
		return application.getReceivedFee().toString();
	}
	public String getTransportationCosts() {
		return application.getTransportationCosts().toString();
	}

	public String toString() {
		return application.toString();
	}
	public String getComment() {
		return application.getComment();
	}
	public void setComment(String comment) {
		application.setComment(comment);
	}
}
