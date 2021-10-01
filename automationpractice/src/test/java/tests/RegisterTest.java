package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationLoginPage;

public class RegisterTest extends AutomationPracticeTestBase {

	@Test
	public void registrationNeedsEmail() {
		String expected = "Invalid email address.";
		AutomationLoginPage page = new AutomationHomePage(getDriver(), this.baseURL).clickLogin();
		
		page.tryCreateButton();
		
		assertEquals(expected, page.readCreateError());
	}

}
