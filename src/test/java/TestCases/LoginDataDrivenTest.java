package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseTest {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"Smoke"})
	

	public void loginDataDriven(String userName, String password, String expResult) {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account button.");
		hp.clickLogin();
		logger.info("Click on Login button");

		// LoginPage
		LoginPage lp = new LoginPage(driver);

		lp.SetUserName(userName);
		logger.info("Entred the Username.");
		lp.SetPassword(password);
		logger.info("Entered Password.");
		lp.ClickLoginBtn();
		logger.info("Clicked Login Button.");
		
		
		MyAccountPage myac=new MyAccountPage(driver);
		boolean targetPage = myac.VerifyText();
		
		logger.info("***validation for invalid result ***");
		if (expResult.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				myac.clickLogoutBtn();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("***validation for valid result ***");
		if (expResult.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myac.clickLogoutBtn();
				Assert.assertTrue(true);
			}
				//else {
//				Assert.assertTrue(false);
			//}
		}
		logger.info("***completed LoginDDTest ***");	
	}

	
}

