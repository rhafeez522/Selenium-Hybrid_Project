package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class LoginTest extends BaseTest {
	
	@Test(groups= {"Sanity", "Smoke", "Regression"})
	public void Verify_LoginTest()
	{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account button.");
		hp.clickLogin();
		logger.info("Click on Login button");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		
		lp.SetUserName(prop.getProperty("userName"));
		logger.info("Entred the Username.");
		lp.SetPassword(prop.getProperty("password"));
		logger.info("Entered Password.");
		lp.ClickLoginBtn();
		logger.info("Clicked Login Button.");
		
		//MyAccountPage
		
		MyAccountPage mp=new MyAccountPage(driver);
		SoftAssert sa = new SoftAssert();
		
		logger.info("Landed on my account Page.");
		mp.VerifyText();
		sa.assertTrue(mp.VerifyText());
		sa.assertAll();
		
		logger.info("My account text verified.");
		mp.clickLogoutBtn();
		logger.info("Clicked on Logout button.");
		mp.clickContBtn();
		logger.info("Logout successfully.");
	
	}

}
