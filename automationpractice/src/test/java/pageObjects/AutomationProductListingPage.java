package pageObjects;

import org.openqa.selenium.WebDriver;

import frameworks.PageObject;

public class AutomationProductListingPage extends PageObject {

	protected AutomationProductListingPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public AutomationProductDetailsPage clickPrintedDressDetails() {
		// TODO Auto-generated method stub
		return new AutomationProductDetailsPage(this.driver, this.URL);
	}

}
