package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_page;

public class AdminLogin_page1 extends Base_page
{
	@FindBy(xpath="//input[@id='email']")
	private WebElement eml;
	@FindBy(xpath="//input[@id='password']")
	private WebElement pwd;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block btn-login']")
	private WebElement login;

	public AdminLogin_page1(WebDriver driver) {
		super(driver);
	}
	public void getemail(String val)
	{
		verifyElement(5, eml);
		eml.sendKeys(val);
	}
	public void getpwd(String val)
	{
		pwd.sendKeys(val);
	}
	public void getlogin()
	{
		login.click();
	}

}
