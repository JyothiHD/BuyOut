package generic;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Generic_Test implements Auto_const {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	Logger log=Logger.getLogger(Generic_Test.class);

	BrowserFactory br=new BrowserFactory();
	Filemanager fm=new Filemanager();
	public WebDriver driver;
	
	@BeforeSuite
	public void setup()
	{
		//htmlreporter=new ExtentHtmlReporter("./Ereports/report.html");// i need to specify report generation path
		htmlreporter=new ExtentHtmlReporter("./Ereports/"+new Date().toString().replace(":","-")+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
	}
	
	@BeforeMethod
	public void openAppn()
	{
		log.info("browser is launched");
	driver=br.getBrowser("chrome");
	driver.get(fm.getQASUrl());
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//System.setProperty(chrome_key, chrome_value);
	//driver=new ChromeDriver();
	//driver.get("http://122.166.192.191:9007/");
	}
	@AfterMethod
	public void closeAppn(ITestResult res) throws IOException
	{
		System.out.println(res.getStatus());
		if(ITestResult.FAILURE==res.getStatus())
		{
			String tc_name=res.getName();
			
			test.fail("test case failed", MediaEntityBuilder.
					createScreenCaptureFromPath(new Screenshot().capture(driver, tc_name)).build());
		}
		test.assignAuthor("Jyothi");
		test.assignDevice("Laptop");
		test.assignCategory("Gui Automation");
		reports.setSystemInfo("window", "8");
		
		//br.closebrowser();
		driver.quit(); 
		log.info("browser is closed");
	}
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
	}
	
	
	

}
