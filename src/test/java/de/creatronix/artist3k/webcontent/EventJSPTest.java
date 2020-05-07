package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;

public class EventJSPTest {
	private static WebTester tester;

	@BeforeClass
	static public void setUp() {
		tester = new WebTester();
		tester.getTestContext().setBaseUrl(
				"http://localhost:8080/de.creatronix.artist3k");
		// javascript produces error on parsing, disable it!
		tester.getDialog().setScriptingEnabled(false);
	}

	@Test
	public void testAddAndDeleteEvent() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2009");
		tester.submit();
		tester.assertTitleEquals("Eventliste");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=Wacken+2009");
		tester.assertTitleEquals("Eventliste");
	}
	@Test
	public void testEventProperties() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2009");
		tester.setTextField("url", "http://www.wacken.com/de");
		tester.submit();
		tester.assertTitleEquals("Eventliste");
		tester.assertTextPresent("http://www.wacken.com/de");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=Wacken+2009");
		tester.assertTitleEquals("Eventliste");
	}

	@Test
	public void testAddDuplicateEvent() {
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2009");
		tester.submit();
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2009");
		tester.submit();
		tester.assertTitleEquals("Event hinzufügen");
		tester
				.assertTextPresent("Ein Event mit diesem Name existiert bereits!");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=Wacken+2009");

	}

	@Test
	public void testAddEventWithoutName() {
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "");
		tester.submit();
		tester.assertTitleEquals("Event hinzufügen");
		tester.assertTextPresent("Bitte Namen eingeben");
	}

	@Test
	public void testRegDeadlineAfterDate() {
		// error when reg deadline is after date of event
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.setTextField("date", "01-01-2008");
		tester.setTextField("registrationDeadline", "01-01-2009");
		tester.submit();
		tester.assertTitleEquals("Event hinzufügen");
		tester
				.assertTextPresent("Die Bewerbungsfrist liegt zeitlich hinter dem Termin!");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=myevent");
	}

	@Test
	public void testRegDeadlineEqualsDate() {
		// error when reg deadline is after date of event
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.setTextField("date", "01-01-2008");
		tester.setTextField("registrationDeadline", "01-01-2008");
		tester.submit();
		tester.assertTitleEquals("Event hinzufügen");
		tester
				.assertTextPresent("Die Bewerbungsfrist liegt zeitlich hinter dem Termin!");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=myevent");
	}

	@Test
	public void testEditDate() {
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=editEvent&name=myevent");
		tester.assertTitleEquals("Event bearbeiten");
		tester.setTextField("date", "01-01-2008");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=myevent");
	}

	@Test
	public void testAddLocationToEvent() {
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.assertTitleEquals("Veranstaltungsort hinzuf�gen");
		tester.setTextField("name", "Fronte 79");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=editEvent&name=myevent");
		tester.selectOption("locationName", "Fronte 79");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=myevent");
	}
	@Test
	public void testChangeLocation() {
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=editEvent&name=myevent");
		tester.selectOption("locationName", "Fronte 79");
		tester.submit();
		tester.gotoPage("eventEdit.do?do=editEvent&name=myevent");
		tester.selectOption("locationName", "Fronte 79");
		tester.assertTextPresent("Veranstaltungsort aendern von: Fronte 79 nach:");
		tester.gotoPage("eventEdit.do?do=deleteEvent&name=myevent");
	}
	@Test
	public void testUpdateEventAndAddLocation() {
		//add new Event
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "myevent");
		tester.submit();
		//edit event and add a new  location
		tester.gotoPage("eventEdit.do?do=editEvent&name=myevent");
		tester.clickLinkWithText("Neuer Veranstaltungsort");
		tester.assertTitleEquals("Veranstaltungsort hinzuf�gen");
		
		
	}

}
