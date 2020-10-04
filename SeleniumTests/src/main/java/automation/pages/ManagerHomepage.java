package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;


public class ManagerHomepage extends Page{
	
	

	public static final String defaultUrl = "http://www.demo.guru99.com/v4/manager/Managerhomepage.php";
	
	@FindBy(partialLinkText = "Log out")
	WebElement logoutLink;
	
	public ManagerHomepage() {
		super();
		
	}
	
	public void logOut()
	{
		logoutLink.click();
	}
	
	
	
	
	
	
}
