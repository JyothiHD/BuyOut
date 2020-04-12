package generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshot {
	public String capture(WebDriver driver, String tc_name)
	{
		Date d=new Date();
		String date = d.toString().replace(":", "-");
		//final String path="./defects/";
		String path=System.getProperty("user.dir")+"./defects/"+date+tc_name+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try
		{
			FileHandler.copy(src, dest);
		}
		catch(Exception e)
		{
			Reporter.log("failed take screenshot", true);
		}
		return path;
	}

	}

