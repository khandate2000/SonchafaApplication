package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public WebDriver login() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\Downloads\\Test file\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ith.sonchafaresorts.com/site/index.php");

		driver.findElement(By.id("email")).sendKeys("bk@test.com");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());
		return driver;
	}

}
