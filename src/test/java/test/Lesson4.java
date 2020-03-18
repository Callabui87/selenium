package test;

import static org.testng.Assert.assertEquals;

import java.util.List;
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
	public void TC1() throws Exception {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String message = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
		assertEquals(message, "Congratulations! You must have the proper credentials.");
		System.out.println("Completed");

	}

	@Test(enabled = false)
	public void TC2() throws Exception {
		driver.get("http://www.myntra.com");

		WebElement discover = driver.findElement(By.xpath("//a[text()='Discover']"));

		Actions action = new Actions(driver);
		action.moveToElement(discover).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='American Eagle']")).click();

		System.out.println("verify đã chuyển page thành công");
		assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/american-eagle");

	}

	@Test(enabled = false)
	public void TC3() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		WebElement element1 = driver.findElement(By.xpath("//li[text()=1]"));
		WebElement element4 = driver.findElement(By.xpath("//li[text()=4]"));
		Actions action = new Actions(driver);
		action.clickAndHold(element1).moveToElement(element4).release().build().perform();

	}

	@Test(enabled = false)
	public void TC5() throws Exception {
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

	@Test(enabled = true)
	public void TC6() throws Exception {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		Thread.sleep(5000);

		Actions action = new Actions(driver);

		WebElement smallcircle = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement bigcircle = driver.findElement(By.xpath("//div[@id='droptarget']"));

		action.clickAndHold(smallcircle).moveToElement(bigcircle).release().build().perform();

		String message = driver.findElement(By.xpath("//div[text()='You did great!']")).getText();
		assertEquals(message, "You did great!");
		System.out.println("Completed");
		Thread.sleep(5000);
	}

	@Test(enabled = false)
	public void TC4_1() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		Thread.sleep(5000);
		// Xac dinh cac nut click
		WebElement o1 = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement o2 = driver.findElement(By.xpath("//li[text()='5']"));
		WebElement o3 = driver.findElement(By.xpath("//li[text()='9']"));

		// Thao tac click cac nut
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(o1).click(o2).click(o3).build().perform();

		// Verify cac nut da duoc chon hay chua & tim ra nut chua chon duoc

		/*
		 * String chuoi = "ui-state-default ui-selectee ui-selected";// gia tri class
		 * cac o duoc chon boolean a = o1.getAttribute("class").equals(chuoi); boolean b
		 * = o2.getAttribute("class").equals(chuoi); boolean c =
		 * o3.getAttribute("class").equals(chuoi);
		 * 
		 * if (a == true && b == true && c == true) {
		 * System.out.println("Cac o da duoc chon"); } else {
		 * System.out.println("Co o chưa duoc chon"); }
		 */
		List<WebElement> list = driver
				.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
		// String teno = list.get(1).getText();

		for (WebElement x : list) {
			System.out.println("Chuoi la" + x.getText());
		}

		Thread.sleep(10000);

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
