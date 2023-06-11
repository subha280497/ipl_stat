package ipl.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Exception {
		
		ExtractData data = new ExtractData();
		
//		Open Browser
		String browser = data.getCommonData("browser");
		if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
