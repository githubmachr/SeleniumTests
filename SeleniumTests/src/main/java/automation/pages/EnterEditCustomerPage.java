package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;

public class EnterEditCustomerPage extends Page {
	
	
	
	
	@FindBy(name = "cusid")
	WebElement txtCustomer;
	
	@FindBy(name= "AccSubmit")
	WebElement submit;
	
	
	
	
	
	

	public EnterEditCustomerPage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/manager/EditCustomer.php";
	}
	
		
	public void setCustomerID(String id)
	{
		txtCustomer.clear();
		txtCustomer.sendKeys(id);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public EditCustomerPage edistCustomer(String id)
	{
		setCustomerID(id);
		submit.click();
		return new EditCustomerPage(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
