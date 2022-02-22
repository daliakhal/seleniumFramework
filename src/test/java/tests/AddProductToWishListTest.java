package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	
	ProductDetailsPage productobject;
    String productname = "Apple Macbook pro " ;
    WishListPage wishobject;
	
	@Test(priority = 1)
	public void userCanSearch() {
		
		SearchPage searchobject = new SearchPage(driver) ;
		searchobject.ProductSearch(productname);
		searchobject.productnamelink.click();	
	}

	@Test (priority =2)
	public void UserCanAddtoWishList() {
		
    productobject = new ProductDetailsPage(driver);
    productobject.AddtoWishList();
    driver.navigate().to("https://demo.nopcommerce.com/wishlist");
    wishobject = new WishListPage(driver);
    assertTrue(wishobject.productcell.getText().contains("Apple MacBook Pro"));	
	}
	
	@Test (priority =3)
	public void UserCanRemoveProductFromWishlist() {
		
		wishobject = new WishListPage(driver);
		wishobject.RemoveProductFromCart();
		assertTrue(wishobject.emptycartlabel.isDisplayed());
		
	}
	
}
