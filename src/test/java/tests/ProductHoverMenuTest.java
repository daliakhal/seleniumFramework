package tests;


import static org.testng.Assert.assertTrue;



import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	
	HomePage homeobject;
	
	@Test
	public void UserCanSelectSubcategoryFromMenu() {
		
	homeobject	= new HomePage(driver);
	homeobject.SelectNotebookMenu();
	assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
