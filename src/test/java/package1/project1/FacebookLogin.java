package package1.project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookLogin {
	
	WebDriver driver;
	@Test
	public void withVadlidCredentials()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");	
		driver.manage().window().maximize();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username_valid();
		loginpage.password_valid();
		loginpage.loginwithCorrectcred();
	}

}
