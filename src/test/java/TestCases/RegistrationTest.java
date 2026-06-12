package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import utilities.RetryFailedTest;

public class RegistrationTest extends BaseTest {

	@Test (groups= {"Regression", "Smoke"})
	public void HomePageOP()
	{
		logger.info("Test Has been started");
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		//Registration
		RegistrationPage rg = new RegistrationPage(driver);
		
		logger.info("Entering Registeration Details.");
		
		rg.SetFName(getrandomString().toUpperCase());
		
		
		rg.SetLastName(getrandomString().toUpperCase());
		rg.setEmail(getrandomString()+"@ms.com");
		rg.setPhone(getrandomNumeric());
		
		String pssword =getRandomStringNumeric();
		
		rg.setPassword(pssword);
		rg.conPassword(pssword);
		rg.clickNoButton();
		rg.clickAgreeButton();
		
		logger.info("Clicking on Contineu Button.");
		rg.clickConButton();
		
		String confrMsg = rg.GetConfirm();
		
		if (confrMsg.equalsIgnoreCase("Your Account has been created!"))
		{
			System.out.println("Test Passed.");
			Assert.assertTrue(true);
			
			logger.info("Test Case Passed.");
		}
		else
		{
			System.out.println("Test Failed.");
			Assert.fail();
			logger.info("Test Case Failed");
		}
	}	
}
