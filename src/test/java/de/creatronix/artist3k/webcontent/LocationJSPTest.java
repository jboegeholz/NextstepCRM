package de.creatronix.artist3k.webcontent;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationJSPTest {
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
	public void testAddLocationWithoutName() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.assertTitleEquals("Veranstaltungsort hinzufügen");
		tester.submit();
		tester.assertTitleEquals("Veranstaltungsort hinzufügen");
		tester.assertTextPresent("Bitte Namen eingeben");
	}

	@Test
	public void testAddLocationWithoutAddress() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.assertTitleEquals("Veranstaltungsort hinzufügen");
		tester.setTextField("name", "myLocation");
		tester.submit();
		tester.assertTitleEquals("Veranstaltungsort hinzufügen");
		tester.assertTextPresent("Bitte eine Strasse angeben");
		tester.assertTextPresent("Bitte eine Hausnummer angeben");
		tester.assertTextPresent("Bitte Postleitzahl angeben");
		tester.assertTextPresent("Bitte Stadt angeben");
	}

	@Test
	public void testAddAndDeleteLocation() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "myLocation");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=myLocation");
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
		tester.assertTextNotPresent("myLocation");
	}

	@Test
	public void testAddDuplicateLocation() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "myLocation");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "myLocation");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.assertTitleEquals("Veranstaltungsort hinzuf�gen");
		tester
				.assertTextPresent("Ein Veranstaltungsort mit diesem Name existiert bereits!");
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=myLocation");
	}
	@Test
	public void testAddLocationsWithSameAddress() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "myLocation1");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "myLocation2");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=myLocation1");
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=myLocation2");
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
	}

	

	@Test
	public void testEditAndSaveLocation() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "Kamp2");
		tester.setTextField("url", "www.myurl.de");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
		tester.assertTextPresent("Kamp2");
		tester.gotoPage("locationEdit.do?do=editLocation&name=Kamp2");
		tester.setTextField("url", "www.mynewurl.de");
		tester.setTextField("locationStreet", "mynewstreet");
		tester.setTextField("locationStreetNo", "mynewstreetno");
		tester.setTextField("locationZipCode", "mynewzipcode");
		tester.setTextField("locationTown", "mynewtown");
		tester.submit();
		tester.gotoPage("locationDetails.do?do=locationDetails&name=Kamp2");
		tester.assertTextPresent("www.mynewurl.de");
		tester.assertTextPresent("mynewstreet");
		tester.assertTextPresent("mynewstreetno");
		tester.assertTextPresent("mynewzipcode");
		tester.assertTextPresent("mynewtown");
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=Kamp2");
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
	}

	@Test
	public void testSaveAndShowLocationDetails() {
		tester.beginAt("/login.do");
		tester.setTextField("username", "Joern");
		tester.setTextField("password", "joern");
		tester.submit();
		tester.gotoPage("showAddLocation.do");
		tester.setTextField("name", "Kamp4");
		tester.setTextField("url", "www.myurl.de");
		tester.setTextField("locationStreet", "mystreet");
		tester.setTextField("locationStreetNo", "mystreetno");
		tester.setTextField("locationZipCode", "myzipcode");
		tester.setTextField("locationTown", "mytown");
		tester.submit();
		tester.assertTitleEquals("Liste der Veranstaltungsorte");
		tester.assertTextPresent("Kamp");
		tester.gotoPage("locationDetails.do?do=locationDetails&name=Kamp4");
		tester.assertTitleEquals("Veranstaltungsortdetails");
		tester.assertTextPresent("Kamp");
		tester.assertTextPresent("www.myurl.de");
		tester.assertTextPresent("mystreet");
		tester.assertTextPresent("mystreetno");
		tester.assertTextPresent("myzipcode");
		tester.assertTextPresent("mytown");
		tester.gotoPage("locationEdit.do?do=deleteLocation&name=Kamp4");
	}
	// //@Test
	// public void testSaveAndShowLocationDetails2() {
	// tester.beginAt("/login.do");
	// tester.setTextField("username", "Joern");
	// tester.setTextField("password", "joern");
	// tester.submit();
	// tester.gotoPage("showAddLocation.do");
	// tester.setTextField("name", "wackenfestivalgel�nde");
	// //tester.setTextField("url", "www.myurl.de");
	// tester.setTextField("locationStreet", "asas");
	// tester.setTextField("locationStreetNo", "asas");
	// tester.setTextField("locationZipCode", "asas");
	// tester.setTextField("locationTown", "asas");
	// tester.submit();
	// tester.assertTitleEquals("Liste der Veranstaltungsorte");
	// //tester.assertTextPresent("wackenfestivalgel�nde");
	// tester.gotoPage("locationDetails.do?do=locationDetails&name=wackenfestivalgel�nde");
	// tester.assertTitleEquals("Veranstaltungsortdetails");
	// tester.assertTextPresent("wackenfestivalgel�nde");
	// //tester.assertTextPresent("www.myurl.de");
	// tester.assertTextPresent("asas");
	// tester.assertTextPresent("asas");
	// tester.assertTextPresent("asas");
	// tester.assertTextPresent("asas");
	// tester.gotoPage("locationEdit.do?do=deleteLocation&name=wackenfestivalgel�nde");
	// }

}
