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
		driver.get("https://proxify.gg/login");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void login() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.cssSelector("[type=\'email\']")).sendKeys("user1@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type=\'password\']")).sendKeys("6Xw5gf51Z39n");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[class=\'flex items-center gap-2\']")).click();
		Thread.sleep(2000);
		WebElement actualResult =  driver.findElement(By.cssSelector("[class=\'text-sm font-semibold [&+div]:text-xs\']"));
		String expected = "User deleted";
		if(actualResult.getText().equalsIgnoreCase(expected)){
			System.out.println(actualResult.getText());
		}
	}
	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		Thread.sleep(30000);
		driver.findElement(By.cssSelector("[class='text-blue-500 hover:underline']")).click();
		driver.findElement(By.id("username")).sendKeys("Muskan");
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("7ERssaf51Z39n");
		driver.findElement(By.cssSelector("[type=\'submit\']")).click();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
