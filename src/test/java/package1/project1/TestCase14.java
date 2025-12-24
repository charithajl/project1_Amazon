package package1.project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)

public class TestCase14 extends TestCaseLoginTOAmazon{
	


	@Test(retryAnalyzer=RetryLogic.class)
	public void rating()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonOrdersPage orderspage = new AmazonOrdersPage(driver);
		
		homepage.gotoOrders();
		Reporter.log("moving from home page to orders page");
		
		orderspage.firstOrderReview();
		Reporter.log("opening review section of last ordered product");
		
		orderspage.fiveStarRating();
		Reporter.log("gave 5 star rating");
		
		WebElement assertionRating = orderspage.assertionRating();
		Assert.assertEquals(assertionRating.getText(), "Clear");
		

}
}
