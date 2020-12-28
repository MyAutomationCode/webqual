package com.wq.stepdefinations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.pages.RegistrationPage;
import com.wq.utils.Constants;

import io.cucumber.java.en.*;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;

public class CustRegFieldValidation extends Commons{

	CustRegDataValidation page = new CustRegDataValidation();

	@Given("user launched the moneytap webqual page")
	public void user_launched_the_moneytap_webqual_page() {
		Commons.browserInitialization();
	}

	//test cases for step 1

	@Then("verify firstname text field")
	public void verify_firstname_text_field() {

		Boolean firstname = driver.findElement(By.xpath(prop.getProperty(Constants.FIRSTNAME))).isEnabled();
		Assert.assertTrue(firstname);
	}

	@Then("verify middlename text field")
	public void verify_middlename_text_field() {

		Boolean middlename = driver.findElement(By.xpath(prop.getProperty(Constants.MIDDLENAME))).isEnabled();
		Assert.assertTrue(middlename);
	}

	@Then("verify lastname text field")
	public void verify_lastname_text_field() {

		Boolean lastname = driver.findElement(By.xpath(prop.getProperty(Constants.LASTNAME))).isEnabled();
		Assert.assertTrue(lastname);
	}

	@Then("verify dob text field")
	public void verify_dob_text_field () {

		Boolean dob = driver.findElement(By.xpath(prop.getProperty(Constants.DOB))).isEnabled();
		Assert.assertTrue(dob);
	}

	@Then("verify gender dropdown field")
	public void verify_gender_dropdown_field() {

		Boolean gender = driver.findElement(By.xpath(prop.getProperty(Constants.GENDER))).isEnabled();
		Assert.assertTrue(gender);
	}

	@Then("verify city of residence text field")
	public void verify_city_of_residence_text_field() {

		Boolean city = driver.findElement(By.xpath(prop.getProperty(Constants.CITY_OF_RESIDENCE))).isEnabled();		
		Assert.assertTrue(city);
	}

	@Then("verify credit history dropdown field")
	public void verify_credit_history_dropdown_field() {
		Boolean city = driver.findElement(By.xpath(prop.getProperty(Constants.CREDIT_HISTORY))).isEnabled();		
		Assert.assertTrue(city);

	}

	@Then("verify phone number text field")
	public void verify_phone_number_text_field() {	
		Boolean phoneNumber = driver.findElement(By.xpath(prop.getProperty(Constants.PHONE))).isEnabled();		
		Assert.assertTrue(phoneNumber);

	}

	//Test cases for customer registration step two	page

	@Then("verify residence type dropdown option")
	public void verify_residence_type_dropdown_option() {

		RegistrationPage.completeStepOne();
		Boolean residenceType = driver.findElement(By.xpath(prop.getProperty(Constants.RESIDENCE_TYPE))).isEnabled();		
		Assert.assertTrue(residenceType);

	}

	@Then("verify years in current residence drowndown option")
	public void verify_years_in_current_residence_drowndown_option() {

		RegistrationPage.completeStepOne();
		Boolean yearsInCurrentResidence = driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_RESIDENCE_AGE))).isEnabled();		
		Assert.assertTrue(yearsInCurrentResidence);

	}

	@Then("verify years in current city drowndown option")
	public void verify_years_in_current_city_drowndown_option() {

		RegistrationPage.completeStepOne();
		Boolean yearsInCurrentCity = driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_CITY_AGE))).isEnabled();		
		Assert.assertTrue(yearsInCurrentCity);

	}

	@Then("verify first address line text field")
	public void verify_first_address_line_text_field() {

		RegistrationPage.completeStepOne();
		Boolean firstAddressLine = driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_ONE))).isEnabled();		
		Assert.assertTrue(firstAddressLine);

	}

	@Then("verify second address line text field")
	public void verify_second_address_line_text_field() {

		RegistrationPage.completeStepOne();
		Boolean secondAddressLine = driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_TWO))).isEnabled();		
		Assert.assertTrue(secondAddressLine);
	}

	@Then("verify pincode text field")
	public void verify_pincode_text_field() {

		RegistrationPage.completeStepOne();
		Boolean pincode = driver.findElement(By.xpath(prop.getProperty(Constants.PINCODE))).isEnabled();		
		Assert.assertTrue(pincode);
	}
	@Then("verify city text field")
	public void verify_city_text_field() {

		RegistrationPage.completeStepOne();
		Boolean city = driver.findElement(By.xpath(prop.getProperty(Constants.CITY))).isSelected();		
		System.out.println(city);
		Assert.assertFalse(city);

	}
	@Then("verify state text field")
	public void verify_state_text_field() {

		RegistrationPage.completeStepOne();
		Boolean state = driver.findElement(By.xpath(prop.getProperty(Constants.STATE))).isSelected();		
		Assert.assertFalse(state);
	}

	@Then("verify continue button")
	public void verify_continue_button() {	

		RegistrationPage.completeStepOne();
		Boolean submitBtn = driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).isEnabled();		
		Assert.assertTrue(submitBtn);

	}
	@Then("verify company name text field")
	public void verify_company_name_text_field() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean companyName = driver.findElement(By.xpath(prop.getProperty(Constants.COMPANY_NAME))).isEnabled();		
		Assert.assertTrue(companyName);

	}

	@Then("verify company type dropdown button")
	public void verify_company_type_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Boolean companyType = driver.findElement(By.xpath(prop.getProperty(Constants.COMPANY_TYPE))).isEnabled();		
		Assert.assertTrue(companyType);

	}

	@Then("verify designation text field")
	public void verify_designation_text_field() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean designation = driver.findElement(By.xpath(prop.getProperty(Constants.DESIGNATION))).isEnabled();		
		Assert.assertTrue(designation);

	}

	@Then("verify pan number text field")
	public void verify_pan_number_text_field() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean panNumber = driver.findElement(By.xpath(prop.getProperty(Constants.PAN))).isEnabled();		
		Assert.assertTrue(panNumber);

	}

	@Then("verify job type dropdown button")
	public void verify_job_type_dropdown_button() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean jobType = driver.findElement(By.xpath(prop.getProperty(Constants.JOB_TYPE))).isEnabled();		
		Assert.assertTrue(jobType);

	}

	@Then("verify total work experience dropdown button")
	public void verify_total_work_experience_dropdown_button() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean totalWorkExp = driver.findElement(By.xpath(prop.getProperty(Constants.TOTAL_WORK_EXP))).isEnabled();		
		Assert.assertTrue(totalWorkExp);

	}

	@Then("verify work experience in current company dropdown button")
	public void verify_work_experience_in_current_company_dropdown_button() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean currentCompanyExp = driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_WORK_EXP))).isEnabled();		
		Assert.assertTrue(currentCompanyExp);

	}

	@Then("verify office email text field")
	public void verify_office_email_text_field() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean officeEmail = driver.findElement(By.xpath(prop.getProperty(Constants.OFFICE_EMAIL))).isEnabled();		
		Assert.assertTrue(officeEmail);

	}
	@Then("verify salary text field")
	public void verify_salary_text_field() {

		CustRegDataValidation.completePendingSteps();
		Boolean salary = driver.findElement(By.xpath(prop.getProperty(Constants.SALARY))).isEnabled();		
		Assert.assertTrue(salary);

	}
	@Then("verify salary mode dropdown button")
	public void verify_salary_mode_dropdown_button() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean salaryMode = driver.findElement(By.xpath(prop.getProperty(Constants.SALARY_MODE))).isEnabled();		
		Assert.assertTrue(salaryMode);

	}
	@Then("verify bank name dropdown button")
	public void verify_bank_name_dropdown_button() {
		
		CustRegDataValidation.completePendingSteps();
		Boolean bankName = driver.findElement(By.xpath(prop.getProperty(Constants.BANK_NAME))).isEnabled();		
		Assert.assertTrue(bankName);

	}


	@Then("close the page")
	public void close_the_page() {
		RegistrationPage.closeBrowser();
	}
}
