package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(id = "small-searchterms")
 WebElement searchtextbox ;   

@FindBy (css = "button.button-1.search-box-button")
WebElement searchbutton;

@FindBy(id = "ui-id-5")
WebElement productlist ;

@FindBy(css = "span.price.actual-price")
public WebElement pricelabel ;

@FindBy(linkText = "Apple MacBook Pro 13-inch")
public WebElement productnamelink;

public void ProductSearch(String productname) {
	setTextElementText(searchtextbox, productname);
	clickbtn(searchbutton);
}


}