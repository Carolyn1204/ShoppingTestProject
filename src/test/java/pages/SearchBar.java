package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class SearchBar {
	
	WebDriver driver;

	
	public SearchBar(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//button[@aria-label='Search']/span[@class='header-icon-search']")
	@CacheLookup
	WebElement search_icon;
	
	@FindBy(how=How.ID, using = "searchInput")
	@CacheLookup
	WebElement search_input;
	
	@FindBy(how=How.XPATH, using = "//button[@aria-label='Minicart Icon']/img[@alt='minicart-icon']")
	@CacheLookup
	WebElement bag_icon;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@class,'mini-cart-link-cart')]")
	@CacheLookup
	WebElement view_bag;
	
	public void search(String search_contenct) throws Exception {
		search_icon.click();
		Thread.sleep(3);
		search_input.click();
		Thread.sleep(3);
		search_input.sendKeys(search_contenct);
		Thread.sleep(3);
		search_input.sendKeys(Keys.RETURN);
		Thread.sleep(3);
	}
	
	public void click_bag_icon() {
		bag_icon.click();
	}
	
	public void click_view_bag() {
		view_bag.click();
	}

}
