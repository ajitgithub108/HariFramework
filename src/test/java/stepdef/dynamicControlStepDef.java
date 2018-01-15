package stepdef;

import cucumber.api.java.en.*;
import pageObjects.DynamicControls;

public class dynamicControlStepDef {
	
	DynamicControls dnyobj = new DynamicControls();
	
	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dnyobj.clickButton(arg1);
	    
	}
	
	@Then("^verify message  \"([^\"]*)\"$")
	public void verify_message(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dnyobj.verifyMessage(arg1);
	}

}
