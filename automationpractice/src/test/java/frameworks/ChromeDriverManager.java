package frameworks;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	
	final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
	@Override
	public void createDriver() {
		URL chromeDriverURL = getClass().getClassLoader().getResource("chromedriver.exe");
		String chromeDriverPath = chromeDriverURL.getPath();
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, chromeDriverPath);
		
		this.setDriver(new ChromeDriver());
	}
}
