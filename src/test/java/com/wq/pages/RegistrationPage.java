package com.wq.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wq.common.Commons;
import com.wq.utils.Constants;

public class RegistrationPage extends Commons{
	
	Constants c = new Constants();

	//Passing Customer info 
	public static void passCustStepOneInfo(String firstname, String middlename, String lastname, String dob,String gender,
			String city,String chValue, String phoneNumber) {

		driver.findElement(By.xpath(prop.getProperty(Constants.FISRTNAME))).sendKeys(firstname);
		driver.findElement(By.xpath(prop.getProperty(Constants.MIDDLENAME))).sendKeys(middlename);	
		driver.findElement(By.xpath(prop.getProperty(Constants.LASTNAME))).sendKeys(lastname);
		driver.findElement(By.xpath(prop.getProperty(Constants.DOB))).sendKeys(dob);
		Select genderOption = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.GENDER))));
		genderOption.selectByVisibleText(gender);
		driver.findElement(By.xpath(prop.getProperty(Constants.CITY))).sendKeys(city);		
		Select chOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CREDIT_HISTORY))));
		chOptions.selectByVisibleText(chValue);
		driver.findElement(By.xpath(prop.getProperty(Constants.PHONE))).sendKeys(phoneNumber);
		driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).click();

	}
	public static void passCustStepTwoInfo(String residenceType, String residenceAge, String cityAge,String address1,
			String address2, String pincode) {
		
		
		Select residenceTypeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.RESIDENCE_TYPE))));
		residenceTypeOptions.selectByVisibleText(residenceType);
		Select residenceAgeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_RESIDENCE_AGE))));
		residenceAgeOptions.selectByVisibleText(residenceAge);
		Select cityAgeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_CITY_AGE))));
		cityAgeOptions.selectByVisibleText(cityAge);
		driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_ONE))).sendKeys(address1);
		driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_TWO))).sendKeys(address2);
		driver.findElement(By.xpath(prop.getProperty(Constants.PINCODE))).sendKeys(pincode);	
		driver.findElement(By.xpath(prop.getProperty("continueButton"))).click();
		
	}

	public static String ValidateNextPage(String verifyCustRegStep) {

		driver.navigate().refresh();
		String stageVerification = driver.findElement(By.xpath(prop.getProperty(verifyCustRegStep))).getText();
		return stageVerification;

	}
	public static String errorMsgValidation(String errorValue) {		

		String errorMsg =driver.findElement(By.xpath(prop.getProperty(errorValue))).getText();	
		return errorMsg;
		}
}
