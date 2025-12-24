package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass extends ListenersLogic{
	//public class BaseClass {
	
		//public static  WebDriver driver;
		public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	@Parameters("browser")
	@BeforeMethod
	public void launch(String nameofbrowser) throws InterruptedException 
	//public void launch() throws InterruptedException 
	{
		
		if(nameofbrowser.equals("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("Chrome browser is launched");
		}
		
		if(nameofbrowser.equals("edge"))
		{
			driver = new EdgeDriver();
			Reporter.log("Edge browser is launched");
		}
		
		if(nameofbrowser.equals("firefox"))
		{
			driver = new FirefoxDriver();
			Reporter.log("Firefox browser is launched");
		}
		
		
		driver.get("https://amazon.in");
		Reporter.log("Launching Amazon home page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void quit() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		Reporter.log("browser quits");
	}

}
