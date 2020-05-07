package de.creatronix.artist3k.webcontent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;

public class AddTestData {
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
	public void testAddLocation() {
		final String DATAFILE = "location.csv";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DATAFILE));
			String line;
			String locationName; 
			String locationUrl;
			String locationStreet;
			String locationStreetNo;
			String locationZipCode;
			String locationTown;
			String locationCountry;
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				 locationName = tokenizer.nextToken(); 
				 locationUrl  = tokenizer.nextToken(); 
				 locationStreet = tokenizer.nextToken(); 
				 locationStreetNo = tokenizer.nextToken(); 
				 locationZipCode = tokenizer.nextToken(); 
				 locationTown = tokenizer.nextToken(); 
				 locationCountry = tokenizer.nextToken(); 
				tester.beginAt("/login.do");
				tester.setTextField("username", "Joern");
				tester.setTextField("password", "joern");
				tester.submit();
				tester.gotoPage("showAddLocation.do");
				tester.setTextField("name", locationName);
				tester.setTextField("url", locationUrl);
				tester.setTextField("locationStreet", locationStreet);
				tester.setTextField("locationStreetNo", locationStreetNo);
				tester.setTextField("locationZipCode", locationZipCode);
				tester.setTextField("locationTown", locationTown);
				//tester.setTextField("locationCountry", locationCountry);
				tester.submit();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
