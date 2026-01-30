package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private static final int DEFAULT_TIMEOUT = 15;
	
	public static void pageLoadTimeout(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	public static void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void scrollVertically(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("window.scrollBy(0,"+ pixel + ")");
	}
	
	public static void scrollHorizontally(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("window.scrollBy("+ pixel + ",0)");     // (pixel, 0)
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {      // scroll until find the element on the page
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("arguments[0].scrollIntoView(true)" + element);     // (pixel, 0)
	}
	
	public static String takeScreenshot(WebDriver driver, String fileName) {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());  
		
		String path = System.getProperty("user.dir")+ "/Screenshot/" + fileName + "_" + timestamp + ".png";
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcFile, new File(path));
		} catch (IOException e) {
			System.out.println("X Screenshot capture failed :" + e.getMessage());
			e.printStackTrace();
		}
		return path;
	}
	
	public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void switchToFrame(WebDriver driver, WebElement frameElement ) {
		driver.switchTo().frame(frameElement);
	}
	
	public static void switchToDefaultContent(WebDriver driver ) {
		driver.switchTo().defaultContent();
	}
	
	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		
		action.moveToElement(element).doubleClick().build().perform();
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		
		action.moveToElement(element).build().perform();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(ele).click().sendKeys(text).build().perform();
	}
	
	public static void Click(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public static boolean seleniumIsDisplayed(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	
	public static void seleniumSendKeys(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		
		ele.clear();
		ele.sendKeys(text);
		
	}
}
