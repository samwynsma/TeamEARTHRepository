package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationProfilePage extends PageObject {

	protected AutomationProfilePage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public AutomationHomePage clickLogo() {
		getLogo().click();
		
		return new AutomationHomePage(driver, URL);
	}

	private WebElement getLogo() {
		return driver.findElement(By.xpath("//a[@title='My Store']"));
	}
}
