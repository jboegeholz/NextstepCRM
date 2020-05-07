package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;


public class MainNavJSPTest {
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
	public void testMainNavStats() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.clickLinkWithText("Statistiken");
		tester.assertTitleEquals("Stats");
	}
	@Test
	public void testMainNavUser() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.clickLinkWithText("User");
		tester.assertTitleEquals("User verwalten");
	}
	@Test
	public void testMainNavLocation() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("/locationList.do");
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
	}
	@Test
	public void testMainNavOrganizer() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("/organizerList.do");
		tester.assertTitleEquals("Liste der Veranstalter");
	}
	@Test
	public void testMainNavApplication() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("/applicationList.do");
		tester.assertTitleEquals("Bewerbungen");
	}
}
