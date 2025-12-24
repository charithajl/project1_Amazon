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


public class AmazonOrdersPage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1
	@FindBy(xpath="//div[@class='order-card js-order-card'][1]/descendant::ul/li[4]")
	private WebElement firstOrderReview;
	
	@FindBy(xpath="//img[@alt='select to rate item five star.']")
	private WebElement fiveStarRating;
	
	@FindBy(xpath="//span[@class='a-color-link' and .='Clear']")
	private WebElement assertionRating;
	
	
	
	//Step2
	public void firstOrderReview()
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstOrderReview));
		firstOrderReview.click();
		
	}
	
	public void fiveStarRating()
	{
		wait.until(ExpectedConditions.elementToBeClickable(fiveStarRating));
		fiveStarRating.click();
		
	}
	
	public WebElement assertionRating()
	{
		wait.until(ExpectedConditions.visibilityOf(assertionRating));
		return assertionRating;
		
	}
	
	//Step3
	public AmazonOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
