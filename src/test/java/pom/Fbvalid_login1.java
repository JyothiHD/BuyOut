package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_page;

public class Fbvalid_login1 extends Base_page {
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@id='u_0_b']")
	private WebElement login;
	
	public Fbvalid_login1(WebDriver driver)
	{
		super(driver);
	}
	
	public void setemail(String username)
	{
		email.sendKeys(username);
	}
	public void setpwd(String password)
	{
		pwd.sendKeys(password);
	}
	 public void clicklogin()
	 {
		 clickableElement(5, login);
		 login.click();
		 
	 }
	
} 
