package frameworks;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	
	protected WebDriver driver;
	protected String URL;
	
	protected PageObject(WebDriver driver, String URL) {
		this.driver = driver;
		this.URL = URL;
	}
}
