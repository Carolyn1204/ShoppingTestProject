package testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;


public class BaseClass {
	
	

	public static WebDriver driver;
	public static Logger logger;
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


	
	ReadConfig rc = new ReadConfig();
	public String url = rc.get_url();
	public String username = rc.get_username();
	public String password = rc.get_password();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//config//drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","D:\\SeleniumUdemy\\new_chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","D:/eclipse-workspace/shoppingTestProject/config/drivers/chromedriver.exe");
		
		
		logger = Logger.getLogger("shoppingTest");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",rc.get_chromepath());
			driver = new ChromeDriver();
			
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",rc.get_firefoxpath());
			driver = new FirefoxDriver();
		}
		

		driver.manage().window().maximize();
		driver.get(url);
		logger.info("open url"+url);
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
		
	}
	
	public void captureScreen(WebDriver driver, String test_name) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenPath = System.getProperty("user.dir")+"/output/screenshots/"+test_name+timeStamp+".png";
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(screenPath);
		FileUtils.copyFile(source, target);
	}
}
