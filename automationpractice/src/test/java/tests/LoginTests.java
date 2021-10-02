package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationLoginPage;
import pageObjects.AutomationProfilePage;
import foundations.LoginModule;

public class LoginTests extends AutomationPracticeTestBase {

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

	@Test
	public void needsCredentials() {
		final String email = LoginModule.getEmail();
		final String pass = LoginModule.getPass();
		final String[] expected = {"An email address required.", "Password is required."};
		
		AutomationLoginPage page = new AutomationHomePage(getDriver(), this.baseURL).clickLogin();
		
		page.tryLogin();
		
		assertEquals(expected[0], page.readLoginError());
		
		page.findLoginForm();
		
		page.enterEmail(email);
		
		assertEquals(email, page.getEmailField());
		
		page.tryLogin();
		
		assertEquals(expected[1], page.readLoginError());
	}
	
	@Test
	public void canUseLoginModule() {
		String expected = "http://automationpractice.com/index.php";
		
		AutomationHomePage page = LoginModule.login(getDriver(), this.baseURL);
		
		String currentURL = getDriver().getCurrentUrl();
		
		assertEquals(expected, currentURL);
	}
}
