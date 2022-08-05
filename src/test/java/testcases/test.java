package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class test {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\eclipse-workspace\\ShoppingTestProject\\config\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.roots.com/on/demandware.store/Sites-RootsCA-Site/en_CA/Account-Show");
		driver.findElement(By.id("dwfrm_login_username")).sendKeys("1659145340@qq.com");
		driver.findElement(By.id("dwfrm_login_password")).sendKeys("1204fighting");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3);
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_customer_firstname']")).sendKeys("abc");
		
//		driver.findElement(By.xpath("//button[@aria-label='Search']/span[@class='header-icon-search']")).click();
//		Thread.sleep(3);
//		driver.findElement(By.id("searchInput")).click();
		
		
		
		

		

	}
	


}
