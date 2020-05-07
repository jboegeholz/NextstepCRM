package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;


public class ApplicationJSPTest {
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
	public void testClickAddApplication() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("applicationAdd.do?do=addApplication");
		tester.assertTitleEquals("Bewerbung hinzufuegen");
	}
	@Test
	public void testWriteNewApplication() {
		tester.beginAt("/login.do");
		//we have to log in
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		//we have to add an event we can apply for
		tester.gotoPage("showAdd.do");
		tester.setTextField("name", "Wacken 2010");
		tester.submit();
		//we go to addApplication page and enter the data
		tester.gotoPage("applicationAdd.do?do=addApplication");
		tester.selectOption("bookerName", "Alex");
		tester.selectOption("stageActName", "Excess Pressure");
		tester.selectOption("eventName", "Wacken 2010");
		tester.setTextField("sendDate", "31-03-2010");
		tester.submit();
		tester.assertTitleEquals("Bewerbungen");
		tester.assertTextPresent("Excess Pressure");
		tester.assertTextPresent("Wacken 2010");
		tester.assertTextPresent("31-03-2010");
		tester.clickElementByXPath("//input[@type = 'image'][@alt = 'Delete']");
		tester.assertTextNotPresent("Wacken 2010");
	}
	@Test
	public void testWriteDuplicateApplication() {
		tester.beginAt("/login.do");
		//we have to log in
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();		
		tester.gotoPage("applicationAdd.do?do=addApplication");
		tester.selectOption("bookerName", "Alex");
		tester.selectOption("stageActName", "Excess Pressure");
		tester.selectOption("eventName", "Wacken 2010");
		tester.submit();
		//we go to addApplication page and enter the data
		tester.gotoPage("applicationAdd.do?do=addApplication");
		tester.selectOption("bookerName", "Alex");
		tester.selectOption("stageActName", "Excess Pressure");
		tester.selectOption("eventName", "Wacken 2010");
		tester.submit();
		tester.assertTextPresent("Es existiert bereits eine Bewerbung fuer dieses Event mit diesem Kuenstler!");
		tester.gotoPage("applicationList.do");
		tester.clickLinkWithText("deleteApplication");
		tester.assertTextNotPresent("Wacken 2010");
	}

	
}
