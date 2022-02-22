package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	JavascriptExecutor jse;
	public Select select;
	public Actions action ;
	
	//create constructor 
	public PageBase(WebDriver driver) {	
	 PageFactory.initElements(driver, this); 		
	}
	
	public static void clickbtn(WebElement button) {
		button.click();		
	}
    
   public static void setTextElementText(WebElement textelement, String value) {
	   
	   textelement.sendKeys(value);	   
}
   
   public void scrollToBottom() {
	   jse.executeScript("scrollBy(0, 25000)");	   
	   
   }
   
}


