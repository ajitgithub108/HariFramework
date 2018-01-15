package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import generic.SeleniumClass;

public class checkCheckbox extends SeleniumClass {
		
	String xpathcheckbox = "//form[@id='checkboxes']/input";

	List<WebElement> elements;
	
	public void checkSelect(String type,String boxnumber) {
		
		elements =  super.identifyElements("xpath", xpathcheckbox);
		int index =1;
		int boxNo = Integer.parseInt(boxnumber);
		
		for(WebElement we : elements) {
			
			if(boxNo==index) {
				
				if(we.isSelected()) {
					
					if(type.equalsIgnoreCase("uncheck")) {
					 super.actionToPerform("click", we, null);	
					}
					
				}
				else {
					
					if(type.equalsIgnoreCase("check")) {
						 super.actionToPerform("click", we, null);	
					}
					
				}
				
								
				
			} 
			else {
				index++;
			}
			
			
		}
		
	}
	
	
	
	
}
