package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import foundations.LoginModule;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationLoginPage;
import pageObjects.AutomationResetPass;

public class ResetPasswordTest extends AutomationPracticeTestBase {

	@Test
	public void needsEmailForReset() {
		final String[] expected = {"http://automationpractice.com/index.php?controller=password", 
				"Invalid email address."};
		
		AutomationResetPass page = new AutomationHomePage(getDriver(), this.baseURL).
				clickLogin().
				clickForgotLink();
		
		assertEquals(expected[0], getDriver().getCurrentUrl());
		
		page.clickRetButton();
		
		assertEquals(expected[1], page.readError());
	}
}
