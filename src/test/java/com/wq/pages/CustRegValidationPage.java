package com.wq.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.wq.common.Commons;

public class CustRegValidationPage extends Commons{


	//Passing Customer info 
	public static void passCustStepOneInfo(String firstname, String middlename, String lastname, String dob,String gender,String city,String chValue, String phoneNumber) {

		driver.findElement(By.xpath(prop.getProperty("firstName"))).sendKeys(firstname);
		driver.findElement(By.xpath(prop.getProperty("middleName"))).sendKeys(middlename);	
		driver.findElement(By.xpath(prop.getProperty("lastName"))).sendKeys(lastname);
		driver.findElement(By.xpath(prop.getProperty("dob"))).sendKeys(dob);
		Select genderOption = new Select (driver.findElement(By.xpath(prop.getProperty("gender"))));
		genderOption.selectByVisibleText(gender);
		driver.findElement(By.xpath(prop.getProperty("city"))).sendKeys(city);		
		Select chOptions = new Select (driver.findElement(By.xpath(prop.getProperty("creditHistory"))));
		chOptions.selectByVisibleText(chValue);
		driver.findElement(By.xpath(prop.getProperty("phoneNumber"))).sendKeys(phoneNumber);
		driver.findElement(By.xpath(prop.getProperty("continueButton"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static String ValidateStepOnePageWithDetails() {

		driver.navigate().refresh();
		String stepTwoLaunchVerification = driver.findElement(By.xpath("//div[@class ='stepsHeader']//p[@class='title']")).getText();
		return stepTwoLaunchVerification;

	}
	public static String firstNameErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("firstNameErrorMsg"))).getText();
		return errorMsg;

	}
	public static String middleNameErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("middleNameErrorMsg"))).getText();
		return errorMsg;

	}
	public static String lastNameErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("lastNameErrorMsg"))).getText();
		return errorMsg;

	}
	public static String dobErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("dobErrorMsg"))).getText();
		return errorMsg;

	}
	public static String genderErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("genderErrorMsg"))).getText();
		return errorMsg;

	}
	public static String cityErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("cityErrorMsg"))).getText();
		return errorMsg;

	}
	public static String credtiHistoryErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("creditHistoryErrorMsg"))).getText();
		return errorMsg;

	}
	public static String phoneErrorMsg() {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty("phoneErrorMsg"))).getText();
		return errorMsg;

	}
}
