package tests;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class AutomationViewProductInformationTests extends AutomationPracticeTestBase {
	
	@Test
	public void canViewProductInformation() {
		String productInformation = 
				new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressDetails()
				.getProductDetails();
	}
	// Xpaths:
	// Automation Home Page
}
