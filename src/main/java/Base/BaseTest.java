package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Config.ConfigReader;
import Driver.DriverFactory;
import Utility.SeleniumUtils;

public class BaseTest {

	protected WebDriver driver ;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		//load the config file
		ConfigReader.loadConfig();
		
		// Initialise the Driver
		driver = DriverFactory.initDriver();
		
		// go to the page
		driver.get(ConfigReader.get("baseUrl"));
		
		// Delete all cookies
		SeleniumUtils.deleteAllCookies(driver);
		
		// maximize the window
		SeleniumUtils.maximizeWindow(driver);
		
		// wait until page loading
		SeleniumUtils.pageLoadTimeout(driver);		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
