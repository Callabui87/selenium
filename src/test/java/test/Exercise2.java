package test;

import java.util.Random;

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
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();

		// Add info vao form new customer
		driver.findElement(By.name("name")).sendKeys("Calla");

		driver.findElement(By.xpath("//input[@value='f']")).click();

		driver.findElement(By.name("dob")).sendKeys("1987-06-06");

		driver.findElement(By.name("telephoneno")).sendKeys("12345678987");

		driver.findElement(By.name("addr")).sendKeys("BTL");

		driver.findElement(By.name("city")).sendKeys("HN");

		driver.findElement(By.name("state")).sendKeys("TX");

		driver.findElement(By.name("pinno")).sendKeys("123456");

		String email = "calla" + randomNumber() + "@gmail.com";
		driver.findElement(By.name("emailid")).sendKeys(email);

		driver.findElement(By.name("password")).sendKeys("calla306");

		driver.findElement(By.name("sub")).click();

		// verify info has been created successfully

		String message = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText();
		System.out.println(message);

		String name = driver.findElement(By.name("name")).getAttribute("value");
		System.out.println(name);

		// System.out.println("Is Displayed" +
		// driver.findElement(By.xpath("//input[@value='f']")).isDisplayed());
		String gender = driver.findElement(By.xpath("//input[@value='f']")).getText();
		System.out.println(gender);

		String dob = driver.findElement(By.name("dob")).getAttribute("Value");
		System.out.println(dob);

		String phone = driver.findElement(By.name("telephoneno")).getAttribute("Value");
		System.out.println(phone);

		String address = driver.findElement(By.name("addr")).getAttribute("Value");
		System.out.println(address);

		String city = driver.findElement(By.name("city")).getAttribute("Value");
		System.out.println(city);

		String state = driver.findElement(By.name("state")).getAttribute("Value");
		System.out.println(state);

		String pin = driver.findElement(By.name("pino")).getAttribute("Value");
		System.out.println(pin);

		String emailaddress = driver.findElement(By.name("emailid")).getAttribute("Value");
		System.out.println(emailaddress);

		String password = driver.findElement(By.name("password")).getAttribute("Value");
		System.out.println(password);

		driver.close();

		driver.quit();

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
