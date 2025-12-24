package package1.project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)

public class TestCase2 extends BaseClass{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginwithvalidcred()
	{
		AmazonHomePage homepage=new AmazonHomePage(driver);
		homepage.hoveroveronAccountAndList(driver);
		homepage.SignIn();
		Reporter.log("From Home Page-Hoverover on Accounts and List->Click on SignIn");
		
		AmazonLoginPage loginpage = new AmazonLoginPage(driver);
		loginpage.validUsername();
		loginpage.clickContinue();
		loginpage.validPassword();
		loginpage.SignInContinue();
        String actitle = driver.getTitle();
		String extitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals( actitle,extitle,"Login Successful");
		Reporter.log("Login was successful with valid username and vailid password");
		
		}


}
