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
	
	@Test
	public void canLoginForCheckout() {
		final String email = LoginModule.getEmail();
		final String pass = LoginModule.getPass();
		String expectedURL = "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0";
		
		AutomationProductListingPage page = new AutomationHomePage(getDriver(), this.baseURL).clickDressesButton();
		
		AutomationShoppingCartSummary page2 = page.addPrintedDressToCart();
		
		page2.clickProceedButton();
		
		AutomationCheckoutLogin page3 = new AutomationCheckoutLogin(getDriver(), this.baseURL);
		
		page3.enterEmail(email);
		
		assertEquals(email, page3.getEmailField());
		
		page3.enterPass(pass);
		
		assertEquals(pass, page3.getPassField());
		
		AutomationShoppingCartAddress page4 = page3.checkoutLogin();
		
		String currentURL = getDriver().getCurrentUrl();
		
		assertEquals(expectedURL, currentURL);
	}
	
	@Test
	public void needsLoginForCheckout() {
		final String email = LoginModule.getEmail();
		final String[] expected = {"An email address required.", "Password is required."};
		
		AutomationProductListingPage page = new AutomationHomePage(getDriver(), this.baseURL).clickDressesButton();
		
		AutomationShoppingCartSummary page2 = page.addPrintedDressToCart();
		
		page2.clickProceedButton();
		
		AutomationCheckoutLogin page3 = new AutomationCheckoutLogin(getDriver(), this.baseURL);
		
		page3.tryLogin();
		
		assertEquals(expected[0], page3.readLoginError());
		
		page3.findLoginForm();
		
		page3.enterEmail(email);
		
		assertEquals(email, page3.getEmailField());
		
		page3.tryLogin();
		
		assertEquals(expected[1], page3.readLoginError());
	}
}
