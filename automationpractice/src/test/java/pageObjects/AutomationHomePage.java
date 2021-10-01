package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationHomePage extends PageObject {
	
	private final WebElement loginButton = driver.findElement(By.xpath("//a[@class='login']"));

	public AutomationHomePage(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public WebElement getLoginButton() {
		return this.loginButton;
	}
	
	public AutomationLoginPage clickLogin() {
		this.loginButton.click();
		
		return new AutomationLoginPage(driver, URL);
	}
}
