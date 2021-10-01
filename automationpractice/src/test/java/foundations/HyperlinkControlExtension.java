package foundations;

import org.openqa.selenium.WebElement;

public class HyperlinkControlExtension {

	private WebElement mappedElement;

	public HyperlinkControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public void click() {
		this.mappedElement.click();
	}
}
