package com.wq.stepdefinations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.pages.FieldValidationPage;
import com.wq.pages.LandingPage;
import com.wq.pages.RegistrationPage;
import com.wq.utils.Constants;

import io.cucumber.java.en.*;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;

public class CustRegFieldValidation extends Commons{

	CustRegDataValidation dataValidation = new CustRegDataValidation();
	FieldValidationPage fieldValidation = new FieldValidationPage();

	@Given("user launched the moneytap webqual page")
	public void user_launched_the_moneytap_webqual_page() {
		Commons.browserInitialization();

	}

	//test cases for step 1

	@Then("verify firstname text field")
	public void verify_firstname_text_field() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.FIRSTNAME));
	}

	@Then("verify middlename text field")
	public void verify_middlename_text_field() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.MIDDLENAME));

	}

	@Then("verify lastname text field")
	public void verify_lastname_text_field() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.LASTNAME));

	}

	@Then("verify dob text field")
	public void verify_dob_text_field () {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.DOB));

	}

	@Then("verify gender dropdown field")
	public void verify_gender_dropdown_field() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.GENDER));

	}

	@Then("verify city of residence text field")
	public void verify_city_of_residence_text_field() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CITY));

	}

	@Then("verify credit history dropdown field")
	public void verify_credit_history_dropdown_field() {
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CREDIT_HISTORY));
	}

	@Then("verify phone number text field")
	public void verify_phone_number_text_field() {	
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.PHONE));

	}

	//Test cases for customer registration step two	page

	@Then("verify residence type dropdown option")
	public void verify_residence_type_dropdown_option() {

	RegistrationPage.completeStepOne();
	Assert.assertTrue(FieldValidationPage.validateFields(Constants.RESIDENCE_TYPE));

	}

	@Then("verify years in current residence drowndown option")
	public void verify_years_in_current_residence_drowndown_option() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CURRENT_RESIDENCE_AGE));

		

	}

	@Then("verify years in current city drowndown option")
	public void verify_years_in_current_city_drowndown_option() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CURRENT_CITY_AGE));


	}

	@Then("verify first address line text field")
	public void verify_first_address_line_text_field() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.RES_ADD_LINE_ONE));


	}

	@Then("verify second address line text field")
	public void verify_second_address_line_text_field() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.RES_ADD_LINE_TWO));

	}

	@Then("verify pincode text field")
	public void verify_pincode_text_field() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.PINCODE));

	}
	@Then("verify city text field")
	public void verify_city_text_field() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CITY));


	}
	@Then("verify state text field")
	public void verify_state_text_field() {

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.STATE));

	}

	@Then("verify continue button")
	public void verify_continue_button() {	

		RegistrationPage.completeStepOne();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CONTINUE_BUTTON));

//test cases for step-3 customer registration page

	}
	@Then("verify company name text field")
	public void verify_company_name_text_field() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.COMPANY_NAME));


	}

	@Then("verify company type dropdown button")
	public void verify_company_type_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.COMPANY_TYPE));


	}

	@Then("verify designation text field")
	public void verify_designation_text_field() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.DESIGNATION));


	}

	@Then("verify pan number text field")
	public void verify_pan_number_text_field() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.PAN));


	}

	@Then("verify job type dropdown button")
	public void verify_job_type_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.JOB_TYPE));


	}

	@Then("verify total work experience dropdown button")
	public void verify_total_work_experience_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.TOTAL_WORK_EXP));

	}

	@Then("verify work experience in current company dropdown button")
	public void verify_work_experience_in_current_company_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CURRENT_WORK_EXP));


	}

	@Then("verify office email text field")
	public void verify_office_email_text_field() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.OFFICE_EMAIL));


	}
	@Then("verify salary text field")
	public void verify_salary_text_field() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.SALARY));


	}
	@Then("verify salary mode dropdown button")
	public void verify_salary_mode_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.SALARY_MODE));


	}
	@Then("verify bank name dropdown button")
	public void verify_bank_name_dropdown_button() {

		CustRegDataValidation.completePendingSteps();
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.BANK_NAME));


	}

	//test cases for verification and submission field validations
	
	@Given("user launched the webpage and completed all steps")
	public void user_launched_the_webpage_and_completed_all_steps() {
		
		Commons.browserInitialization();
		RegistrationPage.completeStepOne();
		RegistrationPage.complteStepTwo();  
		RegistrationPage.completeStepThree();
	}

	@Then("verify phone number text field in verification page")
	public void verify_phone_number_text_field_in_verification_page() {
		
		System.out.println("I'm here...");
		System.out.println(Constants.MOBILE_NO);
		
	}
	@Then("verify otp text field")
	public void verify_otp_text_field() {
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.OTP));
	}


	@Then("verify promo code text field")
	public void verify_promo_code_text_field() {
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.PROMO_CODE));
	}

	@Then("verify send otp button")
	public void verify_send_otp_button() {

		Assert.assertTrue(FieldValidationPage.validateFields(Constants.SEND_OTP));
	}

	@Then("verify apply code button")
	public void verify_apply_code_button() {
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.APPLY_CODE));
	}

	@Then("verify userConsent checkbox")
	public void verify_user_consent_checkbox() {
		
		Assert.assertFalse(FieldValidationPage.validateCheckBox(Constants.TERMS_AND_CONDITIONS_CHECK_BOX));
	}

	@Then("verify whatsApp notification checkbox")
	public void verify_whats_app_notification_checkbox() {
		
		Assert.assertTrue(FieldValidationPage.validateCheckBox(Constants.WHATSAPP_CHECK_BOX));
	}

	@Then("verify check limit CTA button")
	public void verify_check_limit_cta_button() {
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.CHECK_LIMIT_BTN));

	}

	@Then("close the page")
	public void close_the_page() {
		RegistrationPage.closeBrowser();
	}
}
