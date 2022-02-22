package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "h1")
	WebElement wishheader;
	
	@FindBy(css = "a.product-name")
	public WebElement productcell;
	
	@FindBy(css = "button.remove-btn")
	WebElement removefromcartbtn;
	
	@FindBy(css = "div.no-data")
	public WebElement emptycartlabel;
	
	public void RemoveProductFromCart() {
		
	clickbtn(removefromcartbtn); 
	
	}
	

}
