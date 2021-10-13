package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageObject;

import foundations.TextBoxControlExtension;

public class AutomationLoginPage extends PageObject {
	
	private final String emailId = "email";
	private final String passId = "passwd";
	private final String[] ids = {emailId, passId};
	private final String loginId = "SubmitLogin";
	private final String registerId = "SubmitCreate";
	private final String[] buttonIds = {loginId, registerId};
	private ArrayList<TextBoxControlExtension> loginForm = new ArrayList<TextBoxControlExtension>();

	protected AutomationLoginPage(WebDriver driver, String URL) {
		super(driver, URL);
		
		for (String id: ids) {
			WebElement element = driver.findElement(By.xpath("//input[@id='"+id+"']"));
			loginForm.add(new TextBoxControlExtension(element));
		}
	}
	
	public AutomationProfilePage login() {
		clickLogin();
		
		return new AutomationProfilePage(driver, URL);
	}
	
	protected void clickLogin() {
		WebElement button = getButton(buttonIds[0]);
		
		button.click();
	}

	protected WebElement getButton(String id) {
		return driver.findElement(By.xpath("//button[@id='"+id+"']"));
	}

	public void enterEmail(String val) {
		enterField(0, val);
	}
	
	public void enterPass(String val) {
		enterField(1, val);
	}
	
	public void enterField(int index, String val) {
		loginForm.get(index).setValue(val);
	}
	
	public String getEmailField() {
		return getField(0);
	}
	
	public String getPassField() {
		return getField(1);
	}
	
	public String getField(int index) {
		return loginForm.get(index).getValue();
	}
	
	public void tryCreateButton() {
		clickCreate();
	}
	
	private void clickCreate() {
		WebElement button = getButton(buttonIds[1]);
		
		button.click();
	}
	
	public String readCreateError() {
		return getCreateError().getText().trim();
	}
	
	public WebElement getCreateError() {
		WebElement ele = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li"));
		return ele;
	}

	public void tryLogin() {
		clickLogin();
	}
	
	public String readLoginError() {
		return getLoginError().getText().trim();
	}

	private WebElement getLoginError() {
		WebElement ele = driver.findElement(By.xpath("//div[@id='center_column']/div[contains(@class, 'alert-danger')]/ol/li"));
		return ele;
	}
	
	public void findLoginForm() {
		if (!loginForm.isEmpty()) {
			loginForm.clear();
		}
		
		for (String id: ids) {
			WebElement element = driver.findElement(By.xpath("//input[@id='"+id+"']"));
			loginForm.add(new TextBoxControlExtension(element));
		}
	}
}
