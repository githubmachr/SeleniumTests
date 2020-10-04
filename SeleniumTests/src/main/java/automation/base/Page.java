/**
 * 
 */
package automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;



import automation.util.WebEventListener;






/**
 * @author master
 *
 */
public abstract class Page {
	
	protected String defaultUrl; 
	protected String correctTitle; //real title of the page
	public static WebDriver driver;
	public static Properties properties;
	
	static final String PROPERTIES_FILE_PATH = "/home/master/eclipse-workspace/SeleniumTests/src/main/java/automation/config/config.properties";
	static final String DRIVER_PATH = "/home/master/Documents/Selenium/";
	
	
	public Page()
	{
		
		
		
      try {
			
			properties = new Properties();
			FileInputStream ip = new FileInputStream(PROPERTIES_FILE_PATH);
			properties.load(ip);
			PageFactory.initElements(driver, this);
			
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void initialize()
	{
		String browserName = properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",DRIVER_PATH + "chromedriver");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",DRIVER_PATH + "geckodriver");
			driver = new FirefoxDriver();
		} else {
			throw new UnsupportedOperationException("Only chrome and firexfox is supported");
			//in config you supplied name of driver which is not supported
		}
		
		
		
		
		
     // EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
      
		
	 //   WebEventListener eventListener = new WebEventListener();
		
	//	eventFiringWebDriver.register(eventListener);
		
	   //  driver =  eventFiringWebDriver;
		
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));
		
	}
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
   public String getTitle() {
		
		return this.driver.getTitle();
	}
   
   public String getDefaultUrl()
   {
	   return this.defaultUrl;
   }
   
   
	

}
