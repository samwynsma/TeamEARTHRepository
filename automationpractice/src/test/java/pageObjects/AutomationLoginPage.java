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
	
	private void clickLogin() {
		WebElement button = getButton(buttonIds[0]);
		
		button.click();
	}

	private WebElement getButton(String id) {
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

}
