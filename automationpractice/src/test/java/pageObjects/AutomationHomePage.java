package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationHomePage extends PageObject {
	
	private final WebElement dressButton = driver.findElement(By.xpath("//div/ul/li/a[@title='Dresses']"));

	public AutomationHomePage(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//a[@class='login']"));
	}
	
	public AutomationLoginPage clickLogin() {
		getLoginButton().click();
		
		return new AutomationLoginPage(driver, URL);
	}

	public AutomationProductListingPage clickDressesButton() {
		this.dressButton.click();
		
		return new AutomationProductListingPage(this.driver, this.URL);
	}
}
