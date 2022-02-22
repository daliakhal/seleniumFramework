package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText ="Register")
	WebElement registerlink;
	
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactuslink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydroplist;
	
	@FindBy(linkText = "Computers")
	WebElement computersmenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebooksmenu;
	
	public void openRegisterationPage() {
		clickbtn(registerlink);
	}
	public void openLoginPage() {
		clickbtn(loginlink);
	}
	    
        
	public void openContactUsPage() {
		scrollToBottom();
		clickbtn(contactuslink);
	}
	
	public void changeCurrency() {
		select = new Select(currencydroplist);
		select.selectByVisibleText("Euro");	
	}

    public void SelectNotebookMenu() {
   	 	
    action.moveToElement(computersmenu).build().perform();
    action.moveToElement(notebooksmenu)
    .click().build().perform();
   
}
    
}