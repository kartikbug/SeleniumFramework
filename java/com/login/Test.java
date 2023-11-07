package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Testing\\drivers\\chromedriver-windows.exe");

        // Initialize the WebDriver and open the website
        WebDriver driver = new ChromeDriver();
        driver.get("https://nxtgenaiacademy.com/multiplewindows/");

        // Get the handle of the parent window
        String parentWindowHandle = driver.getWindowHandle();

        // Find and click on a link that opens a new window
        WebElement newWindowLink = driver.findElement(By.xpath("//button[text()='New Browser Window']"));
        newWindowLink.click();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through window handles and switch to the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
                Thread.sleep(100);
                driver.findElement(By.linkText("Python for Automation")).click();
                driver.close();
            }
        }

        // Switch back to the parent window
        driver.switchTo().window(parentWindowHandle);

        // Perform actions in the parent window
        // For example, interact with elements in the parent window
        WebElement parentWindowElement = driver.findElement(By.linkText("Home"));
        parentWindowElement.click();

        // Close the WebDriver
        driver.quit();
    }
}
