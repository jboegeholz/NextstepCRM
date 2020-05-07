package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;


public class CalendarDayJSPTest {
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
	public void testEventPresentInCalendar() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2009");
		tester.setTextField("date", "01-01-2009");
		tester.submit();
		tester.clickLinkWithText("Kalendar");
		tester.selectOption("selectedMonth", "Januar");
		tester.selectOption("selectedYear", "2009");
		tester.submit();
		tester.clickLinkWithText("1");
		tester.assertTextPresent("Wacken 2009");
	}
	@Test
	public void testRegDeadlinePresentInCalendar() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2010");
		tester.setTextField("registrationDeadline", "01-01-2009");
		tester.submit();
		tester.clickLinkWithText("Kalendar");
		tester.selectOption("selectedMonth", "Januar");
		tester.selectOption("selectedYear", "2009");
		tester.submit();
		tester.clickLinkWithText("1");
		tester.assertTextPresent("AMS: Wacken 2010");
	}
}
