package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.XLUtils;

public class TestCase_login_data extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTestDDT(String user, String pwd) throws IOException, Exception {
			
		LoginPage lp = new LoginPage(driver);	
		lp.emptyUsername();
		lp.emptyPwd();
		lp.setUsername(user);
		logger.info("input username:"+user);
		lp.setPwd(pwd);
		logger.info("input password:"+pwd);
		lp.click_signIn_button();
		logger.info("click login button");
		Thread.sleep(5);;
		
		if(driver.getPageSource().contains("Welcome")) {
			logger.info("testcase pass");
			Assert.assertTrue(true);
			
		}
		else {
			captureScreen(driver, this.getClass().getSimpleName());
			logger.error("testcase fail");
			Assert.assertTrue(false);
			
		}
			
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path = "D:\\eclipse-workspace\\ShoppingTestProject\\src\\test\\java\\testdata\\LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"Login");
		int colnum = XLUtils.getCellCount(path, "Login", 1);
		String loginData[][] = new String[rownum][colnum];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colnum; j++) {
				
				loginData[i-1][j] = XLUtils.getCellData(path, "Login", i, j);
				System.out.println(loginData[i-1][j]);
			}
		}
		return loginData;
	}

}
