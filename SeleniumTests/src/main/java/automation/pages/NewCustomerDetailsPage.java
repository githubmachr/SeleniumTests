package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;

public class NewCustomerDetailsPage extends Page {
	
	
	@FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	WebElement customerID;
	
	@FindBy(name = "customer")
	WebElement customerRegistered;
	
	
	
	
	
	

	public NewCustomerDetailsPage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/manager/CustomerRegMsg.php";
	}
	
		
	public String getNewCustomerID()
	{
		return this.customerID.getText();
	}
	
	public boolean isRegistered()
	{
		return customerRegistered.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
