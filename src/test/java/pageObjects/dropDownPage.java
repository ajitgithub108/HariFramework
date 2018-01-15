package pageObjects;

import org.openqa.selenium.WebElement;

import generic.SeleniumClass;

public class dropDownPage extends SeleniumClass {
 
	String idDropDown = "dropdown";
	WebElement elem;
	
	public void dropDown(String value,String type) {
		elem = super.identifyElement("id", idDropDown);
		super.actionToPerform(type, elem, value);
	}
	
}
