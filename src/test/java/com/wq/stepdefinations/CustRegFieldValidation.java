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
		
		CustRegDataValidation.completeStepOne();
		Boolean residenceType = driver.findElement(By.xpath(prop.getProperty(Constants.RESIDENCE_TYPE))).isEnabled();		
		Assert.assertTrue(residenceType);

	}

	@Then("verify years in current residence drowndown option")
	public void verify_years_in_current_residence_drowndown_option() {
		
		CustRegDataValidation.completeStepOne();
		Boolean yearsInCurrentResidence = driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_RESIDENCE_AGE))).isEnabled();		
		Assert.assertTrue(yearsInCurrentResidence);

	}

	@Then("verify years in current city drowndown option")
	public void verify_years_in_current_city_drowndown_option() {
		
		CustRegDataValidation.completeStepOne();
		Boolean yearsInCurrentCity = driver.findElement(By.xpath(prop.getProperty(Constants.CURRENT_CITY_AGE))).isEnabled();		
		Assert.assertTrue(yearsInCurrentCity);

	}

	@Then("verify first address line text field")
	public void verify_first_address_line_text_field() {
		
		CustRegDataValidation.completeStepOne();
		Boolean firstAddressLine = driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_ONE))).isEnabled();		
		Assert.assertTrue(firstAddressLine);

	}

	@Then("verify second address line text field")
	public void verify_second_address_line_text_field() {
		
		CustRegDataValidation.completeStepOne();
		Boolean secondAddressLine = driver.findElement(By.xpath(prop.getProperty(Constants.RES_ADD_LINE_TWO))).isEnabled();		
		Assert.assertTrue(secondAddressLine);

	}

	@Then("verify pincode text field")
	public void verify_pincode_text_field() {
		
		CustRegDataValidation.completeStepOne();
		Boolean pincode = driver.findElement(By.xpath(prop.getProperty(Constants.PINCODE))).isEnabled();		
		Assert.assertTrue(pincode);
	}
	@Then("verify city text field")
	public void verify_city_text_field() {
		
		CustRegDataValidation.completeStepOne();
		Boolean city = driver.findElement(By.xpath(prop.getProperty(Constants.CITY))).isDisplayed();		
		Assert.assertTrue(city);

	}
	@Then("verify state text field")
	public void verify_state_text_field() {
		
		CustRegDataValidation.completeStepOne();
		Boolean state = driver.findElement(By.xpath(prop.getProperty(Constants.STATE))).isDisplayed();		
		Assert.assertTrue(state);
	}

	@Then("verify continue button")
	public void verify_continue_button() {	
		
		CustRegDataValidation.completeStepOne();
		Boolean submitBtn = driver.findElement(By.xpath(prop.getProperty(Constants.CONTINUE_BUTTON))).isEnabled();		
		Assert.assertTrue(submitBtn);

	}

	@Then("close the page")
	public void close_the_page() {
		RegistrationPage.closeBrowser();
	}
}
