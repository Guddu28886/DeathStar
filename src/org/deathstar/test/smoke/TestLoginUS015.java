package org.deathstar.test.smoke;

import org.deathstar.config.CreateDriver;
import org.deathstar.utils.GetData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deathstar.ui.HomePage;
import com.deathstar.ui.LoginPage;
// Step 1
public class TestLoginUS015 
{
	// Step 2
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	// Step 3
	@BeforeMethod
	public void setUp()
	{
		driver = CreateDriver.getDriverInstance();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}
	// Step 4
	@Test
	public void testLoginValidTC051()
	{
		String un = GetData.fromExcel("data", "US015", 1, 0);
		String pwd = GetData.fromExcel("data", "US015", 1, 1);
		loginpage.waitForLoginPage();
		loginpage.getUsernameTextbox().sendKeys(un);
		loginpage.getPasswordTextbox().sendKeys(pwd);
		loginpage.getLoginButton().click();
		homepage.waitForHomePage();
		boolean actualStatus = 
				homepage.getLogoutButton().isDisplayed();
		boolean expectedStatus = true;
		Assert.assertEquals(actualStatus, expectedStatus);
		homepage.getLogoutButton().click();
	}
	// Step 5
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
