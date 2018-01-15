package pageObjects;

import org.openqa.selenium.WebElement;

import generic.SeleniumClass;

public class checkboxpage extends SeleniumClass {
	
	String xpathcheckbox = "//form[@id='checkboxes']/input";
	WebElement elem;
	
	public void dropDown(String value,String type) {
		elem = super.identifyElement("id", xpathcheckbox);
		super.actionToPerform(type, elem, value);
	}
}
