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

public class TestCase1 extends BaseClass{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void withValidCrede()
	{
		AmazonHomePage homepage=new AmazonHomePage(driver);
		homepage.hoveroveronAccountAndList(driver);
		homepage.SignIn();
		Reporter.log("From Home Page-Hoverover on Accounts and List->Click on SignIn");
		
		AmazonLoginPage loginpage = new AmazonLoginPage(driver);
		loginpage.invalidUsername();
		loginpage.clickContinue();
		loginpage.CreateAccount();
		Reporter.log("From Login Page to Signup Page");
		
		AmazonSignUpPage signuppage = new AmazonSignUpPage(driver);
		signuppage.validPhonenumber();
		signuppage.customerName();
		signuppage.validPassword();
		signuppage.clickContinue();
		Assert.assertEquals(driver.getTitle(), "Authentication required");
		Reporter.log("OTP sent for authentication");
		
		
		//loginpage.invalidPassword();
		//loginpage.SignInContinue();
		
		Reporter.log("Login was successful with valid username and vailid password");
		
		
	}


}
