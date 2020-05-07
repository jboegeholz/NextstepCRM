package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;


public class OffDayTest {
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
	public void testAddOffDayInCalendar() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.clickLinkWithText("Kalendar");
		tester.selectOption("selectedDay", "1");
		tester.selectOption("selectedMonth", "Januar");
		tester.selectOption("selectedYear", "2009");
		tester.submit();
		tester.assertTextPresent("Januar 2009");
		tester.assertTextPresent("OffDay: Joern");
	}
	@Test
	public void testAddDuplicateOffDayInCalendar() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.clickLinkWithText("Kalendar");
		tester.selectOption("selectedDay", "1");
		tester.selectOption("selectedMonth", "Januar");
		tester.selectOption("selectedYear", "2009");
		tester.submit();
		tester.assertTextPresent("Du hast schon einen OffDay an diesem Tag :-)");
	}
}
