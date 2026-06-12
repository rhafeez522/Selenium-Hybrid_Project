package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponents {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(css = "#input-email")
	WebElement email;
	
	@FindBy(css = "#input-password")
	WebElement pass;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	//ActionMethods
	
	public void SetUserName(String UserName)
	{
	email.sendKeys(UserName);	
	}
	public void SetPassword(String Passwrd)
	{
		pass.sendKeys(Passwrd);
	}
	public void ClickLoginBtn()
	{
		loginBtn.click();
	}

}
