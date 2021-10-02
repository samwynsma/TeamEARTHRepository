package foundations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import pageObjects.AutomationHomePage;
import pageObjects.AutomationLoginPage;
import pageObjects.AutomationProfilePage;

public class LoginModule {
	
	private final static String email = "maker@gmail.com";
	private final static String pass = "h2twJh!MbbV.hd.";
	private final static String[] credentials = {email, pass};
	private final static String expected = "http://automationpractice.com/index.php?controller=my-account";
	
	public static String getEmail() {
		return getCred(0);
	}
	
	public static String getPass() {
		return getCred(1);
	}
	
	public static String getCred(int index) {
		return credentials[index];
	}
	
	public static AutomationHomePage login(WebDriver driver, String baseURL) {
		
		AutomationLoginPage page = new AutomationHomePage(driver, baseURL).clickLogin();
		
		page.enterEmail(email);
		
		assertEquals(email, page.getEmailField());
		
		page.enterPass(pass);
		
		assertEquals(pass, page.getPassField());
		
		AutomationProfilePage page2 = page.login();
		
		String currentURL = driver.getCurrentUrl();
		
		assertEquals(expected, currentURL);
		
		return page2.clickLogo();
	}
}
