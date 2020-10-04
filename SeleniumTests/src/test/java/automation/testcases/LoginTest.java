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
import automation.pages.LoginPage;
import automation.pages.ManagerHomepage;

public class LoginTest extends Page {
	


	private LoginPage loginPage;
	
	
	@BeforeMethod
	public void setUp()
	{
		 initialize();
		 loginPage = new LoginPage();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
		
	}
  
	
	/*
	 * Tests succesfull login
	 */
	
	@Test(priority=1)
	public void testLoginSuccesfulWithLogOut() throws InterruptedException
	{
		
		
		
		ManagerHomepage managerHomepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
		
		
		managerHomepage.logOut();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		//Assert.assertEquals(managerHomepage.getCurrentUrl(), "http://www.demo.guru99.com/v4/index.php");
		
		
		
	}
	
	/*
	 * Tests unsuccesfull login
	 */
	
	@Test(priority=0)
	public void testLoginUnsuccesful()
	{
		
		LoginPage loginPage = new LoginPage();
		//driver.get("http://www.demo.guru99.com/v4/");
		//Assert.assertTrue(loginPage.getCurrentUrl().equals(loginPage.getDefaultUrl()));
		loginPage.login("wrongname", "wrongpassword");
		
		//text of alert unsuccesfull login
		//String alertText = driver.switchTo().alert().getText();
		//Assert.assertTrue(alertText.equals("User or Password is not valid"));
		
		driver.switchTo().alert().accept();
		AssertJUnit.assertTrue(loginPage.isOnLoginPage());
	
		
		
		
	}
	
	
	
	
}

