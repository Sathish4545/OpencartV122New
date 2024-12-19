package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.graphbuilder.math.func.RandFunction;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

//	public WebDriver driver;
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("********Starting TC001_AccountRegistrationTest **************");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");//generate email randomly -- for that we need some method user defined
//			regpage.setTelephone("1475245");
			regpage.setTelephone(randomNumber());
//			regpage.setTelephone();
			
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			
			Thread.sleep(2000);
			regpage.setPrivacyPolicy();
			Thread.sleep(2000);
			regpage.clickContinue();
			
			logger.info("Validating Expected message...");
			
			String confmsg = regpage.getConfirmationMsg();
			
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
//			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest ****");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
