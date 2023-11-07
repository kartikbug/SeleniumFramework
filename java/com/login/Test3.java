package com.login;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test3 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\drivers\\chromedriver-windows.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);		
		
		driver.get("https://www.google.com");
		WebElement searchBar = driver.findElement(By.xpath("//*[@title='Search']"));
		searchBar.sendKeys("Java");
		action.sendKeys(Keys.ENTER).build().perform();
		/*
		 * WebElement searchBtn =
		 * driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[1]"));
		 * searchBtn.click();
		 */
		
		
		
	}
}
