package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import frameworks.PageObject;

public class AutomationProductListingPage extends PageObject {
	
	private final WebElement printedDressImage = driver.findElement(By.xpath("//img[@alt='Printed Dress']"));

	protected AutomationProductListingPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public AutomationProductDetailsPage clickPrintedDressDetails() {
		printedDressImage.click();
		driver.switchTo().frame(0);
		WebElement biggerPictureButton = driver.findElement(By.xpath("//img[@id='bigpic']"));
		biggerPictureButton.click();
		
		return new AutomationProductDetailsPage(this.driver, this.URL);
	}

}
