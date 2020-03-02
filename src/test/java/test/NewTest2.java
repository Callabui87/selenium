package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("htpps://demo.guru99.com/V4/index.php");

	}

	@Test
	public void f() throws InterruptedException {
		Thread.sleep(5000);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}