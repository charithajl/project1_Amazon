package package1.project1;

import java.util.List;

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

public class TestCase8 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void ProductSortingchecking()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		homepage.searchingProduct();
		Reporter.log("Product search finished");
		
		productresultspage.priceSortHightoLow();
		Reporter.log("Product sorted according to price high to low");
		boolean priceSortChecking = productresultspage.priceSortChecking(productresultspage.priceText());
		Reporter.log("Product sort checked");
		Assert.assertEquals(priceSortChecking, true);
		}


}
