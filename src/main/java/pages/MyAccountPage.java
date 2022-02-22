package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
     
	@FindBy(linkText = "Change password")
	WebElement changepassLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldpasswordtxt;
	
	@FindBy(id = "NewPassword")
	WebElement  newpasswordtxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement  confirmpasswordtxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement  changepasswordbtn;
		
	
	public void openChangePasswordPage() {		
		clickbtn(changepassLink);
}
	
	public void changePassword(String oldpassword , String newpassword) {
		
		setTextElementText(oldpasswordtxt, oldpassword);
		setTextElementText(newpasswordtxt, newpassword);
		setTextElementText(confirmpasswordtxt, newpassword);
		clickbtn(changepassLink);
			
	}
	
}

