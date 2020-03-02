package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Exercise2 {
	@Test
	public void test_case1() {
		WebDriver driver = new FirefoxDriver();

		// Dang nhap vao site

		driver.get("https://demo.guru99.com/V4/index.php");
		// nhap user/password

		driver.findElement(By.name("uid")).sendKeys("mngr248382");

		driver.findElement(By.name("password")).sendKeys("paruqyr");

		driver.findElement(By.name("btnLogin")).click();

		// Click New customer
		driver.findElement(By.linkText("New Customer")).click();

		// Add info vao form new customer
		driver.findElement(By.name("name")).sendKeys("Calla");

		driver.findElement(By.name("f")).click();

		driver.findElement(By.name("phone")).sendKeys("123456789");

		driver.findElement(By.name("addr")).sendKeys("BTL");

		driver.findElement(By.name("city")).sendKeys("HN");

		driver.findElement(By.name("state")).sendKeys("TX");

		driver.findElement(By.name("pino")).sendKeys("1234564544");

		driver.findElement(By.name("emailid")).sendKeys("calla@test.com");

		driver.findElement(By.name("password")).sendKeys("calla306");

		driver.findElement(By.name("sub")).click();

		driver.close();

		driver.quit();

	}

}
