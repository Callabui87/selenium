package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Exercise3 {

	@Test
	public void test_case1() {
		WebDriver driver = new FirefoxDriver();

		// Dang nhap vao site

		driver.get("https://demo.nopcommerce.com/register");

		// Add info vao form personal details

		driver.findElement(By.id("gender-female")).click();

		driver.findElement(By.name("FirstName")).sendKeys("Calla");

		driver.findElement(By.name("LastName")).sendKeys("Bui");

		Select drpDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
		drpDay.selectByVisibleText("30");

		Select drpMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		drpMonth.selectByVisibleText("June");

		Select drpYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		drpYear.selectByVisibleText("1987");

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
