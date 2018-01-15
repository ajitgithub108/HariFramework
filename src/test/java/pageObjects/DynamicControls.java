package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SeleniumClass;

public class DynamicControls extends SeleniumClass {
	
	String cssButton = "button#btn";
	
	String cssCheckbox = "input#checkbox";
	
	String cssProgressbar = "div#loading>img";
	String idMessage = "message";
	
	
	WebElement elem;
	
	public void clickButton(String value) {
		elem = super.identifyElement("css", cssButton);
		super.actionToPerform("click", elem, null);
	}
	
	public void verifyMessage(String expectedMessage) {
		
		
		elem = super.identifyElement("id", idMessage);
		
		super.expliciteWait(idMessage);
		
		String actualMessage = super.actionToPerform("gettext", elem, null);
		
		assert  actualMessage.contains(expectedMessage):"Actual" + actualMessage +"and expected message "+ expectedMessage +" are not matching";
		
	}
}
