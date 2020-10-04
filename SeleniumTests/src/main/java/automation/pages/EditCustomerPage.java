package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;

public class EditCustomerPage extends Page {
	

	
	@FindBy(name= "name")
	WebElement customerName;
	
	
	@FindBy(name= "city")
	WebElement city;
	
	
	@FindBy(name= "sub")
	WebElement submit;

	
	
	

	public EditCustomerPage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/manager/editCustomerPage.php";
	}
	
	public boolean isOnPage()
	{
		return customerName.isDisplayed();
	}
		
	public void setCity(String city)
	{
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public CustomerUpdateMessagePage changeCustomerCity(String city)
	{
		setCity(city);
		clickSubmit();
		
		return new CustomerUpdateMessagePage();
	}
	
	

}
