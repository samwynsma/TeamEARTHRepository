package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationShoppingCartSummary extends PageObject {

	protected AutomationShoppingCartSummary(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public String getWarning() {
		return readWarning();
	}

	private String readWarning() {
		return driver.findElement(By.xpath("//p[contains(@class, 'alert-warning')]")).getText();
	}
	
	private WebElement getProceedButton() {
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	}
	
	public AutomationShoppingCartAddress clickProceedButton() {
		getProceedButton().click();
		
		return new AutomationShoppingCartAddress(this.driver, this.URL);
	}
}
