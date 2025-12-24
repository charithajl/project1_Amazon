package package1.project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class TestCase9 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void AddingtoCart()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		AmazonProductPage productpage = new AmazonProductPage(driver);
		
		homepage.searchingProduct();
		Reporter.log("Product search finished");
		
		List<WebElement> searchResults = productresultspage.searchResults();
		Reporter.log("Search results displayed");
		
		WebElement product = searchResults.get(4);
		productresultspage.clickingonProduct(product);
		Reporter.log("Product1 link is clicked");
		
		productresultspage.WindowHandlingProduct(driver);
		/*
		Set<String> windowHandle = driver.getWindowHandles();
        Iterator<String> iterator = windowHandle.iterator();
        String parent = iterator.next();
        String child = iterator.next();
		driver.switchTo().window(child);
		*/
		Reporter.log("now Handling Product1 page"); 
		
		productpage.addtoCartButton();
		Reporter.log("Product1 added to cart"); 
		Assert.assertEquals(productpage.addtoCartText(), "Added to cart");
		driver.close();
		
		productpage.WindowHandlingParent(driver);
		Reporter.log("now Handling productresults page"); 
		
		/*List<WebElement> searchResults2 = productresultspage.searchResults();
		Reporter.log("Search results displayed");*/
		
		WebElement product2 = searchResults.get(5);
		productresultspage.clickingonProduct(product2);
		Reporter.log("Product2 link is clicked");

		productresultspage.WindowHandlingProduct(driver);
		Reporter.log("now Handling Product2 page"); 
		
		productpage.addtoCartButton();
		Reporter.log("Product2 added to cart"); 
		Assert.assertEquals(productpage.addtoCartText(), "Added to cart");
		driver.close();
		
		}


}
