package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;

public class AddToShoppingCartTests extends AutomationPracticeTestBase {

	@Test
	public void addToShoppingCartFromProductDetailsTest() {
		String productName = new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressDetails()
				.addToCart()
				.viewCart()
				.verifyItemPresent();
		assertTrue("Printed Dress".equals(productName));
	}

}
