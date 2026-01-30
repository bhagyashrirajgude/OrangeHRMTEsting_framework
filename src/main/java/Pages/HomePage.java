package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SeleniumUtils;

public class HomePage {

	private WebDriver driver;
	
	// constructor 
		public HomePage(WebDriver driver) {
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
		
		// locators 
		
		@FindBy(xpath = "//span[text()='Admin']")
		private WebElement admin;

		@FindBy(xpath = "//span[text()='PIM']")
		private WebElement pim;

		@FindBy(xpath = "//span[text()='Leave']")
		private WebElement leave;

		@FindBy(xpath = "//span[text()='time']")
		private WebElement time;

		@FindBy(xpath = "//span[text()='Recruitment']")
		private WebElement recruitment;

		@FindBy(xpath = "//span[text()='My Info']")
		private WebElement myInfo;

		@FindBy(xpath = "//span[text()='Performance']")
		private WebElement performance;

		@FindBy(xpath = "//span[text()='Dashboard']")
		private WebElement dashboard;

		@FindBy(xpath = "//span[text()='Directory']")
		private WebElement directory;

		@FindBy(xpath = "//span[text()='Maintenance']")
		private WebElement maintenance;

		@FindBy(xpath = "//span[text()='Claim']")
		private WebElement claim;

		@FindBy(xpath = "//span[text()='buzz']")
		private WebElement buzz;

		// Actions
		
		public boolean visibilityOfAdminTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, admin);
		}

		public boolean visibilityOfPimTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, pim);
		}

		public boolean visibilityOfLeaveTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, leave);
		}

		public boolean visibilityOfTimeTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, time);
		}

		public boolean visibilityOfRecruitmentTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, recruitment);
		}

		public boolean visibilityOfMyInfoTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, myInfo);
		}

		public boolean visibilityOfPerformanceTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, performance);
		}

		public boolean visibilityOfDashboardTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, dashboard);
		}

		public boolean visibilityOfDirectoryTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, directory);
		}

		public boolean visibilityOfMaintenanceTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, maintenance);
		}

		public boolean visibilityOfClaimTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, claim);
		}

		public boolean visibilityOfBuzzTab() {
			return SeleniumUtils.seleniumIsDisplayed(driver, buzz);
		}
		
		public void clickToAdminTab() {
			SeleniumUtils.Click(driver, admin);
		}
		
		public String getPageTitle() {
			return driver.getTitle();
		}
}
