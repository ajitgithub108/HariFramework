package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CamLogAuto;

public class CamLogAutoStepDef {
	
	CamLogAuto objcla = new CamLogAuto();
	
	@Then("^get all error ancher links on cam_alerts page$")
	public void get_all_error_ancher_links_on_cam_alerts_page() throws Throwable {
	    
		objcla.getAllErrorLinks();
	}
	
	@Given("^user has selected \"([^\"]*)\" browser$")
	public void user_has_selected_browser(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcla.launchBrowser(arg1);
	}
	
	@Then("^\"([^\"]*)\" is launched$")
	public void is_launched(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcla.launchApp(arg1);
	}
	
	@Then("^verify page title is \"([^\"]*)\"$")
	public void verify_page_title_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcla.verifyPage(arg1, "title");
	}
	
	@Then("^verify page url is \"([^\"]*)\"$")
	public void verify_page_url_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcla.verifyPage(arg1, "url");
	}
	
	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcla.clickHomePageLink(arg1);
	}

}
