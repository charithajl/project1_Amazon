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

public class TestCase4 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void profileUpdation()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		homepage.hoveroveronAccountAndList(driver);
		homepage.manageProfile();
		homepage.selectProfile();
		Reporter.log("Entering Profile page from home page");
		
		AmazonProfilePage profilepage = new AmazonProfilePage(driver);
		profilepage.preferredDepartment();
		profilepage.addButton();
		profilepage.preferredDepartmentWomenOption();
		profilepage.preferredDepartmentSavebutton();
		Reporter.log("Successfully updated profile");
		
		Assert.assertEquals(driver.getTitle(), "Profile Hub");
		
		
		
		}


}
