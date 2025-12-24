package package1.project1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonProductPage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1
	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement productTitle;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	private WebElement productPrice;
	
	@FindBy(xpath="//h3[@class='product-facts-title']")
	private WebElement productDetail;
	
	@FindBy(xpath="//h2[@id='averageCustomerReviewsAnchor']")
	private WebElement productReview;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addtoCart;
	
	@FindBy(xpath="//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement addtoCarttext;
	
	@FindBy(xpath="//span[@id='sw-gtc']")
	private WebElement goToCartBtn;
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	private WebElement buyNowBtn;
	
	
	//Step2
	public boolean productTitle()
	{
		wait.until(ExpectedConditions.visibilityOf(productTitle));
		if(productTitle.isDisplayed()&&productTitle.isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean productPrice()
	{
		wait.until(ExpectedConditions.visibilityOf(productPrice));
		if(productPrice.isDisplayed()&&productPrice.isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean productDetail()
	{
		wait.until(ExpectedConditions.visibilityOf(productDetail));
		if(productDetail.isDisplayed()&&productPrice.isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean productReview()
	{
		wait.until(ExpectedConditions.visibilityOf(productReview));
		if(productReview.isDisplayed()&&productReview.isEnabled())
			return true;
		else
			return false;
	}
	
	public void addtoCartButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addtoCart));
		addtoCart.click();
	}
	
	public String addtoCartText()
	{
		wait.until(ExpectedConditions.visibilityOf(addtoCarttext));
		return addtoCarttext.getText();
	}
	
	public void WindowHandlingParent(WebDriver driver)
	{
		Set<String> windowHandle = driver.getWindowHandles();
        Iterator<String> iterator = windowHandle.iterator();
        String parent = iterator.next();
      //  String child = iterator.next();
        driver.switchTo().window(parent);  
	}
	
	public void goToCartBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(goToCartBtn));
		 goToCartBtn.click();
	}
	
	public void buyNowButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(buyNowBtn));
		buyNowBtn.click();
	}
	
	
	//Step3
	public AmazonProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
