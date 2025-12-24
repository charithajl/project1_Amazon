package package1.project1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonLoginPage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Step1
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(id="continue")
	private WebElement clickContinue;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="auth-signin-button")
	private WebElement SignInbutton;
	
	@FindBy(id="intention-submit-button")
	private WebElement CreateAccountbutton;
	
	//Step2
	public void validUsername()
	{
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("7675998688");
	}
	
	public void invalidUsername()
	{
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("cherrycharitha45.jaddu@gmail.com");
	}
	
	public void clickContinue()
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickContinue));
		clickContinue.click();
	}
	
	public void validPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("cherry123");
	}
	
	public void invalidPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("Vjryjyr");
	}
	
	public void SignInContinue()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SignInbutton));
		SignInbutton.click();
		//driver.navigate().refresh();
	}
	
	public void CreateAccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(CreateAccountbutton));
		CreateAccountbutton.click();
		//wait.until(ExpectedConditions.titleIs("Create Account"));
		//Assert.assertEquals(driver.getTitle(), "Create Account");
	}

	//Step3
	public AmazonLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
