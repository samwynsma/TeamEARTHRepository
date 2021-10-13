package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import foundations.LoginModule;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationWishlistListingPage;

public class AddToWishlistTests extends AutomationPracticeTestBase {

	@Test
	public void canAddToWishlist() {
		LoginModule.login(this.getDriver(), this.baseURL);
		AutomationWishlistListingPage wishlistPage = new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressName()
				.addToWishlist()
				.clickOnUsername()
				.viewWishlist()
				.clickOnWishlistName();
		String wishlistItem = wishlistPage.viewFirstItemName();
		assertTrue("Wrong product name. Actual product name is " + wishlistItem, wishlistItem.equals("Printed Dress\nS, Orange"));
		
		wishlistPage.deleteCurrentWishlist();
	}
	
	@Test
	public void cannotAddToWishlistUnlessLoggedIn() {
		String wishlistErrorText = new AutomationHomePage(this.getDriver(), this.baseURL)
				.clickDressesButton()
				.clickPrintedDressName()
				.addToWishlist()
				.getWishlistMessageText();
		
		assertTrue("The error message is incorrect. Actual error message is " + wishlistErrorText, wishlistErrorText.equals("You must be logged in to manage your wishlist."));
	}
}
