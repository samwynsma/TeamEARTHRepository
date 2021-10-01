package pageObjects;

import org.openqa.selenium.WebDriver;

import frameworks.PageObject;

public class AutomationProductDetailsPage extends PageObject {

	protected AutomationProductDetailsPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public String getProductDetails() {
		return "";
	}
}
