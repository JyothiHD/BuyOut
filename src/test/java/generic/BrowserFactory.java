package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory implements Auto_const{
	//static represents single copy
	//make it all the method non static
	private Map<String, WebDriver> drivers=new HashMap<String, WebDriver>();
	public WebDriver getBrowser(String browserName)
	{
		WebDriver driver=null;
		switch (browserName) //this is key
		{
		case "firefox":
			driver=drivers.get("firefox");//it will take key and it will give corresponding value.
			if(driver==null)
				System.setProperty(gecko_key, gecko_value);
			driver=new FirefoxDriver();
			drivers.put("firefox", driver);
			break;
		case "chrome": 
			driver=drivers.get("chrome");
			if(driver==null)
				System.setProperty(chrome_key, chrome_value);
			driver=new ChromeDriver();
			drivers.put("chrome", driver);
			break;

		default:
			System.out.println("invalid browser");
			break;
		}
		return driver;
	}
	public void closebrowser()
	{
		for(String value : drivers.keySet()) {
			drivers.get(value).quit();
			
		}
	}
	

}
