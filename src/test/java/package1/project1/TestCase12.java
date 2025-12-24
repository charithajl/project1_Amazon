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

public class TestCase12 extends TestCaseLoginTOAmazon{
	
//	private static final String netbanking = null;

	@Test(dataProvider = "fetchingvalueset1",retryAnalyzer=RetryLogic.class)
	public void paymentmethods(String input)
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		AmazonProductPage productpage = new AmazonProductPage(driver);
		AmazonCartPage cartpage = new AmazonCartPage(driver);
		AmazonCheckoutPage checkoutpage = new AmazonCheckoutPage(driver);
		
		homepage.searchingProduct();
		Reporter.log("Product search finished");
		
		List<WebElement> searchResults = productresultspage.searchResults();
		Reporter.log("Search results displayed");
		
		WebElement product = searchResults.get(4);
		productresultspage.clickingonProduct(product);
		Reporter.log("Product1 link is clicked");
		
		productresultspage.WindowHandlingProduct(driver);
		Reporter.log("now Handling Product1 page"); 
		
		productpage.buyNowButton();
		Reporter.log("clicked buy now button - entering checkout page"); 
		Assert.assertEquals(driver.getTitle(), "Place Your Order - Amazon Checkout");
		
		checkoutpage.changeAddressBtn();
		Reporter.log("clicked on change address button"); 
		
		checkoutpage.addressSelectionBtn();
		Reporter.log("checkout address selected"); 
		
		checkoutpage.deliverToThisAddressBtn();
		Reporter.log("confirming selected checkout address"); 
		
		switch(input)
		{
		case "netbanking" : 
			checkoutpage.netbankingSelection();
			Reporter.log("payment mode :netbanking selected"); 
			break;
			
		case "creditcard" : 
			checkoutpage.creditcardSelection();
			Reporter.log("payment mode :creditcard selected"); 
			break;
	
		case "emiselection" : 
			checkoutpage.emiSelection();
			Reporter.log("payment mode :emi selected"); 
			break;
		
		case "cod" : 
			checkoutpage.codSelection();
			Reporter.log("payment mode :cod selected"); 
			break;
		
		case "upi" : 
			checkoutpage.upiSelection();
			Reporter.log("payment mode :upi selected"); 
			break;
		}

		
		checkoutpage.useThisPaymentMethod();
		Reporter.log("confirming the payment method"); 
		}
	
	@DataProvider
	public Object[][] fetchingvalueset1()
	{
		Object[][] d1 = new Object[5][1];
		d1[0][0]="netbanking";
		d1[1][0]="creditcard";
		d1[2][0]="emiselection";
		d1[3][0]="cod";
		d1[4][0]="upi";
				
		return d1;
	}


}
