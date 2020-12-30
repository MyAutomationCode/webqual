package com.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wq.common.Commons;

public class LandingPage extends Commons{
	
//	public static WebDriver driver = new ChromeDriver();
	public static String validateTitle() {
		
		 return driver.getTitle();
	}
	public static String offersHeading() {
		
		WebElement element = driver.findElement(By.xpath("//*[@class='heading']"));
		return element.getText();
	}
	public static String firstOfferHeading() {
		WebElement element = driver.findElement(By.xpath("//*[@class='feature benefits1']//*[@class='title']"));
		return element.getText();

	}public static String firstOfferContent() {
		WebElement element = driver.findElement(By.xpath("//div[@class='feature benefits1']//p[@class='info']"));
		return element.getText();

	}
	public static String sceondOfferHeading() {
		WebElement element = driver.findElement(By.xpath("//*[@class='feature benefits2']//*[@class='title']"));
		return element.getText();

	}public static String secondOfferContent() {
		WebElement element = driver.findElement(By.xpath("//div[@class='feature benefits2']//p[@class='info']"));
		return element.getText();

	}
	public static String thirdOfferHeading() {
		WebElement element = driver.findElement(By.xpath("//*[@class='feature benefits3']//*[@class='title']"));
		return element.getText();

	}public static String thirdOfferContent() {
		WebElement element = driver.findElement(By.xpath("//div[@class='feature benefits3']//p[@class='info']"));
		return element.getText();

	}
	public static String fourthOfferHeading() {
		WebElement element = driver.findElement(By.xpath("//*[@class='feature benefits4']//*[@class='title']"));
		return element.getText();

	}public static String fourthOfferContent() {
		WebElement element = driver.findElement(By.xpath("//div[@class='feature benefits4']//p[@class='info']"));
		return element.getText();

	}
	public static String fifthOfferHeading() {
		WebElement element = driver.findElement(By.xpath("//*[@class='feature benefits5']//*[@class='title']"));
		return element.getText();

	}public static String fifthOfferContent() {
		WebElement element = driver.findElement(By.xpath("//div[@class='feature benefits5']//p[@class='info']"));
		return element.getText();

	}
	public static WebElement loginButton() {
		WebElement loginButton = driver.findElement(By.xpath("//*[@class='option login']"));
		return loginButton;
		
	}
	public static String regTitle() {
		WebElement element = driver.findElement(By.xpath("//*[@class='stepsHeader']//*[@class='title']"));
		return element.getText();
		
	}
	
	public static boolean verifyScrollbar() {;
	String scrollable = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	WebElement element = driver.findElement(By.xpath("//div[@id='nav']"));
	return (Boolean)jse.executeScript(scrollable, element);

	}
	
}
