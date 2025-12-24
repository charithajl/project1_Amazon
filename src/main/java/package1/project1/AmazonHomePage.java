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


public class AmazonHomePage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1
	@FindBy(xpath="//div[@id='nav-link-accountList']")
	private WebElement accountandList;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement signIn;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchbutton;
	
	@FindBy(xpath="//button[.='Manage Profiles']")
	private WebElement manageProf;
	
	@FindBy(xpath="//div/ul/li/div/div/a")
	private WebElement selectProf;
	
	@FindBy(xpath="//span[.='& Orders']")
	private WebElement gotoOrders;
	
	//Step2
	public void hoveroveronAccountAndList(WebDriver driver)
	{
		Actions a1 = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(accountandList));
		a1.moveToElement(accountandList).perform();	
		}
	
	public void SignIn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
	}
	
	public void SignOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signOut));
		signOut.click();
	}
	
	public void searchingProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys("shoe"+Keys.ENTER);
	}
	
	
	public void manageProfile()
	{
		wait.until(ExpectedConditions.elementToBeClickable(manageProf));
		manageProf.click();
	}
	
	public void selectProfile()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectProf));
		selectProf.click();
	}
	
	public void gotoOrders()
	{
		wait.until(ExpectedConditions.elementToBeClickable(gotoOrders));
		gotoOrders.click();
	}


	
	//Step3
	public AmazonHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
