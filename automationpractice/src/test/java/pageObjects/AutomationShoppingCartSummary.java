package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		return driver.findElement(By.xpath("//span/parent::a[contains(@class, 'standard-checkout')]"));
	}
	
	public AutomationShoppingCartAddress clickProceedButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		getProceedButton().click();
		
		return new AutomationShoppingCartAddress(this.driver, this.URL);
	}

	public String verifyItemPresent() {
		WebElement shoppingCartItem = driver.findElement(By.xpath("//table//p[@class='product-name']/a[contains(text(), 'Printed Dress')]"));
		return shoppingCartItem.getText();
	}
}
