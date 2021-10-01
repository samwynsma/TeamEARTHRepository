package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationLoginPage;
import pageObjects.AutomationProfilePage;
import foundations.LoginModule;

public class LoginTest extends AutomationPracticeTestBase {

	@Test
	public void canLogin() {
		final String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		final String email = LoginModule.getEmail();
		final String pass = LoginModule.getPass();
		
		AutomationLoginPage page = new AutomationHomePage(getDriver(), this.baseURL).clickLogin();
		
		page.enterEmail(email);
		
		assertEquals(email, page.getEmailField());
		
		page.enterPass(pass);
		
		assertEquals(pass, page.getPassField());
		
		AutomationProfilePage page2 = page.login();
		
		String currentURL = getDriver().getCurrentUrl();
		
		assertEquals(expectedURL, currentURL);
	}

}
