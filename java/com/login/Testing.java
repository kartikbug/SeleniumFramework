package com.login;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\drivers\\chromedriver-windows.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		Set<String> windows = driver.getWindowHandles();
		
		for(String window : windows)
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
		driver.quit();
	}
}
