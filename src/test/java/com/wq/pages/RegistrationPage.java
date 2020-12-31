package com.wq.pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class RegistrationPage extends Commons{

	Constants c = new Constants();
	
	//Reusing the same data for final submission test cases
	public static String phoneNumber = "7000000800";
	public static String panNumber = "CKOPW4009F";


	//Passing Customer info for step-1 reg page
	
	public static void passCustStepOneInfo(String firstname, String middlename, String lastname, String dob,String gender,
			String city,String chValue, String phoneNumber) {

		driver.findElement(By.xpath(prop.getProperty(Constants.FIRSTNAME))).sendKeys(firstname);
		driver.findElement(By.xpath(prop.getProperty(Constants.MIDDLENAME))).sendKeys(middlename);	
		driver.findElement(By.xpath(prop.getProperty(Constants.LASTNAME))).sendKeys(lastname);
		driver.findElement(By.xpath(prop.getProperty(Constants.DOB))).sendKeys(dob);
		Select genderOption = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.GENDER))));
		genderOption.selectByVisibleText(gender);
		driver.findElement(By.xpath(prop.getProperty(Constants.CITY_OF_RESIDENCE))).sendKeys(city);		
		Select chOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CREDIT_HISTORY))));
		chOptions.selectByVisibleText(chValue);
		driver.findElement(By.xpath(prop.getProperty(Constants.PHONE))).sendKeys(phoneNumber);
		driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).click();

	}
	
	//Passing Customer info for step-2 reg page

	public static void passCustStepTwoInfo(String residenceType, String residenceAge, String cityAge,String address1,
			String address2, String pincode) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select residenceTypeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.RESIDENCE_TYPE))));
		residenceTypeOptions.selectByVisibleText(residenceType);
		Select residenceAgeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_RESIDENCE_AGE))));
		residenceAgeOptions.selectByVisibleText(residenceAge);
		Select cityAgeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_CITY_AGE))));
		cityAgeOptions.selectByVisibleText(cityAge);
		driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_ONE))).sendKeys(address1);
		driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_TWO))).sendKeys(address2);
		driver.findElement(By.xpath(prop.getProperty(Constants.PINCODE))).sendKeys(pincode);	
		driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).click();

	}
	
	//Passing Customer info for step-3 reg page

	public static void passCustStepThreeInfo(String companyName, String companyType, String designation, String panNumber, 
			String jobType, String totalWorkExp, String currentCompanyExp, String officeEmail, String salary, 
			String salaryMode, String bankName) {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty(Constants.COMPANY_NAME))).sendKeys(companyName);
		Select companyTypeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.COMPANY_TYPE))));
		companyTypeOptions.selectByVisibleText(companyType);
		driver.findElement(By.xpath(prop.getProperty(Constants.DESIGNATION))).sendKeys(designation);
		driver.findElement(By.xpath(prop.getProperty(Constants.PAN))).sendKeys(panNumber);
		Select jobTyepOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.JOB_TYPE))));
		jobTyepOptions.selectByVisibleText(jobType);
		Select TotalworkExpOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.TOTAL_WORK_EXP))));
		TotalworkExpOptions.selectByVisibleText(totalWorkExp);
		Select currentWorkExpOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_WORK_EXP))));
		currentWorkExpOptions.selectByVisibleText(currentCompanyExp);
		driver.findElement(By.xpath(prop.getProperty(Constants.OFFICE_EMAIL))).sendKeys(officeEmail);
		driver.findElement(By.xpath(prop.getProperty(Constants.SALARY))).sendKeys(salary);
		Select salaryModeOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.SALARY_MODE))));
		salaryModeOptions.selectByVisibleText(salaryMode);
		Select bankNameOptions = new Select (driver.findElement(By.xpath(prop.getProperty(Constants.BANK_NAME))));
		bankNameOptions.selectByVisibleText(bankName);
		driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).click();
	}
	
    //Validating next page title
	public static String validateNextPageTitle(String verifyCustRegStepTitle) throws InterruptedException {

		Thread.sleep(2000);
		driver.navigate().refresh();
		String stageVerification = driver.findElement(By.xpath(prop.getProperty(verifyCustRegStepTitle))).getText();
		return stageVerification;

	}
	
	//Error validation method
	public static String errorMsgValidation(String errorValue)  {		

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty(errorValue)))));
		String errorMsg =(driver.findElement(By.xpath(prop.getProperty(errorValue)))).getText();	
		return errorMsg;
	}

	
	//This method calls for particular city field and given the records
	public static List<WebElement> autoCompleteCityList(String value) {

		driver.findElement(By.xpath(prop.getProperty(Constants.CITY_OF_RESIDENCE))).sendKeys(value);
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(prop.getProperty(Constants.AUTO_COMPLETE_CITY_LIST)));
		return autoCompleteList;
	}
	
	//This method calls for particular companyName field and given the records
	public static List<WebElement> autoCompleteCompanyList(String value) {

		driver.findElement(By.xpath(prop.getProperty(Constants.COMPANY_NAME))).sendKeys(value);
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(prop.getProperty(Constants.AUTO_COMPLETE_COMPANY_LIST)));
		return autoCompleteList;
	}
	
	//This method calls for particular Designation field and given the records
	public static List<WebElement> autoCompleteDesignationList(String value) {

		driver.findElement(By.xpath(prop.getProperty(Constants.DESIGNATION))).sendKeys(value);
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(prop.getProperty(Constants.AUTO_COMPLETE_DESIGNATION_LIST)));
		return autoCompleteList;
	}
	
	//This method calls while executing the file step
	public static void FinalSubmissionPage(String phone, String otp, String promoCode) {

		driver.findElement(By.xpath(prop.getProperty(Constants.MOBILE_NO))).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.xpath(prop.getProperty(Constants.MOBILE_NO))).sendKeys(phone);
		driver.findElement(By.xpath(prop.getProperty(Constants.OTP))).sendKeys(otp);
		driver.findElement(By.xpath(prop.getProperty(Constants.PROMO_CODE))).sendKeys(promoCode);
		if(phone != "" && otp != "") {
			RegistrationPage.checkBoxSelection(Constants.TERMS_AND_CONDITIONS_CHECK_BOX);
		}
		driver.findElement(By.xpath(prop.getProperty(Constants.CHECK_LIMIT_BTN))).click();

	}
	
	//This method will call when we want to perform unique actions for some field validations
	public static void checkBoxSelection(String value) {
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty(value)))));
		driver.findElement(By.xpath(prop.getProperty(value))).click();
		
	}

	
	//Generic methods used to complete step-1 and step-2 when test scripts are running for step-2 and step-3 cust reg pages respectively
	public static void completeStepOne() {

		RegistrationPage.passCustStepOneInfo("john","Abhraham","Mohammad","20/07/1992","Male","Bangalore","I have an active loan",phoneNumber);
	}

	public static void complteStepTwo() {

		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years","14-s,M layout","Kalkere","560043");
	}

	public static void completeStepThree() {
		RegistrationPage.passCustStepThreeInfo("MUDRA", "Multinational", "DESIGN ENGINEER", panNumber, "Salaried", "More than 3 years", "More than 3 years", "abcd@moneytap.com", 
				"56000", "Netbanking", "ICICI Bank");

	}

	/*
	public static String custStepVerification(String verifycustRegStep) {

		driver.findElement(By.xpath(prop.getProperty(Constants.STEP_TWO_PAGE))).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String notificationMsg = driver.findElement(By.xpath(prop.getProperty(Constants.STEP_NOTIFICATION))).getText();
		return notificationMsg;

	}
	 */

}

