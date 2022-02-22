package steps;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	
	HomePage homeobject;
    UserRegistrationPage registerobject;
    

	@Given("the user in the Home page")
	public void the_user_in_the_home_page() {
	homeobject = new HomePage(driver);
	homeobject.openRegisterationPage();
	}	    
	
	@When("I click on the register link")
	public void i_click_on_the_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));    
	}
	
	/*@When("I entered the user data")
	public void i_entered_the_user_data() {
		registerobject = new UserRegistrationPage(driver);
		registerobject.userregistration("Haroun", "khattab","test899@test.com", "90908765");
	}*/
	
	@When("I entered the user data")
	public void i_entered_the_user_data(String firstname, String lastname, String email, String password) {
		registerobject = new UserRegistrationPage(driver);
		registerobject.userregistration(firstname, lastname,email, password);
	}
	    
	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerobject.userLogout();    
	}


}
