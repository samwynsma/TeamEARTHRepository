package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	public WebElement getCartButton() {
		return driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
	}
	
	public AutomationShoppingCartSummary clickCart() {
		getCartButton().click();
		
		return new AutomationShoppingCartSummary(this.driver, this.URL);
	}

	public AutomationSearchResultsPage enterKeywordAndSubmit(String submitText) {
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
		searchBox.sendKeys(submitText);
		WebElement submitBox = driver.findElement(By.xpath("//button[@name='submit_search']"));
		submitBox.click();
		
		return new AutomationSearchResultsPage(this.driver, this.URL);
	}
}
