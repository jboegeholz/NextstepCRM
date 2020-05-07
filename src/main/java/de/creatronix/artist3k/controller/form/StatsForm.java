package de.creatronix.artist3k.controller.form;

import org.apache.struts.action.ActionForm;

public class StatsForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1221076638464408450L;
	int numberOfEvents;
	int numberOfApplications;
	int numberOfStageActs;
	int numberOfLocations;
	public int getNumberOfApplications() {
		return numberOfApplications;
	}
	public void setNumberOfApplications(int numberOfApplications) {
		this.numberOfApplications = numberOfApplications;
	}
	public int getNumberOfEvents() {
		return numberOfEvents;
	}
	public void setNumberOfEvents(int numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}
	public int getNumberOfStageActs() {
		return numberOfStageActs;
	}
	public void setNumberOfStageActs(int numberOfStageActs) {
		this.numberOfStageActs = numberOfStageActs;
	}
	public int getNumberOfLocations() {
		return numberOfLocations;
	}
	public void setNumberOfLocations(int numberOfLocations) {
		this.numberOfLocations = numberOfLocations;
	}
	

}
