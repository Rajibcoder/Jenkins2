package in.amazon.jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	WebDriver driver;
	
	@BeforeTest
	public void lunchapp() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test
	public void TitleVerify() {
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
