package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	
	WebDriver driver;
	Logger logger;

	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="dwfrm_login_username")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="dwfrm_login_password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(id="login")
	@CacheLookup
	WebElement signIn_button;
	
	

	
	public void setUsername(String uname) {
		try {
			username.sendKeys(uname);
			
		}catch(Exception e){
			
			logger.error(username+"sendingkeys fail!");
		}
		
	}
	
	public void setPwd(String password) {
		try {
			pwd.sendKeys(password);
			
		}catch(Exception e){
			
			logger.error(pwd+"sendingkeys fail!");
		}
		
		
	}
	
	public void click_signIn_button() {
		
		try {
			signIn_button.click();
			
		}catch(Exception e){
			
			logger.error(signIn_button+"click fail!");
		}
		
		
	}
	
	public void emptyUsername() {
		username.clear();
	}
	
	public void emptyPwd() {
		pwd.clear();
	}
	
	public void login(String uname, String password) {
		username.clear();
		username.sendKeys(uname);
		pwd.clear();
		pwd.sendKeys(password);
		signIn_button.click();
	}
	
	

}
