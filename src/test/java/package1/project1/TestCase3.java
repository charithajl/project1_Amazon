package package1.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class TestCase3 extends BaseClass{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginwithInvalidcred() throws InterruptedException
	{
		AmazonHomePage homepage=new AmazonHomePage(driver);
		homepage.hoveroveronAccountAndList(driver);
		homepage.SignIn();
		Reporter.log("From Home Page-Hoverover on Accounts and List->Click on SignIn");
		
		AmazonLoginPage loginpage = new AmazonLoginPage(driver);
		loginpage.validUsername();
		loginpage.clickContinue();
		loginpage.invalidPassword();
		loginpage.SignInContinue();
		Thread.sleep(10000);
		WebElement e3 = driver.findElement(By.className("a-alert-content"));
		Assert.assertEquals(e3.getText(), "Your password is incorrect","login failed due to wrong password");
		
		}


}
