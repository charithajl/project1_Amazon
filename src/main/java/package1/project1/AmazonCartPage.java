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


public class AmazonCartPage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1
	@FindBy(xpath="(//span[@data-a-selector='increment-icon'])[1]")
	private WebElement incrementIcon;
	
	@FindBy(xpath="(//span[@data-a-selector='decrement-icon'])[1]")
	private WebElement decrementIcon;
	
	
	
	//Step2
	public void incrementIcon()
	{
		wait.until(ExpectedConditions.elementToBeClickable(incrementIcon));
		incrementIcon.click();
		
	}
	
	public void decrementIcon()
	{
		wait.until(ExpectedConditions.elementToBeClickable(decrementIcon));
		decrementIcon.click();
		
	}
	
	
	
	//Step3
	public AmazonCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
