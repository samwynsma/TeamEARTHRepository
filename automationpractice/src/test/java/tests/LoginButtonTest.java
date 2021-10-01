package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class LoginButtonTest extends AutomationPracticeTestBase {

	
	@Test 
	public void canFindButton() {
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		
		AutomationHomePage page = new AutomationHomePage(getDriver(), this.baseURL);
		
		WebElement loginButton = page.getLoginButton();
		
		loginButton.click();
		
		String currentURL = getDriver().getCurrentUrl();
		
		assertEquals(expectedURL, currentURL);
	}
}
