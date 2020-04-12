package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Base_page {
	public WebDriver driver;
	public Base_page(WebDriver driver)//constructor 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}// every POM class should extends this class
	public void verifyElement(int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("element is visible",true);
		}
		catch(Exception e)
		{
			Reporter.log("failed to locate",true);
			Assert.fail();
		}
	}
	public void clickableElement(int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait (driver, time);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log("element clicked",true);
		}
		catch(Exception e)
		{
			Reporter.log("failed to click",true);
			Assert.fail();
		}
	}
	public void verifytitle(int time,String title)
	{
		WebDriverWait wait=new WebDriverWait (driver, time);
		try
		{
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("Title displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("failed to verify title",true);
			Assert.fail();
		}
	}
	public void checktitle(int time,String title)
	{
		WebDriverWait wait=new WebDriverWait (driver, time);
		try
		{
			wait.until(ExpectedConditions.titleIs(title));
			Reporter.log("Title checked",true);
		}
		catch(Exception e)
		{
			Reporter.log("failed to checktitle",true);
			Assert.fail();
		}
	}
	public void checkElementPresence(int time,String path)
	{
		WebDriverWait wait=new WebDriverWait (driver, time);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			Reporter.log("element located",true);
		}
		catch(Exception e)
		{
			Reporter.log("failed to verify check element",true);
			Assert.fail();
		}
	}

}
