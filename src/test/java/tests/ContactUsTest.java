package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage home;
	ContactUsPage contactpage ;
	
	String name = "ahmed";
	String email = "tanty123@test.com";
	String message = "Hello admin, this is for test" ;
	
	@Test
	public void UserCanContact() {
		
		home = new HomePage(driver);
		home.openContactUsPage();
		contactpage = new ContactUsPage(driver);
	contactpage.ContactUs(name, email, message);
	assertTrue(contactpage.successMessage.getText()
	.contains("Your enquiry has been successfully sent to the store owner."));
	
	
	
	
	}
   	

}
