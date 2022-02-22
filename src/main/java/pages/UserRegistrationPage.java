package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	WebElement maleradiobtn;
	
	@FindBy(id = "FirstName")
	WebElement firstnametxtbox;
	
	@FindBy(id = "LastName")
	WebElement lastnametxtbox;
	
	@FindBy(id = "Email")
	WebElement emailtxtbox;
	
	@FindBy(id = "Password")
	WebElement passtxtbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasstxtbox;
	
	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;
	
	@FindBy (linkText = "My account")
	WebElement myAccountLink;
	
		
	public void userregistration(String firstname, String lastname, String email, String password) {
		
		clickbtn(maleradiobtn);
		setTextElementText(firstnametxtbox, firstname);
		setTextElementText(lastnametxtbox, lastname);
		setTextElementText(emailtxtbox, email);
		setTextElementText(passtxtbox, password);
		setTextElementText(confirmpasstxtbox, password);
		
		clickbtn(registerbtn);
		
	}
	public void userLogout() {		
		clickbtn(logoutLink);
	}
	
	public void openmyAccountPage() {		
		clickbtn(myAccountLink);
	}
	
	
}
