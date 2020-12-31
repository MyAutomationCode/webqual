package com.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wq.common.Commons;

public class LandingPage extends Commons{
	
	public static String validateTitle() {
		
		 return driver.getTitle();
	}
	
	public static String uiValidations(String value) throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(prop.getProperty(value)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}
	
	
	
	public static boolean verifyScrollbar() {;
	String scrollable = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";
	WebElement element = driver.findElement(By.xpath("//div[@id='nav']"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	return (Boolean)jse.executeScript(scrollable, element);

	}
	
}
