package com.wq.stepdefinations;

import java.util.List;

import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.pages.RegistrationPage;
import com.wq.utils.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CustRegValidation extends Commons {

	RegistrationPage pages = new RegistrationPage();
	Constants c = new Constants();

	@Given("user launched webpage")
	public void user_launched_webpage() {	
		Commons.browserInitialization();
	}

	//test cases for customer registration step-1 page

	@And("user entered all mandatory details in step one")
	public static void user_entered_all_mandatory_details_in_step_one(){

		RegistrationPage.passCustStepOneInfo("Manikanta","Raju","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.ValidateStepOnePageWithDetails(), "Current Residence Details");
	}

	@And("user entered invalid firstname")
	public void user_entered_invalid_firstname(DataTable credentials) {

		List<List<String>> data = credentials.cells();
		RegistrationPage.passCustStepOneInfo(
				data.get(0).get(0), data.get(0).get(1),
				data.get(0).get(2), data.get(0).get(3), 
				data.get(0).get(4),	data.get(0).get(5), 
				data.get(0).get(6), data.get(0).get(7));
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.FIRSTNAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid middlename")
	public void user_entered_invalid_middlename() {
		RegistrationPage.passCustStepOneInfo("Manikanta","138@##$*","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");	
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.MIDDLENAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid lastname")
	public void user_entered_invalid_lastname() {

		RegistrationPage.passCustStepOneInfo("Manikanta","","@#$QWSKS","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.LASTNAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid dob")
	public void user_entered_invalid_dob() {

		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","36/36/10008","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");
	}
	@Then("user entered dob less than min age criteria")
	public void user_entered_dob_less_than_min_age_criteria() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1998","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");

	}
	@Then("user entered dob more than max age criteria")
	public void user_entered_dob_more_than_max_age_criteria() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1954","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		//		String dobErrorMsg = RegistrationPage.dobErrorMsg();
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");		
	}
	@Then("user entered invalid city name")
	public void user_entered_invalid_city_name() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Ra123432@#(#",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Sorry, we’re currently available only in the given cities");		
	}

	@Then("user entered city not in list")
	public void user_entered_city_not_in_list() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Rajamundry",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Sorry, we’re currently available only in the given cities");	
	}

	@Then("user entered invalid phonenumber")
	public void user_entered_invalid_phonenumber() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666-@_#");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "The Phone field should be of minimum 10 characters.");		
	}

	@Then("user entered phone with less than ten digits")
	public void user_entered_phone_with_less_than_ten_digits() {
		RegistrationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","66666790");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "The Phone field should be of minimum 10 characters.");
	}
	@Then("click on continue button without providing values in step one page")
	public void click_on_continue_button_without_providing_values_in_step_one_page() {

		RegistrationPage.passCustStepOneInfo("","","","","Select gender","","-- Select --","");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.FIRSTNAME_ERROR_MSG), "First name is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.LASTNAME_ERROR_MSG), "Last name is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "Date of birth is required");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.GENDER_ERROR_MSG), "Gender is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Current city is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CH_ERROR_MSG), "Credit history is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "Phone number is a required field");
	}

	//test cases for customer registration step-2 page

	@Then("click on continue button without providing details in step two page")
	public void click_on_continue_button_without_providing_details_in_step_two_page() {
		
		CustRegValidation.user_entered_all_mandatory_details_in_step_one();
		RegistrationPage.passCustStepTwoInfo("--Select--","--Select--","","","");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RESIDENCE_TYPE_ERROR_MSG), "Type of residence is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_RES_AGE_ERROR_MSG), "Current residence duration is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_CITY_AGE_ERROR_MSG), "Current city duration is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address is a required field");
//		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Current city is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), "Pincode is a required field");
		
	}
	@Then("user given valid residence type")
	public void user_given_valid_residence_type() {

	}
	@Then("user given valid years in current address details")
	public void user_given_valid_years_in_current_address_details() {
	}
	@Then("user given valid years in current city details")
	public void user_given_valid_years_in_current_city_details() {

	}
	@Then("user entered valid details in first address line")
	public void user_entered_valid_details_in_first_address_line() {
	   
	}
	@Then("user entered first adrress line with less than minimum chars")
	public void user_entered_first_adrress_line_with_less_than_minimum_chars() {

	}
	@Then("user entered first adrress line with three repeated chars")
	public void user_entered_first_adrress_line_with_three_repeated_chars() {
	}
	@Then("user entered first adrress line with unsupported special chars")
	public void user_entered_first_adrress_line_with_unsupported_special_chars() {

	}
	@Then("user entered valid details in second address line")
	public void user_entered_valid_details_in_second_address_line() {
	   
	}
	@Then("user entered second adrress line with less than minimum chars")
	public void user_entered_second_adrress_line_with_less_than_minimum_chars() {
	   
	}
	@Then("user entered second adrress line with three repeated chars")
	public void user_entered_second_adrress_line_with_three_repeated_chars() {
	    
	}
	@Then("user entered second adrress line with unsupported special chars")
	public void user_entered_second_adrress_line_with_unsupported_special_chars() {
	    
	}
	@Then("user entered valid details in pincode")
	public void user_entered_valid_details_in_pincode() {
	    
	}
	@Then("user entered invalid details in pincode")
	public void user_entered_invalid_details_in_pincode() {
	 
	}
	@Then("user entered alphanumeric values in pincode")
	public void user_entered_alphanumeric_values_in_pincode() {
	    
	}
	@Then("user entered pincode with less than six digits")
	public void user_entered_pincode_with_less_than_six_digits() {
	   
	}
	
	@Then("quit the page")
	public void quit_the_page() {
		RegistrationPage.closeBrowser();
	}
}
