package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import foundations.AutomationPracticeTestBase;
import pageObjects.AutomationHomePage;
import pageObjects.AutomationSearchResultsPage;

public class KeywordSearchTests extends AutomationPracticeTestBase {

	@Test
	public void canFindProductsWithKeyword() {
		int numberOfResults = new AutomationHomePage(this.getDriver(), this.baseURL)
				.enterKeywordAndSubmit("Printed Dress")
				.getNumberOfResults();
		
		assertTrue("Number of results does not match. Actual number of results is " + numberOfResults, numberOfResults==5);
	}
	
	@Test
	public void noKeywordGivesErrorMessage() {
		AutomationSearchResultsPage page = new AutomationHomePage(this.getDriver(), this.baseURL)
				.enterKeywordAndSubmit("");
		int numberOfResults = page.getNumberOfResults();
		String noResultsErrorMessage = page.getErrorMessage();
		
		assertTrue("Number of results does not match. Actual number of results is " + numberOfResults, numberOfResults==0);
		assertTrue("Error message text does not match. Actual error message text is " + noResultsErrorMessage, noResultsErrorMessage.equals("Please enter a search keyword"));
	}
	
	@Test
	public void irrelevantKeywordGivesNoResults() {
		AutomationSearchResultsPage page = new AutomationHomePage(this.getDriver(), this.baseURL)
				.enterKeywordAndSubmit("Lawnmower");
		int numberOfResults = page.getNumberOfResults();
		String noResultsErrorMessage = page.getErrorMessage();
		
		assertTrue("Number of results does not match. Actual number of results is " + numberOfResults, numberOfResults==0);
		assertTrue("Error message text does not match. Actual error message text is " + noResultsErrorMessage, noResultsErrorMessage.equals("No results were found for your search \"Lawnmower\""));
	}

}
