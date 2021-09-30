package frameworks;

import java.net.URL;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	
	final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.edge.driver";
	@Override
	public void createDriver() {
		URL edgeDriverURL = getClass().getClassLoader().getResource("msedgedriver.exe");
		String edgeDriverPath = edgeDriverURL.getPath();
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, edgeDriverPath);
		
		this.setDriver(new EdgeDriver());
	}
}
