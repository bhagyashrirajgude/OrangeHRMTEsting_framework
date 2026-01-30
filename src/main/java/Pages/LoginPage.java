package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SeleniumUtils;

public class LoginPage {

	private WebDriver driver;
	
	// constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	// locators
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	// Actions
	
	public void inputUserName(String name) {

		SeleniumUtils.sendKeys(driver, username, name);
	}
	
	public void inputPassword(String pass) {

		SeleniumUtils.sendKeys(driver, password, pass);
	}
	
	public void clickToLoginBtn() {

		SeleniumUtils.Click(driver, loginBtn);
	}
	
	public boolean isUserNameFieldIsDisplayed() {
		return SeleniumUtils.seleniumIsDisplayed(driver, username);
	}
	
	public boolean isPasswordFieldIsDisplayed() {
		return SeleniumUtils.seleniumIsDisplayed(driver, password);
	}

	public boolean isLoginBtnIsDisplayed() {
		return SeleniumUtils.seleniumIsDisplayed(driver, loginBtn);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void Login(String name, String pass) throws InterruptedException {
		
		inputUserName(name);
		Thread.sleep(4000);
		inputPassword(pass);
		Thread.sleep(4000);
		clickToLoginBtn();
	}
	
	public void invalidLogin(String name, String pass) {
		inputUserName(name);

		inputPassword(pass);

		clickToLoginBtn();
	}
}
