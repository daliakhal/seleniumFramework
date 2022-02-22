package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	String productname = "Apple Macbook pro " ;
	
	@Test
	public void userCanSearch() {
		
		SearchPage searchobject = new SearchPage(driver) ;
		searchobject.ProductSearch(productname);
		
		assertTrue(searchobject.productnamelink.isDisplayed());
		
				
	}

}
