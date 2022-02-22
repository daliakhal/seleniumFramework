package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationtTestWithDataProvider extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registerobject; 
	LoginPage loginobject;
	
	@DataProvider(name = "dataTest")
	public static Object[][] userData(){
	
		return new Object[][] {{"yaser", "nabil","test2128@gmail.com", "141234566"},
			{"ahmed", "alim", "test5672@gmail.com", "876543211"}};	
	}
		
	@Test(priority = 1, alwaysRun = true, dataProvider = "dataTest")
	public void userRegisterSuccessfully(String name, String lastname, String email, String password) {
		
		homeobject = new HomePage(driver);
		homeobject.openRegisterationPage();		
	registerobject = new UserRegistrationPage(driver);
	registerobject.userregistration(name,lastname, email, password);
	Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
	registerobject.userLogout();
	loginobject = new LoginPage(driver);
	loginobject.userLogin(email, password);	
	}
	
	
	
	
}
