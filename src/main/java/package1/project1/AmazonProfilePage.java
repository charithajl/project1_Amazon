package package1.project1;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonProfilePage{
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Step1
	@FindBy(xpath="//div[.='Preferred department']")
	private WebElement department;
	
	@FindBy(xpath="//button[.='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="//button[.='Women']")
	private WebElement womenbutton;
	
	@FindBy(xpath="//div[@class='survey-footer']//descendant::button[.='Save']")
	private WebElement PrefDeptSavebtn;
	
	//Step2
	
	
	public void preferredDepartment()
	{
		wait.until(ExpectedConditions.elementToBeClickable(department));
		department.click();
	}
	
	public void preferredDepartmentWomenOption()
	{
		wait.until(ExpectedConditions.elementToBeClickable(womenbutton));
		womenbutton.click();
	}
	
	public void preferredDepartmentSavebutton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(PrefDeptSavebtn));
		PrefDeptSavebtn.click();
	}
	
	public void addButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}

	
	//Step3
	public AmazonProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);}


}
