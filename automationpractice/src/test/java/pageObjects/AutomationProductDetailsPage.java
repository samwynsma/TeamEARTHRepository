package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationProductDetailsPage extends PageObject {

	protected AutomationProductDetailsPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public String[] getProductDetails() {
		String[] productDetails = new String[4];
		productDetails[0] = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		productDetails[1] = driver.findElement(By.xpath("//span[@itemprop='price']")).getText();
		productDetails[2] = driver.findElement(By.xpath("//h3[text()='Reviews']/parent::section//div[@id='product_comments_block_tab']")).getText();
		productDetails[3] = driver.findElement(By.xpath("//div[@id='image-block']")).getText();
		return productDetails;
	}

	public AutomationProductDetailsPage addToCart() {
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='exclusive']"));
		addToCartButton.click();
		WebElement closeBox = driver.findElement(By.xpath("//span[@class='cross']"));
		closeBox.click();
		
		return this;
	}

	public AutomationShoppingCartSummary viewCart() {
		WebElement viewCartButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		viewCartButton.click();
		
		return new AutomationShoppingCartSummary(this.driver, this.URL);
	}
}
