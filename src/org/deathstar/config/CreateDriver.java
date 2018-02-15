package org.deathstar.config;

import java.util.concurrent.TimeUnit;

import org.deathstar.utils.GetData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	
	public static WebDriver getDriverInstance()
	{
		String browserName = GetData.fromProperties("config", "browser");
		String url = GetData.fromProperties("config", "url");
		WebDriver driver= null;
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",
					"./borowser-server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./borowser-server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("Invalid Browser Selection");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
