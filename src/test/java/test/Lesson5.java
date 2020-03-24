package test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lesson5 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = true)
	public void sendkey() throws Exception {

		String upload1 = "C:\\Users\\nsd\\Downloads\\2020-03-10_1318.png";
		driver.findElement(By.xpath("//span[text()='Add files...']/following-sibling::input")).sendKeys(upload1);
		String s = driver.findElement(By.xpath("//td/p")).getText();
		Thread.sleep(3000);

		System.out.println("File upload :" + s);
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/table/tbody/tr/td[4]/button[2]/span")).click();
		Thread.sleep(2000);

		String image = driver.findElement(By.xpath("//span[@class='preview']/a")).getAttribute("title");
		System.out.println("File da upload:" + image);
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void AutoIT() throws Exception {

		driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();

		Runtime.getRuntime().exec("C:\\Users\\nsd\\Downloads\\AutoIT\\Uploadfile.exe");

	}

	@Test(enabled = false)
	public void Robotclass() throws Exception {

		// Specify the file location with extension
		StringSelection upload1 = new StringSelection("C:\\Users\\nsd\\Downloads\\2020-03-10_1318.png");

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload1, null);
		System.out.println("selection" + upload1);

		driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();

		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(5000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
