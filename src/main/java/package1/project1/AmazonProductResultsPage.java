package package1.project1;

import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AmazonProductResultsPage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1	
	@FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> searchResult;
	
	@FindBy(xpath="//li[@id='p_n_g-101015233022111/207199034031']/descendant::i")
	private WebElement genderWomen;
	
	@FindBy(xpath="//li[@id='p_36/dynamic-picker-2']/descendant::a")
	private WebElement priceRange;
	
	@FindBy(xpath="//a/h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")
	private List<WebElement> womenText;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	private List<WebElement> priceText;
	
	@FindBy(xpath="//select[@name='s']")
	private WebElement priceSort;
	
	//Step2
		
	public List<WebElement> searchResults()
	{
			return searchResult;
	}
	
	public List<WebElement> priceText()
	{
			return priceText;
	}
	
	public List<WebElement> womenTextList()
	{
			return womenText;
	}
	
	public void clickingonProduct(WebElement product)
	{
		product.click();
	}

	public void genderWomenCategory()
	{
		wait.until(ExpectedConditions.elementToBeClickable(genderWomen));
		genderWomen.click();
	}
	
	public void priceRange()
	{
		wait.until(ExpectedConditions.elementToBeClickable(priceRange));
		priceRange.click();
	}
	
	public void WindowHandlingProduct(WebDriver driver)
	{
		Set<String> windowHandle = driver.getWindowHandles();
        Iterator<String> iterator = windowHandle.iterator();
        String parent = iterator.next();
        String child = iterator.next();
       // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(child));
        driver.switchTo().window(child);
	}
	
	public void priceSortHightoLow()
	{
		wait.until(ExpectedConditions.visibilityOf(priceSort));
		Select s1 = new Select(priceSort);
		s1.selectByIndex(2);
	}
	
	public void priceSortLowtoHigh()
	{
		wait.until(ExpectedConditions.visibilityOf(priceSort));
		Select s1 = new Select(priceSort);
		s1.selectByIndex(1);
	}
	
	public boolean priceSortChecking(List<WebElement> priceTextlist)
		{
		    boolean condition = false;
			for(int i=3;i<priceTextlist.size()/2;i++)
			{
			String pr1 = priceTextlist.get(i).getText();
			String pt1 = pr1.replaceAll("[^a-zA-Z0-9]", "");
			int price1 = Integer.parseInt(pt1);
			System.out.println(i);
			
			String pr2 = priceTextlist.get(i+1).getText();
			String pt2 = pr2.replaceAll("[^a-zA-Z0-9]", "");
			int price2 = Integer.parseInt(pt2);
			System.out.println(price1);
			System.out.println(price2);
			condition = price2<price1;
		
			
		}
			return condition;
	}
	
	//Step3
	public AmazonProductResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
