package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import Config.ConfigReader;
import Pages.LoginPage;
import Utility.ExcelUtils1;

@Listeners(Listener.TestListener.class)
// Login test
public class LoginTest extends BaseTest {

	LoginPage loginPage; // Reference
	
	SoftAssert soft;
	
	String dataFilepath = System.getProperty("user.dir") + "/src/testdata/dataFile.xlsx";
	
	@Test(priority = 1, enabled=true)
	public void check_LoginPageTitle() throws InterruptedException
	{
		ExcelUtils1.loadExcel(dataFilepath);

		loginPage = new LoginPage(driver); // object of login page
		
		String expectedTitle = ExcelUtils1.getData("LoginCred", 1, 2);	
		System.out.println("Expected Title : " + expectedTitle);
		
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Actual Title : " + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(5000);

	}
	
	@Test(priority = 2, enabled=true)
	public void check_ValidLogin() throws InterruptedException {
		
		loginPage = new LoginPage(driver);   //initilise the driver
	
		// validate the username field is displayed or not	
		boolean actualUserNameField = loginPage.isUserNameFieldIsDisplayed();
		System.out.println(actualUserNameField);
		
		Assert.assertTrue(actualUserNameField);
		
		// validate the password field is displayed or not
		boolean actualpasswordField = loginPage.isPasswordFieldIsDisplayed();
		System.out.println(actualpasswordField);
		
		Assert.assertTrue(actualpasswordField);
		
		// validate the login btn is displayed or not
		boolean actualloginbtn = loginPage.isLoginBtnIsDisplayed();
		System.out.println(actualloginbtn);
		
		Assert.assertTrue(actualloginbtn);
		
		loginPage.Login(ConfigReader.get("userid"), ConfigReader.get("password"));
		Thread.sleep(10000);
	}
	
	@Test(priority = 3, enabled=true)
	public void check_ValidLoginWith_SoftAsser() throws InterruptedException {
		
		soft = new SoftAssert();
		
		loginPage = new LoginPage(driver);   //initilise the driver
		
		boolean actualUserNameField = loginPage.isUserNameFieldIsDisplayed();
		soft.assertTrue(actualUserNameField);
		System.out.println("actualUserNameField :" + actualUserNameField);
		
		boolean actualpasswordField = loginPage.isPasswordFieldIsDisplayed();
		soft.assertFalse(actualpasswordField);     // fail
		System.out.println( "actualpasswordField: " +actualpasswordField);
		
		boolean actualLoginbtnField = loginPage.isLoginBtnIsDisplayed();
		soft.assertTrue(actualLoginbtnField);
        System.out.println("actualLoginbtnField :" + actualLoginbtnField);
        
        loginPage.Login(ConfigReader.get("userid"), ConfigReader.get("password"));
        soft.assertAll("Asserton Execute");
        
        Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getDataForInvaliLogin(){
		
		ExcelUtils1.loadExcel(dataFilepath);
		return ExcelUtils1.getSheetData("DataDriven");
	} 
	
	@Test(priority = 4, enabled=true, dataProvider = "getDataForInvaliLogin")
	public void check_InvalidLogin_withmultipleSet(String username, String password) throws InterruptedException {
		
		ExcelUtils1.loadExcel(dataFilepath);
		loginPage = new LoginPage(driver);   //initilise the driver
		
		loginPage.Login(username, password);
	}
}
