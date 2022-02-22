package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registerobject; 
	LoginPage loginobject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisterSuccessfully() {
		
		homeobject = new HomePage(driver);
		homeobject.openRegisterationPage();
		
	registerobject = new UserRegistrationPage(driver);
	registerobject.userregistration("mody", "hesham","test11223@gmail.com", "1234567999");
	Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
			 
	}
	@Test(priority = 2 , dependsOnMethods =  "userRegisterSuccessfully")
	public void registeredUserLogout() {
		registerobject.userLogout();		
	}
	
	@Test(priority = 3 ,dependsOnMethods = "userRegisterSuccessfully")
	public void registeredUserLogin() {		
		homeobject.openLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin("test11223@gmail.com", "1234567999");
	
	}
	

}
