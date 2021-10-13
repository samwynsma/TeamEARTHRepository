package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

public class AutomationSearchResultsPage extends PageObject {

	protected AutomationSearchResultsPage(WebDriver driver, String URL) {
		super(driver, URL);
	}

	public int getNumberOfResults() {
		WebElement resultCounter = driver.findElement(By.xpath("//span[@class='heading-counter']"));
		String resultCounterText = resultCounter.getText();
		String[] separatedResultCounterWords = resultCounterText.split(" ");
		int numberOfResults = Integer.parseInt(separatedResultCounterWords[0]);
		return numberOfResults;
	}

	public String getErrorMessage() {
		WebElement errorMessageBox = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		String errorMessage = errorMessageBox.getText();
		
		return errorMessage;
	}

}
