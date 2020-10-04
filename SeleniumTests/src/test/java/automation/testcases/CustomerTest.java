package automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.Page;
import automation.pages.CustomerUpdateMessagePage;
import automation.pages.EditCustomerPage;
import automation.pages.EnterEditCustomerPage;
import automation.pages.LoginPage;
import automation.pages.NewCustomerDetailsPage;
import automation.pages.NewCustomerPage;
import automation.pages.NewCustomerPage.Genger;
import automation.util.Utility;


public class CustomerTest extends Page {
	
	
	
	
	
	@BeforeMethod
	public void setUp()
	{
		

	     initialize();
	      
	     LoginPage loginPage = new LoginPage();
	     loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	   
			
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
	
	@Test()
	public void addNewCustomer() 
	{
		driver.get("http://www.demo.guru99.com/v4/manager/addcustomerpage.php");
		String email = Utility.getRandomEmail();
		NewCustomerPage newCustomerPage = new NewCustomerPage();
		NewCustomerDetailsPage newCustomerDetailsPage = newCustomerPage.addCustomer("Lambda", Genger.MALE,"09051976",
				"Long street", "New York","New York","123456","983737273",email,"1234");
		
		
		
		//Assert.assertTrue(newCustomerPage.isRegistered());
		AssertJUnit.assertTrue(newCustomerDetailsPage.isRegistered());
		
		
		String newCustomerID = newCustomerDetailsPage.getNewCustomerID();
		System.out.print("New customer ID is: " + newCustomerID);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(email).append(";").append(newCustomerID);
		
		Utility.saveLineToCSV("/home/master/Documents/newcustomers.csv", stringBuilder.toString());
		
		
			
	}
	
	@Test
	public void enterEditCustomerPage()
	{
		
		EnterEditCustomerPage enterEditCustomerPage = new EnterEditCustomerPage();
		driver.get(enterEditCustomerPage.getDefaultUrl());
		EditCustomerPage  editCustomerPage = enterEditCustomerPage.edistCustomer(properties.getProperty("firstCustomerID"));
		AssertJUnit.assertTrue(editCustomerPage.isOnPage());
		
	}
	
	@Test
	public void changeCustomerDetail()
	{
		EnterEditCustomerPage enterEditCustomerPage = new EnterEditCustomerPage();
		driver.get(enterEditCustomerPage.getDefaultUrl());
		EditCustomerPage  editCustomerPage = enterEditCustomerPage.edistCustomer(properties.getProperty("firstCustomerID"));
		AssertJUnit.assertTrue(editCustomerPage.isOnPage());
		CustomerUpdateMessagePage customerUpdateMessagePage = editCustomerPage.changeCustomerCity(Utility.getAlphaNumericString(5));
		AssertJUnit.assertTrue(customerUpdateMessagePage.isOnPage());
		
		
	}
	

	
	
	
	
	
	
	
  

}
