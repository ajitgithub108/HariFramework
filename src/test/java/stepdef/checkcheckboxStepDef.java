package stepdef;

import cucumber.api.java.en.Then;
import pageObjects.checkCheckbox;

public class checkcheckboxStepDef {
	
	checkCheckbox ckobj = new checkCheckbox();
	
	@Then("^\"([^\"]*)\" on checkbox \"([^\"]*)\"$")
	public void on_checkbox(String arg1, String arg2) throws Throwable {
	   		ckobj.checkSelect(arg1, arg2);
	}

	
}
