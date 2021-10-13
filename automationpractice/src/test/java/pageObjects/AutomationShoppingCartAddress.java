package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationShoppingCartAddress extends PageObject {
	
	private String[] addList = {
			"",
			"Jacob Kal", 
			"123 Easy St", 
			"Bellevue, Washington 98013", 
			"United States", 
			"1234567890", 
			"1234567890"};
	private String delivId = "address_delivery";
	private String invoiId = "address_invoice";

	protected AutomationShoppingCartAddress(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public String[] getAddList() {
		return this.addList;
	}

	public String[] getAddDeliv() {
		WebElement delivText = getAddText(delivId);
		String[] delivArr = delivText.getText().trim().split("\n");
		return delivArr;
	}
	
	public String[] getAddInvoi() {
		WebElement invoiText = getAddText(invoiId);
		String[] invoiArr = invoiText.getText().trim().split("\n");
		return invoiArr;
	}

	private WebElement getAddText(String id) {
		return driver.findElement(By.xpath("//ul[@id='"+id+"']"));
	}
	
	public AutomationCheckoutShipping clickProceedButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		getProceedButton().click();
		
		return new AutomationCheckoutShipping(this.driver, this.URL);
	}

	private WebElement getProceedButton() {
		return driver.findElement(By.xpath("//button[@name='processAddress']"));
	}
}
