package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandExcel extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registerobject; 
	LoginPage loginobject;
	
	@DataProvider(name = "Excel Data")
	public Object[][] userData() throws IOException{
		//get excel table
		ExcelReader er = new ExcelReader();
		return er.getExcelData();		
	}
	
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "Excel Data")
	public void userRegisterSuccessfully(String fname, String lastname, String email, String password) {
		
		homeobject = new HomePage(driver);
		homeobject.openRegisterationPage();
		
	registerobject = new UserRegistrationPage(driver);
	registerobject.userregistration(fname,lastname,email,password);
	Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
	registerobject.userLogout();
	homeobject.openLoginPage();
	loginobject = new LoginPage(driver);
	loginobject.userLogin(email, password);
	registerobject.userLogout();
	}
	
	
	
	
	

}
