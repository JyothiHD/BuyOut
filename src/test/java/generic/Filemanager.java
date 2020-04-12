package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class Filemanager {
	Properties pro;
	public Filemanager()
	{
		try
		{
			FileInputStream fis=new FileInputStream("./Configuration.properties");
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			Reporter.log("property file not found");
		}
	}
	public String getQASUrl()
	{
		String url=pro.getProperty("QAS");
		if(url==null)
			throw new RuntimeException("url not found");
		return url;
    }
	public String getQPREUrl()
	{
		String url=pro.getProperty("QPRE");
		if(url==null)
			throw new RuntimeException("url not found");
		return url;
    }
	public String getQPSUrl()
	{
		String url=pro.getProperty("QPS");
		if(url==null)
			throw new RuntimeException("url not found");
		return url;
    }
}
