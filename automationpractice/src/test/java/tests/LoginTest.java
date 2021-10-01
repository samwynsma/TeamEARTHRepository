package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class LoginTest extends AutomationPracticeTestBase {

	@Test
	public void canLogin() {
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		
		AutomationHomePage page = new AutomationHomePage(getDriver(), this.baseURL);
	}

}
