package com.ebanking.TestCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException {
		
		
		driver.get(baseUrl);
		logger.info("Url is oppened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		
		logger.info("Password is entered");
		lp.setBtnLogin();
		
		
	if (driver.getTitle().contains(" Manager HomePage")){
				
		Assert.assertTrue(true);
		logger.info("Login test passed");

				}
		else {
		captureScreen (driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
					
		
		
		
	}
	
	

}
