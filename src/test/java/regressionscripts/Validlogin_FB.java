package regressionscripts;

import static org.testng.Assert.assertEquals;


import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.Generic_Test;

import pom.Fbvalid_login1;

public class Validlogin_FB extends Generic_Test {
	@Test
	public void validlogin_FB()
	{
		String username=Excel.ReadData("Sheet1", 1, 0);
		String password=Excel.ReadData("Sheet1", 1, 1);
		String etitle=Excel.ReadData("Sheet1", 1, 2);
		test=reports.createTest("Validlogin_FB","user enters valid login credentials inorder to login");
		test.info("validlogin tst has started");
		Fbvalid_login1 fb = new Fbvalid_login1(driver);
		fb.setemail(username);
		test.pass("username entered successfully");
		fb.setpwd(password);
		test.pass("password entered successfully");
		fb.clicklogin();  
		test.pass("successfully clicked on login");
		fb.verifytitle(6, "Facebook");
		Assert.assertEquals(driver.getTitle(),etitle );
		System.out.println("pass");
		test.pass("title verified successfully");
		test.info("test ended");
		
	}
	
	

}



