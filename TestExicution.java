package proxify;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.util.count.report.qual.ReportWrite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestExicution {
	WebDriver driver;
	@BeforeTest
	public void url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://proxify.gg/login"); // for visit the url
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); // take time for all elements
	}
	@Test(priority = 0)
	public void login() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.cssSelector("[type=\'email\']")).sendKeys("user1@gmail.com"); // For Email
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type=\'password\']")).sendKeys("6Xw5gf51Z39n"); // For password
		Thread.sleep(5000);
		// Click on captcha manually
		driver.findElement(By.cssSelector("[class=\'flex items-center gap-2\']")).click(); // Click on login button
		Thread.sleep(2000);
		
		WebElement actualResult =  driver.findElement(By.cssSelector("[class=\'text-sm font-semibold [&+div]:text-xs\']"));// Assert the error message
		String expected = "User deleted";
		if(actualResult.getText().equalsIgnoreCase(expected)){
			System.out.println(actualResult.getText());
		}
	}
	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		Thread.sleep(30000);
		driver.findElement(By.cssSelector("[class='text-blue-500 hover:underline']")).click(); // Click on sign in link
		driver.findElement(By.id("username")).sendKeys("Muskan"); // for username
		driver.findElement(By.id("email")).sendKeys("user1@gmail.com"); // for email
		driver.findElement(By.id("password")).sendKeys("6Xw5gf51Z39n"); // for password
		driver.findElement(By.cssSelector("[type=\'submit\']")).click(); // click on sign button
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
