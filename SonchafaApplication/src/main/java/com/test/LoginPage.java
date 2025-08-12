package com.test;

import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shree\\Downloads\\Test file\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        // Disable Google password breach warning
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void handleBreachPopup() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement okButton = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='OK']") // Works if popup is HTML-based
            ));
            okButton.click();
            System.out.println("Password breach popup closed.");
        } catch (Exception e) {
            System.out.println("No password breach popup found.");
        }
    }

    public WebDriver login() {
        driver.manage().window().maximize();
        driver.get("https://ith.sonchafaresorts.com/site/index.php");

        handleBreachPopup(); // Try to close popup if it appears

        driver.findElement(By.id("email")).sendKeys("bk@test.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("Dashboard.php"));

        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        WebDriver driver = loginPage.login();
        loginPage.closeBrowser();
    }
}
