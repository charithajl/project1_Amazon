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

public class TestCase6 extends TestCaseLoginTOAmazon{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void ProductwithFilters()
	{
		loginwithvalidcred();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		AmazonProductResultsPage productresultspage = new AmazonProductResultsPage(driver);
		homepage.searchingProduct();
		Reporter.log("Product search finished");
		productresultspage.genderWomenCategory();
		Reporter.log("Women category selected in filters");
		productresultspage.priceRange();
		Reporter.log("Price range selected in filters");
		List<WebElement> womenTextList = productresultspage.womenTextList();
		
		 for(int i=3;i<womenTextList.size();i++) 
	        {
	        	//System.out.println("at iteration "+i +"women text not found");
	        	WebElement web1 = womenTextList.get(i);
	            String text = web1.getText();
	           Assert.assertEquals(text.contains("Women"), true) ;
	        }
		 
		 List<WebElement> priceTextlist = productresultspage.priceText();
		   for(int i=3;i<priceTextlist.size();i++) //to fail i can give i=0 so that it will losad earlier results
	        {
			 //  System.out.println("at iteration "+i +"price is not in range");
	        	WebElement price = priceTextlist.get(i);
	            
	            String pricetext = price.getText();
	            String pt1 = pricetext.replaceAll("[^a-zA-Z0-9]", "");
	            int pt = Integer.parseInt(pt1);
	          //  System.out.println(pt);
	           
	           Assert.assertEquals((pt>=2000&&pt<=6000), true) ;
	        }
	       
	       
		
		}


}
