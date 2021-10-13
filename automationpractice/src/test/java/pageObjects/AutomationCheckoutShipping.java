package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationCheckoutShipping extends PageObject {

	protected AutomationCheckoutShipping(WebDriver driver, String URL) {
		super(driver, URL);
	}
	
	public void toggleTermsBox() {
		getTermsBox().click();
	}
	
	private WebElement getTermsBox() {
		return driver.findElement(By.xpath("//input[@id='cgv']"));
	}
	
	public boolean getBoxStatus() {
		String rawStatus = readBoxStatus();
		boolean retStatus = false;
		
		if (rawStatus.equals("checked")) {
			retStatus = true;
		}
		
		return retStatus;
	}
	
	private String readBoxStatus() {
		return driver.findElement(By.xpath("//div[@id='uniform-cgv']/span")).getAttribute("class");
	} 
	
	public AutomationCheckoutPayment clickProceedButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		getProceedButton().click();
		
		return new AutomationCheckoutPayment(this.driver, this.URL);
	}
	
	public void tryProceedButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		getProceedButton().click();
	}

	private WebElement getProceedButton() {
		return driver.findElement(By.xpath("//button[@name='processCarrier']"));
	}

	public String getTermsError() {
		return driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
	}
}
