package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	
	WebDriver driver;

	
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
		username.sendKeys(uname);
	}
	
	public void setPwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void click_signIn_button() {
		signIn_button.click();
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
