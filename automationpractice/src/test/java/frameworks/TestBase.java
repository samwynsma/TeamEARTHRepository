package frameworks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {
	
	protected String baseURL;
	private DriverManager driverManager;
	private Settings settings;
	
	protected TestBase(String baseURL){
		this.baseURL = baseURL;
		try {
			this.settings = new Settings();
		} catch (IOException e) {
			settings = null;
		}
	}
	
	@Before
	public void Setup() {
		this.driverManager = DriverManagerFactory.getManager(settings.browserType);
		this.driverManager.createDriver();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().navigate().to(this.baseURL);
	}
	
	@Test
	public void canLaunchWebdriver() {
		System.out.println(settings.browserType);
	}
	
	@After
	public void Cleanup() {
		driverManager.quitDriver();
	}
	
	public WebDriver getDriver() {
		return this.driverManager.getDriver();
	}
}
