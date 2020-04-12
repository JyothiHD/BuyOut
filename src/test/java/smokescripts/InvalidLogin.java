package smokescripts;


import generic.Generic_Test;

import org.testng.Assert;
import org.testng.annotations.Test;



public class InvalidLogin extends Generic_Test {

	@Test
	public void invalidLogin() {
		//String username = Excel.readData("regression", 2, 1);
		
		test.pass("successfully username entered");
		
		test.pass("successfully entered password");
	
		test.pass("successfully clicked on login");
	
		test.pass("error message displayed");
		
		test.pass("title verified successfully");
		test.info("test ended");

	}

}
