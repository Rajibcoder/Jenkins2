package in.amazon.jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	WebDriver driver;
	
	@BeforeTest
	public void lunchapp() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")){			
			driver = new ChromeDriver();
		}
		    
		else if (os.contains("nix") || os.contains("aix") || os.contains("nux")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");			
			driver = new ChromeDriver(options);
		}
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
