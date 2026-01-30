package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SeleniumUtils;

public class AdminPage {

	private WebDriver driver;
	
	// constructor 
			public AdminPage(WebDriver driver) {
				this.driver=driver;
				
				PageFactory.initElements(driver, this);
			}
			
			// Locators

			@FindBy(xpath = "//span[text()='User Management ']")
			private WebElement userManagementMenu;

			@FindBy(xpath = "//span[text()='Job ']")
			private WebElement jobMenu;
			
			// Actions
			
			public boolean VisibilityOfUserManagementMenu() {
				return SeleniumUtils.seleniumIsDisplayed(driver, userManagementMenu);
			}

			public boolean visibilityOfJobMenu() {
				return SeleniumUtils.seleniumIsDisplayed(driver, jobMenu);
			}

}
