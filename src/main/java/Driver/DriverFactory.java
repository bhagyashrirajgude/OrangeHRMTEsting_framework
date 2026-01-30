package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Config.ConfigReader;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver initDriver() {
		
	 String browser = ConfigReader.get("browser");
	 if(browser.equalsIgnoreCase("chrome")) {
		 
		 ChromeOptions options = new ChromeOptions();
		 boolean isheadless = Boolean.parseBoolean(ConfigReader.get("headless"));
		 if(isheadless) {
			 
		 }
		 
		 driver.set(new ChromeDriver(options));
	 } else if (browser.equalsIgnoreCase("edge"))
	   {
		 
	   }
	 return getDriver();
	}
	
	public static WebDriver getDriver( ){
		return driver.get();
	}
}
