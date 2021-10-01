package foundations;

import org.openqa.selenium.WebElement;

public class TextBoxControlExtension {
	
	private WebElement mappedElement;
	
	public TextBoxControlExtension(WebElement element) {
		this.mappedElement = element;
	}

	public void setValue(String nameText) {
		this.mappedElement.sendKeys(nameText);
	}

	public String getValue() {
		return this.mappedElement.getAttribute("value");
	}
}
