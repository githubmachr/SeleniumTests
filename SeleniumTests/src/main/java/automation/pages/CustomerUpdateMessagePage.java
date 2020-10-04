package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;



public class CustomerUpdateMessagePage extends Page {
	
	@FindBy(className = "heading3")
	WebElement labelUpdated;
	
	

		
		public CustomerUpdateMessagePage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/manager/CustomerUpdateMsg.php?cid=45400";
	}
	
	public boolean isOnPage()
	{
		System.out.println(labelUpdated.getText());
		return labelUpdated.isDisplayed();
		
	}
}
