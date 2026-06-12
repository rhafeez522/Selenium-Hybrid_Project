package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseComponents {
	

	// Constructor
	public RegistrationPage(WebDriver driver) {
		
		super(driver);	

	}

	// Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fname;

	@FindBy(css = "#input-lastname")
	WebElement lname;

	@FindBy(css = "#input-email")
	WebElement email;
	
	@FindBy(css="#input-telephone")
	WebElement phone;

	@FindBy(css = "#input-password")
	WebElement pass;

	@FindBy(id = "input-confirm")
	WebElement conPass;

	@FindBy(xpath = "//input[@value='0']")
	WebElement noBox;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement AgreeButon;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement ContBtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmTxt;

	// ActionMethods

	public void SetFName(String firstname) {
		fname.sendKeys(firstname);
	}

	public void SetLastName(String lastName) {
		lname.sendKeys(lastName);
	}

	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	public void setPhone(String mob)
	{
		phone.sendKeys(mob);
	}

	public void setPassword(String Passwword) {
		pass.sendKeys(Passwword);
	}

	public void conPassword(String conPassword) {
		conPass.sendKeys(conPassword);
	}

	public void clickNoButton() {
		noBox.click();
	}

	public void clickAgreeButton() {
		AgreeButon.click();
	}

	public void clickConButton() {
		ContBtn.click();
	}

	public String GetConfirm() {

		try {
			return confirmTxt.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

}
