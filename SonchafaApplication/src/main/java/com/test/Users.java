package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Users {
    public static void main(String[] args) throws InterruptedException {
        // Create LoginPage object
        LoginPage lg = new LoginPage();
       // lg.Loginpage();
        
        // Call login method and get the same driver session
        WebDriver driver = lg.login(); // <-- Make sure LoginPage method returns WebDriver
        driver.switchTo().alert().dismiss();
        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click through the menu
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_link_users"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_manage_user_role_has_child"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_add_user_role"))).click();

        System.out.println("Done!");
        driver.quit();
    }
}
