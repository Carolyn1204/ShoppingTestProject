package testcases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchBar;


public class TestCase_addShoppingCart extends BaseClass{
	
	@Test
	public void addShoppingCart() throws Exception  {
			
		LoginPage lp = new LoginPage(driver);	
		lp.login(username, password);
		logger.info("login with username"+username+",password:"+password);
		
//		SearchBar sb = new SearchBar(driver);
//		sb.search("sweater");
//		logger.info("search");
		
		
		if(driver.getPageSource().contains("caro")) {
			logger.info("testcase pass");
			Assert.assertTrue(true);
			
		}
		else {
			captureScreen(driver, this.getClass().getSimpleName());
			logger.error("testcase fail");
			Assert.assertTrue(false);
			
		}
			
	}
	
	


}
