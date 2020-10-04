package automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;

public class NewCustomerPage extends Page {
	
	public static final String addFailed = "Customer could not be added !!";
	
	@FindBy(name="name")
	WebElement customer;
	
	@FindBy(name="dob")
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobileNumber;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submitButton;
	
	@FindBy(name="res")
	WebElement resetButton;
	
	@FindBy(name = "customer")
	WebElement customerRegistered;
	
	
	
	
	public enum Genger{
		MALE,FEMALE
	}

	public NewCustomerPage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/manager/addcustomerpage.php";
	}
	
	public void setGenger(Genger genger)
	{
		switch(genger)
		{
		case MALE:
			clickOnRadioByValue("m");
			break;
		case FEMALE:
			clickOnRadioByValue("f");
			break;
			
			
		}
	}
	
	private void clickOnRadioByValue(String value)
	{
		List radioButton = driver.findElements(By.name("rad1"));
		
		for(int i = 0; i < radioButton.size(); i++)
		{
			WebElement radio = (WebElement) radioButton.get(i);
			String val = radio.getAttribute("value");
			if(val.equalsIgnoreCase(value))
			{
				radio.click();
			}
			
		}
		
		
	}
	
	public void setCustomer(String customer)
	{
		this.customer.sendKeys(customer);
	}
	
	
	public NewCustomerDetailsPage addCustomer(String customer, Genger genger, String dateOfBirth, String address, String city,
			String state, String pin, String mobileNumber, String email, String password)
	{
		setCustomer(customer);
		setGenger(genger);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setCity(city);
		setState(state);
		setPin(pin);
		setMobileNumber(mobileNumber);
		setEmail(email);
		setPassword(password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitButton.click();
	
		return new NewCustomerDetailsPage();
		
	}
	
	
	
	public void setDateOfBirth(String dateofBirth)
	{
		this.dateOfBirth.sendKeys(dateofBirth);
	}
	
	public void setAddress(String address)
	{
		this.address.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		this.city.sendKeys(city);
	}
	
	public void setState(String state)
	{
		this.state.sendKeys(state);
	}
	
	public void setPin(String pin)
	{
		this.pin.sendKeys(pin);
	}
	
	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber.sendKeys(mobileNumber);
	}
	
	public void setEmail(String email)
	{
		this.email.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public boolean isRegistered()
	{
		return customerRegistered.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
