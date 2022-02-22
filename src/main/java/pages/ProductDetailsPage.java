package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement wishlistbtn;
	
	public void AddtoWishList() {
		clickbtn(wishlistbtn);
	}

}
