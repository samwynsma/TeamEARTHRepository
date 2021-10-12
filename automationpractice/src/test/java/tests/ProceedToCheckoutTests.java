package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import foundations.LoginModule;
import pageObjects.*;

public class ProceedToCheckoutTests extends AutomationPracticeTestBase {

	@Test
	public void canProceedToCheckoutWithItems() {
		
		String expectedURL = "http://automationpractice.com/index.php?controller=order&step=1";
		
		AutomationProductListingPage page = LoginModule.login(getDriver(), this.baseURL).
				clickDressesButton();
		
		AutomationShoppingCartSummary page2 = page.addPrintedDressToCart();
		
		AutomationShoppingCartAddress page3 = page2.clickProceedButton();
		
		String currentURL = getDriver().getCurrentUrl();
		
		assertEquals(expectedURL, currentURL);
	}
	
	@Test
	public void checkoutNeedsItems() {
		String expected = "Your shopping cart is empty.";
		
		AutomationShoppingCartSummary page = new AutomationHomePage(getDriver(), this.baseURL).clickCart();
		
		String actual = page.getWarning();
		
		assertEquals(expected, actual);
	}
}
