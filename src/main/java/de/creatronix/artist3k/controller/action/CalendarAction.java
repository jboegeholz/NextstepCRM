package de.creatronix.artist3k.controller.action;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import de.creatronix.artist3k.controller.form.CalendarForm;
import de.creatronix.artist3k.exception.ApplicationAlreadyExistsException;
import de.creatronix.artist3k.exception.OffDayAlreadyExistsException;
import de.creatronix.artist3k.model.Application;
import de.creatronix.artist3k.model.ApplicationManager;
import de.creatronix.artist3k.model.CalendarEvent;
import de.creatronix.artist3k.model.CalendarManager;
import de.creatronix.artist3k.model.Event;
import de.creatronix.artist3k.model.EventManager;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.OffDay;
import de.creatronix.artist3k.model.User;
import de.creatronix.artist3k.model.UserManager;

public class CalendarAction extends DispatchAction {

	public ActionForward showMonth(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CalendarForm calendarForm = (CalendarForm) form;
		Calendar today = Calendar.getInstance();
		int aMonth = calendarForm.getSelectedMonth();
		int aYear = calendarForm.getSelectedYear();

		if (aMonth == 0) { // if no month provided, use current month
			aMonth = today.get(Calendar.MONTH) + 1;
		} else { // if month provided, make sure it's a value between 0 and
			// 11 inclusive
			if (aMonth < 1 || aMonth > 12) { // if
				// not,use current month
				aMonth = today.get(Calendar.MONTH) + 1;
			}
		}

		if (aYear == 0) { // if no year provided ,use current year
			aYear = today.get(Calendar.YEAR);
		} else { // if year provided, make sure it's not a negative number
			if (aYear <= 0) { // if negative or zero, use
				// current year
				aYear = today.get(Calendar.YEAR);
			}
		}
		// clean up after ourselves
		today = null;
		calendarForm.setDaysInMonth(SimpleCalendar.daysInMonth(aMonth, aYear));
		calendarForm.setMonthStart(SimpleCalendar.monthStart(aMonth, aYear));
		calendarForm.setSelectedMonth(aMonth);
		calendarForm.setSelectedYear(aYear);
		// insert all events in selected month into list
		calendarForm.getTestSetsSet().clear();
		Calendar cal = Calendar.getInstance();
		EventManager eventManager = ModelController.getInstance()
				.getEventManager();
		CalendarManager calManager = ModelController.getInstance()
				.getCalendarManager();
		ApplicationManager appManager = ModelController.getInstance()
				.getApplicationManager();
		// first we need a set per Day
		for (int day = 0; day < calendarForm.getDaysInMonth(); day++) {
			calendarForm.getTestSetsSet().add(new HashSet<CalendarEvent>());

		}
		for (int day = 0; day < calendarForm.getDaysInMonth(); day++) {
			cal.set(calendarForm.getSelectedYear(), calendarForm
					.getSelectedMonth() - 1, day + 1);
			System.out.println(cal);
			getAllCalendarEventsForMonth(calendarForm, cal, eventManager, calManager,
					appManager, day);
		}

		return mapping.findForward("showMonth");

	}

	private void getAllCalendarEventsForMonth(CalendarForm calendarForm, Calendar cal,
			EventManager eventManager, CalendarManager calManager,
			ApplicationManager appManager, int day) {
		// fetch all calendar items by date
		List<Event> list = eventManager.loadEventsByDate(cal);
		List<Event> list2 = eventManager
				.loadEventsByRegistrationDeadline(cal);
		List<OffDay> list3 = calManager.loadOffDaysByDate(cal);
		List<Application> list4 = appManager.loadApplicationByDate(cal);
		// transform calendar items to CalendaEvents

		for (Iterator<Event> iterator = list.iterator(); iterator.hasNext();) {
			Event event = (Event) iterator.next();
			CalendarEvent calEvent = new CalendarEvent();
			calEvent.setName(event.getName());
			calEvent.setType("Event");
			calEvent.setLinkAction("eventDetails.do?do=eventDetails");
			// we need more entries if event has many days
			if (event.getEndDate() != null) {
				int duration = event.getEndDate().get(Calendar.DAY_OF_WEEK)
						- event.getDate().get(Calendar.DAY_OF_WEEK);
				if (duration > 0) {
					for (int i = 0; i < duration; i++) {
						calendarForm.getTestSetsSet().get(day + i).add(
								calEvent);
					}
				}
			} else {
				calendarForm.getTestSetsSet().get(day).add(calEvent);
			}

		}
		for (Iterator<Event> iterator = list2.iterator(); iterator
				.hasNext();) {
			Event event = (Event) iterator.next();
			CalendarEvent calEvent = new CalendarEvent();
			calEvent.setName(event.getName());
			calEvent.setType("AMS");
			calEvent.setLinkAction("eventDetails.do?do=eventDetails");
			calendarForm.getTestSetsSet().get(day).add(calEvent);
		}
		for (Iterator<OffDay> iterator = list3.iterator(); iterator
				.hasNext();) {
			OffDay offDay = (OffDay) iterator.next();
			CalendarEvent calEvent = new CalendarEvent();
			calEvent.setName(offDay.getUser().getUsername());
			calEvent.setType("OffDay");
			calendarForm.getTestSetsSet().get(day).add(calEvent);
		}
		for (Iterator<Application> iterator = list4.iterator(); iterator
				.hasNext();) {
			Application app = (Application) iterator.next();
			CalendarEvent calEvent = new CalendarEvent();
			calEvent.setName(app.getLocation().getName());
			calEvent.setType("Initiativ");
			calEvent
					.setLinkAction("applicationDetails.do?do=applicationDetails&id="
							+ app.getId());
			calEvent.setStatus(app.getStatus());
			calendarForm.getTestSetsSet().get(day).add(calEvent);
		}
	}

	public ActionForward showDay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CalendarForm calendarForm = (CalendarForm) form;
		System.out.println(request.getParameter("day"));
		calendarForm.setSelectedDay(Integer.parseInt(request
				.getParameter("day")));

		// insert all events in selected day into list
		calendarForm.getTestSetsSet().clear();
		Calendar cal = Calendar.getInstance();
		EventManager eventManager = ModelController.getInstance()
				.getEventManager();
		CalendarManager calManager = ModelController.getInstance()
				.getCalendarManager();
		ApplicationManager appManager = ModelController.getInstance()
		.getApplicationManager();
		HashSet<CalendarEvent> testSet1 = null;

//		cal.set(calendarForm.getSelectedYear(),
//				calendarForm.getSelectedMonth() - 1, Integer.parseInt(request
//						.getParameter("day")));
//		System.out.println(cal);
//		getAllCalendarEvents(calendarForm, cal, eventManager, calManager,
//				appManager, 0);
//		calendarForm.getTestSetsSet().add(testSet1);

		return mapping.findForward("showDay");

	}

	public ActionForward addOffDay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		CalendarForm calendarForm = (CalendarForm) form;
		System.out.println("addOffDay" + calendarForm.getSelectedDay()
				+ calendarForm.getSelectedMonth()
				+ calendarForm.getSelectedYear());

		CalendarManager calManager = ModelController.getInstance()
				.getCalendarManager();
		OffDay offDay = new OffDay();
		offDay.setUser((User) request.getSession().getAttribute("user"));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, calendarForm.getSelectedYear());
		cal.set(Calendar.MONTH, calendarForm.getSelectedMonth() - 1); // month
		// is
		// zero
		// based
		cal.set(Calendar.DAY_OF_MONTH, calendarForm.getSelectedDay());
		offDay.setOffDay(cal);
		try {
			System.out.println(offDay.getOffDay().get(Calendar.YEAR) + " "
					+ offDay.getOffDay().get(Calendar.MONTH) + " "
					+ offDay.getOffDay().get(Calendar.DAY_OF_MONTH));
			calManager.saveToDB(offDay);
		} catch (OffDayAlreadyExistsException e) {
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("event.already.exists");
			errors.add("message1", msg);
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		return mapping.findForward("showUpdatedMonth");
	}

}
