package regressionscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.Generic_Test;
import pom.FbInvalid_login2;


public class InValidlogin_FB extends Generic_Test {
	@Test
	public void invalidlogin_FB()
	{
		String username=Excel.ReadData("Sheet1", 2, 0);
		String password=Excel.ReadData("Sheet1", 2, 1);
		String etitle=Excel.ReadData("Sheet1", 2, 2);
		test=reports.createTest("inValidlogin_FB","user enters valid login credentials inorder to login");
		test.info("validlogin tst has started");
		FbInvalid_login2 fb = new FbInvalid_login2(driver);
		fb.setemail(username);
		test.pass("username entered successfully");
		fb.setpwd(password);
		test.pass("password entered successfully");
		fb.clicklogin();
		test.pass("successfully clicked on login");
		fb.verifyerrormsg();
		test.pass("error msg dispalyed");
		fb.verifytitle(5, "Facebbok");
		Assert.assertEquals(driver.getTitle(),etitle );
		System.out.println("pass");
		test.pass("title verified successfully");
		test.info("test ended");

}
}
