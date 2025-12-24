package package1.project1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonSignUpPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	//Step1
	@FindBy(id="ap_phone_number")
	private WebElement phonenumber;
	
	@FindBy(id="ap_customer_name")
	private WebElement customername;
	
	@FindBy(id="ap_password")
	private WebElement password;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(id="intention-submit-button")
	private WebElement CreateAccountbutton;
	
	//Step2
	public void validPhonenumber()
	{
		wait.until(ExpectedConditions.visibilityOf(phonenumber));
		phonenumber.sendKeys("1457854128");
	}
	
	public void customerName()
	{
		wait.until(ExpectedConditions.visibilityOf(customername));
		customername.sendKeys("Chari");
	}
	
	public void validPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("grtey67");
	}
	
	public void clickContinue()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
			}
	
	

	//Step3
	public AmazonSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
