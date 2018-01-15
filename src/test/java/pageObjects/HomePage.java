package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import generic.SeleniumClass;
public  class HomePage extends SeleniumClass {

	String tagNameLinks = "a";
	String linkTextHomePageLink = "%s";
	
	List<WebElement> ll;
	WebElement elem;
 	
	public int getLinkCount() {
		
		ll = super.identifyElements("tag", tagNameLinks);
		
		return ll.size();
		
	}
	
	public void verifyCount(int count,int arg1) {
		
	    assert count==arg1: "Actual value is not matching with expected ";
	}
	
	public void clickHomePageLink(String linkName) {
		
		linkTextHomePageLink = String.format(linkTextHomePageLink, linkName);
		
		elem = super.identifyElement("linkText", linkTextHomePageLink);
		super.actionToPerform("click", elem,null);
		linkTextHomePageLink = "%s";
	}
	
}
