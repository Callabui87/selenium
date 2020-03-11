package test;

import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class Exercise3 {
	public void test_case1() {
		WebDriver driver = new FirefoxDriver();

		// Dang nhap vao site

		driver.get("https://demo.nopcommerce.com/register");

		// Click register
		driver.findElement(By.linkText("New Customer")).click();

		// Add info vao form personal details

		driver.findElement(By.id("gender-female")).click();

		driver.findElement(By.name("FirstName")).sendKeys("Calla");

		driver.findElement(By.name("LastName")).sendKeys("Bui");

		Select drpDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
		drpDay.selectByVisibleText("30");

		Select drpMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		drpMonth.selectByVisibleText("6");

		Select drpYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		drpCountry.selectByVisibleText("1987");

		driver.findElement(By.name("city")).sendKeys("HN");

		driver.findElement(By.name("Email")).sendKeys("calla@test.com");

		driver.findElement(By.name("Company")).sendKeys("VSII");

		driver.findElement(By.name("Newsletter")).click();

		driver.findElement(By.name("Password")).sendKeys("calla306");

		driver.findElement(By.name("ConfirmPassword")).sendKeys("calla306");

		driver.findElement(By.id("register-button")).click();

		driver.findElement(By.xpath("//div[@class='result']")).getText();
		System.out.println("Your registration completed");

		driver.close();

		driver.quit();

	}

}
