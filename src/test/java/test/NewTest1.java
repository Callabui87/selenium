package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;
	String homePageUrl;
	String homePageTitle;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("htpps://demo.guru99.com/V4/index.php");
		homePageUrl = driver.getCurrentUrl();
		homePageTitle = driver.getTitle();
		Boolean b0k = driver.findElement(By.xpath("")).isDisplayed();
		Boolean b0k1 = driver.findElement(By.xpath("")).isSelected();
		Boolean b0k2 = driver.findElement(By.xpath("")).isEnabled();

	}

	@Test
	public void f() throws InterruptedException {
		System.out.println(homePageUrl);
		System.out.println(homePageTitle);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
