package stepdef;

import cucumber.api.java.en.*;
import pageObjects.FormAuthenticationPage;

public class FormAuthenticationStepDef {
	
	FormAuthenticationPage fap = new FormAuthenticationPage();
	
	
	
	@Then("^pass username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void pass_username_as_and_password_as(String arg1, String arg2) throws Throwable {
		fap.passCrendintials(arg1, arg2);
	}

	@Then("^click on login button$")
	public void click_on_login_button() throws Throwable {
	   fap.clickLogin();
	  
	}

	@Then("^verify message as \"([^\"]*)\"$")
	public void verify_message_as(String arg1) throws Throwable {
	   fap.verifyMessage(arg1);
	  
	}

	@Then("^click on Logout button$")
	public void click_on_Logout_button() throws Throwable {
	   fap.clickLogout();
	  
	}


}
