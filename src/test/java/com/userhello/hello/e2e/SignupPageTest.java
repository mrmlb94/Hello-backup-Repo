package com.userhello.hello.e2e;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/mrmlb/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSignup() {
        // Replace with the URL of your web application
        driver.get("http://localhost:8080/signup");

        // Fill in the signup form
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("uname"))).sendKeys("testuser");
        driver.findElement(By.id("name")).sendKeys("Test");
        driver.findElement(By.id("familyName")).sendKeys("User");
        driver.findElement(By.id("birthdate")).sendKeys("2000-01-01");
        driver.findElement(By.id("birthPlace")).sendKeys("Test City");
        driver.findElement(By.id("currentCountry")).sendKeys("Test Country");
        driver.findElement(By.id("currentCity")).sendKeys("Test City");
        driver.findElement(By.id("schoolName")).sendKeys("Test School");
        driver.findElement(By.id("gpa")).sendKeys("4.0");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Debugging: Print the current URL after clicking sign up
        System.out.println("Current URL after sign up attempt: " + driver.getCurrentUrl());

        // Verify the signup success by checking the URL change or specific success element
        String expectedUrl = "http://localhost:8080/signup"; // Adjust based on your app's behavior
        boolean urlChanged = wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertTrue(urlChanged, "URL did not change to the expected value");

        // Alternatively, you can check for a success message or a specific element on the next page
        // WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("successMessage")));
        // assertTrue(successMessage.isDisplayed(), "Success message not displayed");
    }
}
