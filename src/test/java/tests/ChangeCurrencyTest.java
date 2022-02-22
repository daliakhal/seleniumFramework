package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homeobject;
	SearchPage searchobject;
	String productname = "Apple Macbook pro ";
	
	@Test(priority = 1)
	public void userCanChangeCurrency () {
		homeobject = new HomePage(driver);
		homeobject.changeCurrency();
	}
	@Test (priority = 2)
	public void userCanSearch() {
		SearchPage searchobject = new SearchPage(driver) ;
		searchobject.ProductSearch(productname);
	assertTrue(searchobject.pricelabel.getText().contains("€"));
}
	
}