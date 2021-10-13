package pageObjects;

import org.openqa.selenium.WebDriver;

public class AutomationCheckoutLogin extends AutomationLoginPage {

	public AutomationCheckoutLogin(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public AutomationShoppingCartAddress checkoutLogin() {
		clickLogin();
		
		return new AutomationShoppingCartAddress(driver, URL);
	}

}
