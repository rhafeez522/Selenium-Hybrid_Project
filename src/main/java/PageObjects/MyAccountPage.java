package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseComponents {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccTxt;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LogoutBtn;
	
	@FindBy(css = ".btn.btn-primary")
	WebElement contBtn;
	
	
	//ActionMethods
	
	public boolean VerifyText()
	{
		try
		{
		return MyAccTxt.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogoutBtn()
	{
		LogoutBtn.click();
	}
	
	public void clickContBtn()
	{
		contBtn.click();
	}
	
	

}
