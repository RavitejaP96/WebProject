package com.orbitz.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Base class to maintain WebDriver main object and Opening and Closing browser
 * 
 * @author Raviteja.palnati
 * @Param(browser)
 *
 */

public class Base {

	public WebDriver driver; /* WebDriver main object */

	
	@Parameters("browser")
    @BeforeMethod
    public void StartUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get("https://www.orbitz.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Opened application");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Browser Closed");
	}

}
