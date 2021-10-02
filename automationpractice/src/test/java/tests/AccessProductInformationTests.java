package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class AccessProductInformationTests extends AutomationPracticeTestBase {
	
	private final String resultURL = "http://automationpractice.com/index.php?id_product=3&controller=product";
	@Test
	public void canAccessProductInformationByPicture() {
		new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressDetails();
		assertTrue("Urls do not match, final destination was " + this.getDriver().getCurrentUrl(), this.getDriver().getCurrentUrl().equals(resultURL + "&"));
	}
	
	@Test
	public void canAccessProductInformationByProductName() {
		new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressName();
		assertTrue("Urls do not match, final destination was " + this.getDriver().getCurrentUrl(), this.getDriver().getCurrentUrl().equals(resultURL));
	}
}
