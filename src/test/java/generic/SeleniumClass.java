package generic;



import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumClass extends BaseClass {
	
	private static WebDriver driver;
	private WebElement element; 
	private List <WebElement> elements;
	private Select sel;
	
	public void launchBrowser(String browserName) {
		
		System.out.println(browserName + "Browser is launched");
		
		String currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		currentPath = currentPath+"\\src\\test\\java\\utils\\";
		
		
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", currentPath+"chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", currentPath+"geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", currentPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void launchApp(String url) {
		driver.get(url);
	}

	public void verifyPage(String expected,String type) {
		String actual = null;
		
		if(type.equalsIgnoreCase("url")) {
			 actual = driver.getCurrentUrl(); 
		}else if(type.equalsIgnoreCase("title")) { 
			 actual = driver.getTitle();
		}
		
		assert expected.equals(actual) : "Actual URL is not matching with expected url";
	}
	
	public String actionToPerform(String actionType, WebElement actulElement,String textTopass) {
		String actual = null;
		
		
		
		if(actionType.equalsIgnoreCase("click")){
			actulElement.click();
		}
		else if(actionType.equalsIgnoreCase("settext")) {
			actulElement.sendKeys(textTopass);
		}
		else if(actionType.equalsIgnoreCase("gettext")) {
			 actual = actulElement.getText();
		}
		
		else if(actionType.equalsIgnoreCase("index")) {
			sel = new Select(actulElement);
			int index = Integer.parseInt(textTopass);
			sel.selectByIndex(index);
		}
		else if(actionType.equalsIgnoreCase("value")) {
			sel = new Select(actulElement);
			sel.selectByValue(textTopass);
		}
		else if(actionType.equalsIgnoreCase("visibletext")) {
			 sel = new Select(actulElement);
   			 sel.selectByVisibleText(textTopass);
		}
		
		
		return actual;
	}
	
	public void navigate(String type,String url) {
		if(type.equalsIgnoreCase("back")) {
			
			driver.navigate().back();
			
		}
		else if(type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
		
		else if(type.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
		
		else if(type.equalsIgnoreCase("to")) {
			driver.navigate().to(url);
		}
	}
	
	
	public void expliciteWait(String idLocator) {
		WebDriverWait wdw = new WebDriverWait(driver,20);
		wdw.until(ExpectedConditions.presenceOfElementLocated(By.id(idLocator)));
	}
	
	
	public void closeBrowser() {
		driver.close();
		//driver.quit();
	}
	
	public WebElement identifyElement(String lacatorType,String address) {
		
		if(lacatorType.equalsIgnoreCase("id")) {
			
			element = driver.findElement(By.id(address));
			
		} else if(lacatorType.equalsIgnoreCase("name")) {
			
			element = driver.findElement(By.name(address));
		
		} else if(lacatorType.equalsIgnoreCase("class")) {
				
			element = driver.findElement(By.className(address));
			
		} else if(lacatorType.equalsIgnoreCase("tag")) {
			
			element = driver.findElement(By.tagName(address));
		
		} else if(lacatorType.equalsIgnoreCase("linktext")) {
			element = driver.findElement(By.linkText(address));
		
		} else if(lacatorType.equalsIgnoreCase("partial")) {
			
			element = driver.findElement(By.partialLinkText(address));
			
		} else if(lacatorType.equalsIgnoreCase("css")) {
			
			element = driver.findElement(By.cssSelector(address));
			
		}
		else if(lacatorType.equalsIgnoreCase("xpath")) {
			
			element = driver.findElement(By.xpath(address));
			
		}
		
		else {
			System.out.println("Incorrect locator type, any one should requred from"
					+ "id,name,class,tag,linktext,partial,css,xpath");
		}
		
		return element;
		
		
	}
	
	public List<WebElement> identifyElements(String lacatorType,String address) {
		
		if(lacatorType.equalsIgnoreCase("id")) {
			
			elements = driver.findElements(By.id(address));
			
		} else if(lacatorType.equalsIgnoreCase("name")) {
			
			elements = driver.findElements(By.name(address));
		
		} else if(lacatorType.equalsIgnoreCase("class")) {
				
			elements = driver.findElements(By.className(address));
			
		} else if(lacatorType.equalsIgnoreCase("tag")) {
			
			elements = driver.findElements(By.tagName(address));
		
		} else if(lacatorType.equalsIgnoreCase("linktext")) {
			elements = driver.findElements(By.linkText(address));
		
		} else if(lacatorType.equalsIgnoreCase("partial")) {
			
			elements = driver.findElements(By.partialLinkText(address));
			
		} else if(lacatorType.equalsIgnoreCase("css")) {
			
			elements = driver.findElements(By.cssSelector(address));
			
		}
		else if(lacatorType.equalsIgnoreCase("xpath")) {
			
			elements = driver.findElements(By.xpath(address));
			
		}
		
		else {
			System.out.println("Incorrect locator type, any one should requred from"
					+ "id,name,class,tag,linktext,partial,css,xpath");
		}
		
		return elements;
		
	}
	
	public void switchWindow() {
		String parentHandler = driver.getWindowHandle();
		Set<String>  allHandles = driver.getWindowHandles();
		
		for(String handle: allHandles) {
			if(handle.equals(parentHandler)) {
				continue;
			}
			else {
				driver.switchTo().window(handle);
				break;
			}
		}
		
	}
	
	public void captureScreenShot() {
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentPath = System.getProperty("user.dir");
		
		Long timeStamp = System.currentTimeMillis();
		
		currentPath = currentPath + "\\target\\screenShots\\"+ timeStamp+".png";
		
		File dst = new File(currentPath);
		
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
