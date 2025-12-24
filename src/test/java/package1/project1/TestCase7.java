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

public class TestCase7 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void ProductDetails()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		homepage.searchingProduct();
		Reporter.log("Product search finished");
		List<WebElement> searchResults = productresultspage.searchResults();
		WebElement product = searchResults.get(30);
		productresultspage.clickingonProduct(product);
		Reporter.log("Clicked on a Product");
		productresultspage.WindowHandlingProduct(driver);
		Reporter.log("Handling Product page");  
		AmazonProductPage productpage = new AmazonProductPage(driver);
		Assert.assertEquals(productpage.productTitle(), true);
		Reporter.log("checked for product title  displayed or not");
		Assert.assertEquals(productpage.productPrice(), true);
		Reporter.log("checked for product price displayed or not");
		Assert.assertEquals(productpage.productReview(), true);
		Reporter.log("checked for product review displayed or not");
		Assert.assertEquals(productpage.productDetail(), true);
		Reporter.log("checked for product detail displayed or not");
	       
		
		}


}
