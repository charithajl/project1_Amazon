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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonCheckoutPage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//Step1
	@FindBy(xpath="//a[@data-args='redirectReason=shipaddressselectChangeClicked']")
	private WebElement changeAddressBtn;
	
	@FindBy(xpath="//div[@aria-labelledby='delivery-addresses-section-header-id'][2]")
	private WebElement addressSelectionBtn;
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id']")
	private WebElement deliverToThisAddressBtn;
	
	@FindBy(xpath="//select[@name='ppw-bankSelection_dropdown']")
	private WebElement netbankingSelection;
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id']")
	private WebElement useThisPaymentMethod;
	
	@FindBy(xpath="//input[@type='radio' and @value='SelectableAddCreditCard']")
	private WebElement creditcardSelection;
	
	@FindBy(xpath="//input[@type='radio' and @value='instrumentId=amzn1.pm.pma.upi-VW5pZmllZFBheW1lbnRzSW50ZXJmYWNlOkdlbmVyaWNHdWVzdF9RckNvZGU.QTJEUTM2TEVYMTQ0VzY&isExpired=false&paymentMethod=UnifiedPaymentsInterface&tfxEligible=false']")
	private WebElement upiSelection;
	
	@FindBy(xpath="//input[@type='radio' and @value='instrumentId=EMI&isExpired=false&paymentMethod=CC&tfxEligible=false']")
	private WebElement emiSelection;
	
	@FindBy(xpath="//input[@type='radio' and @value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']")
	private WebElement codSelection;
	
	@FindBy(xpath="//input[@placeholder='Enter Code']")
	private WebElement couponCode;
	
	@FindBy(xpath="//div[@class='a-column a-span12 pmts-error-message-inline']/descendant::p")
	private WebElement couponCodeAssertion;
	
	//Step2
	public void changeAddressBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(changeAddressBtn));
		changeAddressBtn.click();
	}
	
	public void addressSelectionBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addressSelectionBtn));
		addressSelectionBtn.click();
	}
	
	public void deliverToThisAddressBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(deliverToThisAddressBtn));
		deliverToThisAddressBtn.click();
	}
	
	public void netbankingSelection()
	{
		wait.until(ExpectedConditions.visibilityOf(netbankingSelection));
		  Select s1 = new Select(netbankingSelection);
	       s1.selectByVisibleText("ICICI Bank");
	}
	
	public void creditcardSelection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(creditcardSelection));
		creditcardSelection.click();
	}
	
	public void upiSelection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(upiSelection));
		upiSelection.click();
	}
	
	public void emiSelection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(emiSelection));
		emiSelection.click();
	}
	
	public void codSelection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(codSelection));
		codSelection.click();
	}
	
	public void useThisPaymentMethod()
	{
		wait.until(ExpectedConditions.elementToBeClickable(useThisPaymentMethod));
		useThisPaymentMethod.click();
	}
	
	public void couponCode()
	{
		wait.until(ExpectedConditions.visibilityOf(couponCode));
		couponCode.sendKeys("HAPPY"+Keys.ENTER);
	}
	
	public String couponCodeAssertion()
	{
		wait.until(ExpectedConditions.visibilityOf(couponCodeAssertion));
		return couponCodeAssertion.getText();
	}
	
	//Step3
	public AmazonCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
