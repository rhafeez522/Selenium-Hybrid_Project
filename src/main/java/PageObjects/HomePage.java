package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseComponents{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginBtn;

	//ActionsMethods
	
	public void clickMyAccount() 
	{
		myAccount.click();
	}
	public void clickRegister()
	{
		registerBtn.click();
	}
	public void clickLogin()
	{
		loginBtn.click();
	}
}
