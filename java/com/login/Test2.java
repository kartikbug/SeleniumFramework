package com.login;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws Exception {
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\Testing\\drivers\\chromedriver-windows.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://nxtgenaiacademy.com/multiplewindows/");
    	String mainWindow = driver.getWindowHandle();
    	
    	driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
    	
    	Set<String> allWindows = driver.getWindowHandles();
    	
    	for(String window : allWindows)
    	{
    		if(!window.equals(mainWindow))
    		{
    			driver.switchTo().window(window);
    			driver.findElement(By.linkText("Python for Automation")).click();
    			driver.close();
    		}
    	}
        
    	driver.switchTo().window(mainWindow);
    	driver.findElement(By.linkText("Home")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.quit();
    }
}
