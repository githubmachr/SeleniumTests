package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.base.Page;



public class LoginPage extends Page {
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	

	

	public LoginPage() {
		super();
		defaultUrl = "http://www.demo.guru99.com/v4/";
		
		
	}
	
	public void setUsername(String userName)
	{
		username.sendKeys(userName);
	}
	
	public void setPassword(String passWord)
	{
		password.sendKeys(passWord);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	public ManagerHomepage login(String strUserName,String strPasword){

       

        this.setUsername(strUserName);

        

        this.setPassword(strPasword);

        

        this.clickLogin();    
        
        return new ManagerHomepage();

    }
	
	public boolean isOnLoginPage()
	{
		return username.isDisplayed();
	}
	
	
	
	
	
	

}
