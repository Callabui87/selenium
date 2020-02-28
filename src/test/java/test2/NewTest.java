package test2;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class NewTest {
    WebDriver driver;
 
    @BeforeTest
    public void beforeTest() {
        // Bat firefox
        driver = new FirefoxDriver();
        // maximize window
        driver.manage().window().maximize();
        // them thoi gian cho` cho => findElement = 30s > het 30s thi TimeOutException
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // vao trang live.guru99
        driver.get("http://live.guru99.com/");
 
    }
 
    @Test
    public void test_case1() {
        // click vao My Account o footer = xpath
        System.out.println("click vao My Account o footer = xpath");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        
        // verify url login page
        System.out.println("verify url login page");
        assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
        
        // click vao create account bang xpath
        System.out.println("click vao create account bang xpath");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        
        // verify url create account
        System.out.println("verify url create account");
        assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
 
    }
    
    @Test
    public void test_case2() {
        // click vao My Account o footer = xpath
        System.out.println("click vao My Account o footer = xpath");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        
        // Verify title cua Login Page 
        System.out.println("verify title login page");
        assertEquals(driver.getTitle(), "Customer Login");
        
        // click vao create account bang xpath
        System.out.println("click vao create account bang xpath");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        
        // Verify title cua Register Page 
        System.out.println("Verify title cua Register Page ");
        assertEquals(driver.getTitle(), "Create New Customer Account");
        
        
    }
    
    @Test
    public void test_case3() {
    	
    }
 
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        // dong browser
        driver.quit();
    }
 
}
