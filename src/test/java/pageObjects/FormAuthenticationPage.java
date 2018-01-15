package pageObjects;

import org.openqa.selenium.WebElement;

import generic.SeleniumClass;

public class FormAuthenticationPage extends SeleniumClass {
	String idUsername = "username";
	String idPassword = "password"; 
	
	String xPathloginButton = "//button/i[contains(text(),' Login')]";
	String idMessage = "flash";
	String xpathLogoutButton = "//a/i[contains(text(),'Logout')]";
	
	WebElement elem;
	
	public void passCrendintials(String uname,String pword) {
		elem = super.identifyElement("name", "username");
		super.actionToPerform("settext", elem, uname);
		
		elem = super.identifyElement("name", "password");
		super.actionToPerform("settext", elem, pword);
	}
	
	public void clickLogin() {
		elem = super.identifyElement("xpath", xPathloginButton);
		super.actionToPerform("click", elem, null);
	}
	
	public void clickLogout() {
		elem = super.identifyElement("xpath", xpathLogoutButton);
		super.actionToPerform("click", elem, null);
	}
	
	public void verifyMessage(String expectedMessage) {
		elem = super.identifyElement("id", idMessage);
		String actualMessage = super.actionToPerform("gettext", elem, null);
		
		assert  actualMessage.contains(expectedMessage):"Actual" + actualMessage +"and expected message "+ expectedMessage +" are not matching";
		
	}
	
}
