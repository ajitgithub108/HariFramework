package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import pageObjects.HomePage;

public class HomeStepDef {
	
	HomePage hp = new HomePage();
	int count;
	
	@Given("^user has selected \"([^\"]*)\" browser$")
	public void user_has_selected_browser(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp.launchBrowser(arg1);
	}

	@Then("^\"([^\"]*)\" is launched$")
	public void is_launched(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hp.launchApp(arg1);
	}

	@Then("^verify page title is \"([^\"]*)\"$")
	public void verify_page_title_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hp.verifyPage(arg1, "title");
	}

	@Then("^verify page url is \"([^\"]*)\"$")
	public void verify_page_url_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hp.verifyPage(arg1, "url");
	}
    

	@Then("^get link count on home page$")
	public void get_link_count_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    count = hp.getLinkCount();
	}

	@Then("^verify link count is (\\d+)$")
	public void verify_link_count_is(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //assert count==arg1: "Actual value is not matching with expected ";
		hp.verifyCount(count,arg1);
	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hp.clickHomePageLink(arg1);
	}

	@Then("^nevigate back to home page$")
	public void nevigate_back_to_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hp.navigate("back", null);
	}

	@When("^switch to another window$")
	public void switch_to_another_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp.switchWindow();
	}
	
	@Then("^check checkbox \"([^\"]*)\"$")
	public void check_checkbox(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^select option \"([^\"]*)\"$")
	public void select_option(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hp.writeExcel("sample");
		hp.readExcel("sample");
		hp.captureScreenShot();
		hp.closeBrowser();
	}

}
