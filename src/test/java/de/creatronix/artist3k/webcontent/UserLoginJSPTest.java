package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserLoginJSPTest {
	private static WebTester tester;

	@BeforeClass
	static public void setUp() {
		tester = new WebTester();
		tester.getTestContext().setBaseUrl(
				"http://localhost:8080/nextstep-booking");
	}

	@Test
	public void testUserLogin() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.assertTitleEquals("Startseite");
	}
	@Test
	public void testWrongUserLogin() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "bla");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.assertTitleEquals("Login");
		tester.assertTextPresent("Username und / oder Passwort falsch!");
	}

	@Test
	public void testUserLogout() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.assertLinkPresentWithText("Log off");
		tester.clickLinkWithText("Log off");
		tester.assertTitleEquals("Login");

	}

}
