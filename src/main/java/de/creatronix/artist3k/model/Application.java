package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Application implements Serializable {
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Application) {

			Application app2 = (Application) obj;
			if (this.stageAct.getName().equals(app2.getStageAct().getName())) {
				if (event != null && app2.getEvent() != null) {
					if (event.getName().equals(app2.getEvent().getName())) {
						return true;
					} else {
						return false;
					}
				} else if (location != null && app2.getLocation() != null)
					if (location.getName().equals(app2.getLocation().getName())) {
						return true;
					} else {
						return false;
					}
				else
					return false;
			} else
				return false;
		} else
			return false;

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7219416935299099014L;
	private Long id;
	private User booker;
	private StageAct stageAct;
	private Calendar sendDate;
	private Calendar askedForPosterAndFlyerDate;
	private Calendar sendPosterAndFlyerDate;
	private String numberOfSentPosters;
	private String numberOfSentFlyers;
	private Event event;
	private Location location;
	private String status = "unklar / offen";
	private Calendar desiredDate;
	private BigDecimal demandedFee;
	private BigDecimal transportationCosts;
	private BigDecimal lodgingCosts;
	private BigDecimal receivedFee;
	private BigDecimal receivedExpenses;
	private String comment;
	

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getDemandedFee() {
		return demandedFee;
	}

	public void setDemandedFee(BigDecimal demandedFee) {
		this.demandedFee = demandedFee;
	}


	public User getBooker() {
		return booker;
	}

	public void setBooker(User booker) {
		this.booker = booker;
	}

	public StageAct getStageAct() {
		return stageAct;
	}

	public void setStageAct(StageAct stageAct) {
		this.stageAct = stageAct;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public Calendar getSendDate() {
		return sendDate;
	}

	public void setSendDate(Calendar sendDate) {
		this.sendDate = sendDate;
	}

	public String getFormattedSendDate() {
		if (sendDate != null) {
			return new SimpleDateFormat("dd-MM-yyyy").format(getSendDate()
					.getTime());
		} else {
			return null;
		}
	}

	public Calendar getAskedForPosterAndFlyerDate() {
		return askedForPosterAndFlyerDate;
	}

	public void setAskedForPosterAndFlyerDate(Calendar askedForPosterAndFlyerDate) {
		this.askedForPosterAndFlyerDate = askedForPosterAndFlyerDate;
	}

	public Calendar getSendPosterAndFlyerDate() {
		return sendPosterAndFlyerDate;
	}

	public void setSendPosterAndFlyerDate(Calendar sendPosterAndFlyerDate) {
		this.sendPosterAndFlyerDate = sendPosterAndFlyerDate;
	}

	public String getNumberOfSentPosters() {
		return numberOfSentPosters;
	}

	public void setNumberOfSentPosters(String numberOfSentPosters) {
		this.numberOfSentPosters = numberOfSentPosters;
	}

	public String getNumberOfSentFlyers() {
		return numberOfSentFlyers;
	}

	public void setNumberOfSentFlyers(String numberOfSentFlyers) {
		this.numberOfSentFlyers = numberOfSentFlyers;
	}

	public BigDecimal getTransportationCosts() {
		return transportationCosts;
	}

	public void setTransportationCosts(BigDecimal transportationCosts) {
		this.transportationCosts = transportationCosts;
	}

	public BigDecimal getLodgingCosts() {
		return lodgingCosts;
	}

	public void setLodgingCosts(BigDecimal lodgingCosts) {
		this.lodgingCosts = lodgingCosts;
	}

	public BigDecimal getReceivedFee() {
		return receivedFee;
	}

	public void setReceivedFee(BigDecimal receivedFee) {
		this.receivedFee = receivedFee;
	}

	public BigDecimal getReceivedExpenses() {
		return receivedExpenses;
	}

	public void setReceivedExpenses(BigDecimal receivedExpenses) {
		this.receivedExpenses = receivedExpenses;
	}

	public Calendar getDesiredDate() {
		return desiredDate;
	}

	public void setDesiredDate(Calendar desiredDate) {
		this.desiredDate = desiredDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
