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

public class TestCase5 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void SearchingProduct()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		homepage.searchingProduct();
		List<WebElement> searchResults = productresultspage.searchResults();
		
		Assert.assertEquals((searchResults.size()>10), true, "product searched succesfully and results are displayed");
		
		
		}


}
