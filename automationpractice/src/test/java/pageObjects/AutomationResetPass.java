package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationResetPass extends PageObject {

	protected AutomationResetPass(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public String readError() {
		return getError().getText().trim();
	}

	private WebElement getError() {
		WebElement ele = driver.findElement(By.xpath("//div[@id='center_column']/div/div[contains(@class, 'alert-danger')]/ol/li"));
		return ele;
	}
	
	public void clickRetButton() {
		getRetButton().click();
	}

	private WebElement getRetButton() {
		return driver.findElement(By.xpath("//span[contains(text(), 'Retrieve Password')]/parent::button"));
	}
}
