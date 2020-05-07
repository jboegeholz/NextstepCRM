package de.creatronix.artist3k.webcontent;

import static org.junit.Assert.assertEquals;
import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class CheckWebStatsTest {
	private static WebTester tester;

	@BeforeClass
	static public void setUp() {
		tester = new WebTester();
		tester.getTestContext().setBaseUrl(
				"http://www.myspace.com");
		// javascript produces error on parsing, disable it!
		tester.getDialog().setScriptingEnabled(false);

	}

	@Test
	public void testLastFMStats() {
		tester.beginAt("excesspressure");
		tester.assertTitleEquals("MySpace.com - Excess Pressure - Coburg, DE - Metal / Progressive - www.myspace.com/excesspressure");
	tester.assertTextPresent("Profilaufrufe:");
	
	}

	@Test
	public void submittingForm() throws Exception {
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_2);
	    webClient.setThrowExceptionOnScriptError(false); 
	    final HtmlPage page1 = (HtmlPage) webClient.getPage("http://www.myspace.com/excesspressure");

	    
	    assertEquals("MySpace.com - Excess Pressure - Coburg, DE - Metal / Progressive - www.myspace.com/excesspressure", page1.getTitleText());
	}

}
