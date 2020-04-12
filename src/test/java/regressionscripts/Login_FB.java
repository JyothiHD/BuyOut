package regressionscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Dataprovider;
import generic.Generic_Test;
import pom.Fbvalid_login1;

public class Login_FB extends Generic_Test{
	@Test(dataProvider = "authentication")
	public void login_FB(String username, String password)
	{
		test=reports.createTest("Login_Fb", "user enters both valid and invalid credentials");
		test.info("Login page test has started");
	Fbvalid_login1 fb = new Fbvalid_login1(driver);
	fb.setemail(username);
	test.pass("username entered successfully");
	fb.setpwd(password);
	test.pass("password entered successfully"); 
	fb.clicklogin();
	test.pass("successfully clicked on login");
	fb.verifytitle(6, "Facebook");
	Assert.assertEquals(driver.getTitle(),"Facebook" );
	System.out.println("pass");
	test.pass("title verified successfully");
	test.info("test ended");
	}
	
	@DataProvider(name="authentication")
	public Object[][] getdata()
	{
		Object[][] arr = Dataprovider.Testdata("Sheet2");
		return arr;
	}

		
	}
