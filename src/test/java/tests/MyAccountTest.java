package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registerobject; 
	MyAccountPage myaccountobject ;
	LoginPage loginobject;
	String oldpassword = "12345678656";
	String newpassword ="98765432232";
	String firstname = "moslem";
	String lastname = "hesho";
	String email = "teto12345@test.com";
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisterSuccessfully() {
		
		homeobject = new HomePage(driver);
		homeobject.openRegisterationPage();
		
	registerobject = new UserRegistrationPage(driver);
	registerobject.userregistration(firstname,lastname,email, oldpassword);
	Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
}
	
	@Test(dependsOnMethods = "userRegisterSuccessfully")
	public void RegisteredUserCanChangePass() {
		
		myaccountobject = new MyAccountPage(driver);
		registerobject.openmyAccountPage();
		myaccountobject.openChangePasswordPage();
		myaccountobject.changePassword(oldpassword, newpassword);				
	}
	
	@Test( dependsOnMethods =  "RegisteredUserCanChangePass")
	public void registeredUserLogout() {
		registerobject.userLogout();		
	}
	
	@Test(dependsOnMethods = "registeredUserLogout")
	public void registeredUserLogin() throws InterruptedException {		
		homeobject.openLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email, newpassword);	
		Thread.sleep(9000);
		
	}
}
