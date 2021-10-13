package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationWishlistListingPage extends PageObject {

	protected AutomationWishlistListingPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public AutomationWishlistListingPage clickOnWishlistName() {
		WebElement nameOfWishlist = driver.findElement(By.xpath("//a[contains(text(), 'My wishlist')]"));
		nameOfWishlist.click();
		
		return this;
	}

	public String viewFirstItemName() {
		String firstItemName = driver.findElement(By.xpath("//p[@id='s_title']")).getText();
		
		return firstItemName;
	}

	public AutomationWishlistListingPage deleteCurrentWishlist() {
		WebElement deleteWishlistButton = driver.findElement(By.xpath("//table[@class='table table-bordered']//i[@class='icon-remove']"));
		deleteWishlistButton.click();
		this.driver.switchTo().alert().accept();
		
		return this;
	}
}
