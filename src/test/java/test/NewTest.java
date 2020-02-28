package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("https://google.com.vn");
	  
	  driver.manage().window().maximize();
	  
	  driver.close();
	  
	  driver.quit();
  }

  @Test
  private void f() {
	System.out.println(driver.getCurrentUrl()+"---------");
    driver.findElement(By.xpath("")).getTagName();
}
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
