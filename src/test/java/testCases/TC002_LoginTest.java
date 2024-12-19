package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***Strating TC_002_LoginTest*********");
		
		try
		{
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email")); //valid data taken from properties file
			lp.setPassword(p.getProperty("password")); //valid data taken from properties file
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc= new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
//			Assert.assertEquals(targetPage, true, "Login Failed"); //If it was failed -- Login failed msg is displayed
			Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished TC_002_LoginTest*********");
	}
}
