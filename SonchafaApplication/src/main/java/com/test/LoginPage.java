package com.test;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public static void main(String[] args) throws InterruptedException {

		// Disable Chrome save password popup
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("profile.Credentials_enable_service", false);

		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\Downloads\\Test file\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);

		// WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://192.168.29.5/sonchafa/site/index.php");

		driver.findElement(By.id("email")).sendKeys("anup@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Anup@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(4000);
		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println();
		// Click through the menu
		wait.until(ExpectedConditions.elementToBeClickable(By.id("icon-apps"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-clipboard']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_add_user_role"))).click();

		System.out.println("Done!");
		// Add User Role
		driver.findElement(By.id("urt")).sendKeys("TestAuto");
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='urmuri']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Customer");
		Thread.sleep(2000);
		
		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		Thread.sleep(2000);
		submitButton.click();
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='User Roles List']")).click();
		
		
		
	}

}
