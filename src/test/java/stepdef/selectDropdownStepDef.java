package stepdef;

import cucumber.api.java.en.*;
import pageObjects.dropDownPage;

public class selectDropdownStepDef {
	
	dropDownPage dp1 = new dropDownPage();
	
	@Then("^select \"([^\"]*)\" by \"([^\"]*)\" from dropdown$")
	public void select_by_from_dropdown(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dp1.dropDown(arg1, arg2);
	}
}
