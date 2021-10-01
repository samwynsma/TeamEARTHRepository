package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class AutomationViewProductInformationTests extends AutomationPracticeTestBase {
	
	@Test
	public void canViewProductInformation() {
		String[] productInformation = 
				new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressDetails()
				.getProductDetails();
		assertTrue("Product name is incorrect. Obtained " + productInformation[0], productInformation[0].equals("Printed Dress"));
		assertTrue("Product price is incorrect. Obtained " + productInformation[1], productInformation[1].equals("$26.00"));
		assertTrue("Product reviews are incorrect. Obtained " + productInformation[2], productInformation[2].equals("No customer comments for the moment."));
		assertTrue("Product does not have a proper photo." + productInformation[3], !productInformation[3].equals(""));
	}
}
