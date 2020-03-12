package test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lesson4 {
	WebDriver driver;

	@Test(enabled = false)
	public void Authenalert() throws Exception {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.xpath("//div[@class='example']/p")).getText();
		System.out.println("Congratulations! You must have the proper credentials.");
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void HoverElement1() throws Exception {
		driver.get("http://www.myntra.com");

		WebElement discover = driver.findElement(By.linkText("Discover"));

		Actions action = new Actions(driver);
		action.moveToElement(discover).build().perform();

		driver.findElement(By.xpath("//a[text()='American Eagle']")).click();

		System.out.println("verify đã chuyển page thành công");
		assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/american-eagle/");

	}

	@Test(enabled = false)
	public void clickandhold() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		WebElement element1 = driver.findElement(By.xpath("//li[text()=1]"));
		WebElement element4 = driver.findElement(By.xpath("//li[text()=4]"));
		Actions action = new Actions(driver);
		action.clickAndHold(element1).moveToElement(element4).release().build().perform();

	}

	@Test(enabled = false)
	public void mouseandkeyboard() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		WebElement element1 = driver.findElement(By.xpath("//li[text()=1]"));
		WebElement element3 = driver.findElement(By.xpath("//li[text()=3]"));
		WebElement element5 = driver.findElement(By.xpath("//li[text()=5]"));
		WebElement element7 = driver.findElement(By.xpath("//li[text()=7]"));
		WebElement element9 = driver.findElement(By.xpath("//li[text()=9]"));
		Actions action = new Actions(driver);
		action.keyDown(element1, Keys.CONTROL);
		action.keyDown(element3, Keys.CONTROL);
		action.keyDown(element5, Keys.CONTROL);
		action.keyDown(element7, Keys.CONTROL);
		action.keyDown(element9, Keys.CONTROL);
		action.build().perform();

		element1.isSelected();
		element3.isSelected();
		element5.isSelected();
		element7.isSelected();
		element9.isSelected();

	}

	@Test(enabled = false)
	public void HoverElement2() throws Exception {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		// Right click vào “right click me”
		WebElement elementRightClick = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions action = new Actions(driver);
		action.contextClick(elementRightClick).perform();

		// Verify menu đượchiểnthị
		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']")).isDisplayed();

		// Click vào “copy”
		driver.findElement(By.xpath("//li/span[text()='Copy']")).click();

		// Verify alert hiển thị thông báo => clicked: copy

		Alert alert = driver.switchTo().alert();
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		Thread.sleep(5000);

		driver.switchTo().alert().accept();

	}

	@Test(enabled = false)
	public void Dradanddrop() throws Exception {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		Thread.sleep(5000);

		Actions action = new Actions(driver);

		WebElement smallcircle = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement bigcircle = driver.findElement(By.xpath("//div[@id='droptarget']"));

		action.clickAndHold(smallcircle).moveToElement(bigcircle).release().build().perform();

		String message = driver.findElement(By.xpath("//div[text()='You did great!']")).getText();
		System.out.println(message);

	}

	@BeforeTest
	public void beforeTest() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
