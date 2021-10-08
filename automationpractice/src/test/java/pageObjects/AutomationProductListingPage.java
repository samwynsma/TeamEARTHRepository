package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import frameworks.PageObject;

public class AutomationProductListingPage extends PageObject {
	
	//private final WebElement printedDressImage = driver.findElement(By.xpath("//img[@alt='Printed Dress']"));
	//private final WebElement printedDressName = driver.findElement(By.xpath("//a[@class='product-name'][@title='Printed Dress']"));

	protected AutomationProductListingPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public AutomationProductDetailsPage clickPrintedDressDetails() {
		getPrintedDressImage().click();
		driver.switchTo().frame(0);
		WebElement biggerPictureButton = driver.findElement(By.xpath("//img[@id='bigpic']"));
		biggerPictureButton.click();
		
		return new AutomationProductDetailsPage(this.driver, this.URL);
	}

	public AutomationProductDetailsPage clickPrintedDressName() {
		getPrintedDressName().click();
		
		return new AutomationProductDetailsPage(this.driver, this.URL);
	}
	
	public AutomationShoppingCartSummary addPrintedDressToCart() {
		getPrintedDressImage().click();
		driver.switchTo().frame(0);
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='exclusive']"));
		addToCartButton.click();
		
		AutomationProductListingPage page = new AutomationProductListingPage(this.driver, this.URL);
		WebElement proceedButton = page.driver.findElement(By.xpath("//a[title='Proceed to checkout')]"));
		proceedButton.click();
		
		return new AutomationShoppingCartSummary(this.driver, this.URL);
	}
	
	private WebElement getPrintedDressImage() {
		return driver.findElement(By.xpath("//img[@alt='Printed Dress']"));
	}
	
	private WebElement getPrintedDressName() {
		return driver.findElement(By.xpath("//a[@class='product-name'][@title='Printed Dress']"));
	}
}
