package de.creatronix.artist3k.controller.form;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.CalendarEvent;

public class CalendarForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1115210805375973618L;
	private static String[] monthNames = { "", "january", "february", "march",
			"april", "may", "june", "july", "august", "september", "october",
			"november", "december" };
	private static String[] dayNames = { "", "monday", "tuesday", "wednesday",
			"thursday", "friday", "saturday", "sunday" };
	private int daysInMonth;
	private int monthStart;
	private int selectedMonth;
	private int selectedYear;
	private int selectedDay;

	ArrayList<HashSet<CalendarEvent>> testSetsSet;

	public CalendarForm() {
		this.testSetsSet = new ArrayList<HashSet<CalendarEvent>>();
	}

	public int getSelectedYear() {
		return selectedYear;
	}

	public int getSelectedDay() {
		return selectedDay;
	}

	public void setSelectedDay(int selectedDay) {
		this.selectedDay = selectedDay;
	}

	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}

	public int getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(int selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public int getDaysInMonth() {
		return daysInMonth;
	}

	public void setDaysInMonth(int daysInMonth) {
		this.daysInMonth = daysInMonth;
	}

	public int getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(int monthStart) {
		this.monthStart = monthStart;
	}

	public ArrayList<HashSet<CalendarEvent>> getTestSetsSet() {
		return testSetsSet;
	}

	public void setTestSetsSet(ArrayList<HashSet<CalendarEvent>> testSetsSet) {
		this.testSetsSet = testSetsSet;
	}

	public String[] getMonthNames() {
		return monthNames;
	}

	public String[] getDayNames() {
		return dayNames;
	}
}
