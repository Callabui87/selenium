package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lession3 {

	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		WebDriver driver = new FirefoxDriver();

		// Launch website
		driver.navigate().to("http://www.google.com/");

		// Click on the search text box and send value
		driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");

		// Click on the search button
		driver.findElement(By.name("btnK")).click();

	}

}