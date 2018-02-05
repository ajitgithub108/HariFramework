package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import generic.SeleniumClass;

public class CamLogAuto extends SeleniumClass {
	
	private static WebDriver driver;
	
	String errortagName = "a";
	List<WebElement> errorTags;
	List<WebElement> fresherrorTags;
	String nameDropDown = "filter_status";
	String xpathUpdateButton = "//*[@value='Oppdater']";
	WebElement dropelem;
	WebElement updateButton,errorTable;
	String nametest;
	WebElement elem;
	private Select sel;
	int clear_one = 1;
	String linkUrl,freshlinkUrl;
	String linkTextHomePageLink = "%s";
	String taskId;
	int count;
	//String camAlertUrl = "http://ajiman-dev.cam/cam_alerts.php";
	String camAlertUrl = "https://cam:M0nitor@cam.broadnet.no/cam_alerts.php";
	//String camAlertUrl = "https://cam:M0nitor@cam.test.as2116.net/cam_alerts.php";
	
	 
	ArrayList<String> allTasks = new ArrayList<String>();
	 
	String clearedErrorLinks = "Below Error are cleared :";  
	String nonClearedErrorLinks = "Below Error are Not cleared : ";  
	
	String xpathchecktoclear;
	WebElement checkToclear;
	
	public void clickHomePageLink(String linkName) {
		
		linkTextHomePageLink = String.format(linkTextHomePageLink, linkName);
		
		elem = super.identifyElement("linkText", linkTextHomePageLink);
		super.actionToPerform("click", elem,null);
		linkTextHomePageLink = "%s";
	}
	
	public void getAllErrorLinks() {
		
					
		errorTags = super.identifyElements("tag", errortagName);	// get all error links 
		
		for(WebElement we : errorTags) {
			linkUrl = we.getAttribute("href");  
			allTasks.add(linkUrl);
		}
		
		
		for (int i = 0; i < allTasks.size(); i++) {
						
				//System.out.println(allTasks.get(i));			
				linkUrl = allTasks.get(i);
				
				fresherrorTags = super.identifyElements("tag", errortagName);	
				
				for(WebElement fe : fresherrorTags) {
					
					freshlinkUrl = fe.getAttribute("href");  
					
					if(linkUrl.equals(freshlinkUrl)) {  // if present in fresh link also 
				
				
						//linkUrl = we.getAttribute("href");  
						taskId = linkUrl.substring(linkUrl.lastIndexOf("=") + 1);  
								
						super.navigate("to",linkUrl);  // redirect to 			 
						dropelem = super.identifyElement("name",nameDropDown);   // dropdown selector 
						updateButton = super.identifyElement("xpath",xpathUpdateButton);   // update button  selector 
									
						sel = new Select(dropelem);  
						sel.selectByValue("ERROR");  // click on dropdown for error selection 
						updateButton.click();   // click on update button
						
						if(super.identifyElements("class","tableHead").size() == 0) {  
						    taskId = linkUrl.substring(linkUrl.lastIndexOf("=") + 1);  
						    xpathchecktoclear = "//img[@onclick='kvitt("+taskId+")']";  
						    super.navigate("to",camAlertUrl); 
							checkToclear = super.identifyElement("xpath",xpathchecktoclear);  
							checkToclear.click();  
							super.alertWait();  
							super.navigate("to",camAlertUrl);
							String msg = "Cleared following Error as no error found : "+linkUrl;
							clearedErrorLinks = clearedErrorLinks+"\n"+msg;
							
							//System.out.println("Clearrd this Error as no error found : "+linkUrl);
							break;					    
							
						}else {  // else of table check
							String msg = "Cant clear following Error without verification : "+linkUrl;
							//System.out.println("Cant clear this Error without verification"+linkUrl);
							nonClearedErrorLinks = nonClearedErrorLinks+"\n"+msg;
							super.navigate("to",camAlertUrl);
							break;
						}
						
					
				} //  end if present in fresh page also 
					
			
			} // end of fresh  error loop 
					
					
			
		}  // end of all main  error loop 
		
		
		System.out.println(clearedErrorLinks);
		System.out.println(nonClearedErrorLinks);
		super.closeBrowser();
	} // end of getAllErrorLinks function 

}
