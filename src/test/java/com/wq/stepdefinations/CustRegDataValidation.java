package com.wq.stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.pages.RegistrationPage;
import com.wq.utils.Constants;
import com.wq.utils.DataHelper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.common.base.Strings;

public class CustRegDataValidation extends Commons {

	RegistrationPage pages = new RegistrationPage();
	Constants c = new Constants();
	//	DataHelper helper = new DataHelper();

	@Given("user launched webpage")
	public void user_launched_webpage() {	
		Commons.browserInitialization();
	}

	//test cases for customer registration step-1 page

	@And("user entered all mandatory details in step one")
	public static void user_entered_all_mandatory_details_in_step_one(DataTable regData){

		for (Map<String, String> data : regData.asMaps()){

			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.ValidateNextPageTitle(Constants.STEP_TWO_TITLE), "Current Residence Details");
			RegistrationPage.refreshBrowser();
		}
	}

	@And("user entered invalid firstname")
	public void user_entered_invalid_firstname(DataTable regData) throws IOException {

		//fetching dynamic data from feature file using data table with maps mechanism
		//Provide sample data under the test step in feature file and pass the data in the below method
		for (Map<String, String> data : regData.asMaps()){

			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.FIRSTNAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
			driver.navigate().refresh();
		}	
		/*		
		//fetching test data using external resources(ex:excel file).
		public void user_entered_invalid_firstname() throws IOException {

			//Fecth data from external resource(excel file and pass it)
			DataHelper helper = new DataHelper();
		Map<String, String> data =  helper.readExcelData(prop.getProperty(Constants.FILE_PATH),
					prop.getProperty(Constants.FILE_NAME), prop.getProperty(Constants.SHEET_NAME));	

			RegistrationPage.passCustStepOneInfo(data.get("firstName"), data.get("middleName"),data.get("lastName"), 
					data.get("dob"),data.get("gender"), data.get("city"),data.get("creditHistory"), 
					data.get("phoneNumber"));

			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.FIRSTNAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
			driver.navigate().refresh();
			}	
		 */		 
	}

	@And("user entered invalid middlename")
	public void user_entered_invalid_middlename(DataTable regData) {
		for (Map<String, String> data : regData.asMaps()){

			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));	
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.MIDDLENAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
		}
	}
	@And("user entered invalid lastname")
	public void user_entered_invalid_lastname(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.LASTNAME_ERROR_MSG), "Name can contain only letters and spaces. Please check to continue");
		}
	}

	@And("user entered invalid dob")
	public void user_entered_invalid_dob(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");
		}
	}
	@Then("user entered dob less than min age criteria")
	public void user_entered_dob_less_than_min_age_criteria(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");
		}
	}
	@Then("user entered dob more than max age criteria")
	public void user_entered_dob_more_than_max_age_criteria(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");		
		}
	}
	@Then("check auto complete city list when user enters one letter in step one page")
	public void check_auto_complete_city_list_when_user_enters_one_letter_in_step_one_page(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			boolean autoCityList = RegistrationPage.autoCompleteCityList(data.get("city")).isEmpty();
			Assert.assertFalse(autoCityList);		
			RegistrationPage.refreshBrowser();
		}	
	}

	@Then("user entered invalid city name")
	public void user_entered_invalid_city_name(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Sorry, we’re currently available only in the given cities");		
		}
	}
	@Then("user entered city not in list")
	public void user_entered_city_not_in_list(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Sorry, we’re currently available only in the given cities");	
		}
	}
	@Then("user entered invalid phonenumber")
	public void user_entered_invalid_phonenumber(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "The Phone field should be of minimum 10 characters.");		
		}
	}
	@Then("user entered phone with less than ten digits")
	public void user_entered_phone_with_less_than_ten_digits(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(data.get("firstname"), data.get("middlename"),data.get("lastname"), data.get("dob"), 
					data.get("gender"), data.get("city"),data.get("creditHistory"), data.get("phoneNumber"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "The Phone field should be of minimum 10 characters.");
		}	}

	@Then("user entered phone which is already reigstered in step one page")
	public void user_entered_phone_which_is_already_reigstered_in_step_one_page(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(
					(Strings.nullToEmpty(data.get("firstname"))),Strings.nullToEmpty(data.get("middlename")),
					Strings.nullToEmpty(data.get("lastname")),Strings.nullToEmpty(data.get("dob")),
					data.get("gender"),Strings.nullToEmpty(data.get("city")),
					data.get("creditHistory"),Strings.nullToEmpty(data.get("phoneNumber")));
			//Need to add the login page title assertion, will complete once login page flow is done
			//	Assert.assertEquals(prop.getProperty(Constants.CUSTOMER_REG_URL), expected);
		}
	}

	@Then("click on continue button without providing values in step one page")
	public void click_on_continue_button_without_providing_values_in_step_one_page(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepOneInfo(
					(Strings.nullToEmpty(data.get("firstname"))),Strings.nullToEmpty(data.get("middlename")),
					Strings.nullToEmpty(data.get("lastname")),Strings.nullToEmpty(data.get("dob")),
					data.get("gender"),Strings.nullToEmpty(data.get("city")),
					data.get("creditHistory"),Strings.nullToEmpty(data.get("phoneNumber")));

			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.FIRSTNAME_ERROR_MSG), "First name is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.LASTNAME_ERROR_MSG), "Last name is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "Date of birth is required");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.GENDER_ERROR_MSG), "Gender is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CITY_ERROR_MSG), "Current city is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CH_ERROR_MSG), "Credit history is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PHONE_ERROR_MSG), "Phone number is a required field");
			RegistrationPage.refreshBrowser();
		}
	}

	//test cases for customer registration step-2 page


	@Then("click on continue button without providing details in step two page")
	public void click_on_continue_button_without_providing_details_in_step_two_page(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"),data.get("years in residence"),data.get("years in city"), 
					Strings.nullToEmpty(data.get("address1")),Strings.nullToEmpty(data.get("address2")),Strings.nullToEmpty(data.get("pincode")));		

			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RESIDENCE_TYPE_ERROR_MSG), "Type of residence is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_RES_AGE_ERROR_MSG), "Current residence duration is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_CITY_AGE_ERROR_MSG), "Current city duration is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), "Pincode is a required field");
		}
	}
	@Then("user given valid details in step two page")
	public static void user_given_valid_details_in_step_two_page(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));	
			Assert.assertEquals(RegistrationPage.ValidateNextPageTitle(Constants.STEP_THREE_TITLE), "Work and Income Details");

		}}

	@Then("customer provides age of city greater than age of residence")
	public void customer_provides_age_of_city_greater_than_age_of_residence(DataTable regData) {

		RegistrationPage.completeStepOne();
		for (Map<String, String> data : regData.asMaps()){
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_RES_AGE_ERROR_MSG), "Years in current residence cannot be more than the current city. Check selection");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_CITY_AGE_ERROR_MSG), "Years in current city cannot be less than current residence years. Check selection");
			RegistrationPage.refreshBrowser();
		}	
	}

	@Then("user entered first adrress line with less than minimum chars")
	public void user_entered_first_adrress_line_with_less_than_minimum_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field cannot have less than 3 characters");

		}	}
	@Then("user entered first adrress line with less than minimum chars includes special chars")
	public void user_entered_first_adrress_line_with_less_than_minimum_chars_includes_special_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field can have only these special characters [./,-]");
		}
	}
	@Then("user entered first adrress line with three repeated chars")
	public void user_entered_first_adrress_line_with_three_repeated_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field does not allow three repeated characters.");
		}
	}
	@Then("user entered first adrress line with unsupported special chars")
	public void user_entered_first_adrress_line_with_unsupported_special_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field can have only these special characters [./,-]");
		}
	}
	@Then("user entered second adrress line with less than minimum chars")
	public void user_entered_second_adrress_line_with_less_than_minimum_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field cannot have less than 3 characters");
		}
	}
	@Then("user entered second adrress line with less than minimum chars includes special chars")
	public void user_entered_second_adrress_line_with_less_than_minimum_chars_includes_special_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field can have only these special characters [./,-]");
		}
	}
	@Then("user entered second adrress line with three repeated chars")
	public void user_entered_second_adrress_line_with_three_repeated_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field does not allow three repeated characters.");
		}
	}
	@Then("user entered second adrress line with unsupported special chars")
	public void user_entered_second_adrress_line_with_unsupported_special_chars(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field can have only these special characters [./,-]");
		}
	}
	@Then("user entered invalid pincode which is not relavent to given city")
	public void user_entered_invalid_pincode_which_is_not_relavent_to_given_city (DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), "Your chosen city and given pincode don’t match. Please check to continue");
		}
	}
	@Then("user entered alphanumeric and special letters in pincode")
	public void user_entered_alphanumeric_and_special_letters_in_pincode(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), 
					"Pincode must be 6 digits only. Please check to continue");
		}
	}
	@Then("user entered pincode with less than six digits")
	public void user_entered_pincode_with_less_than_six_digits(DataTable regData) {

		RegistrationPage.completeStepOne();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), 
					"Pincode must be 6 digits only. Please check to continue");
		}
	}

	//test cases for step 3 customer registration page

	@Then("user provided all valid details and clicks on continue in step three page")
	public void user_provided_all_valid_details_and_clicks_on_continue_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.ValidateNextPageTitle((Constants.SUBMISSION_PAGE_TITLE)), "Verification and application submission");
			RegistrationPage.refreshBrowser();
		}

	}

	@Then("click on continue button without providing any details in step three page")
	public void click_on_continue_button_without_providing_any_details_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(Strings.nullToEmpty(data.get("companyName")), data.get("companyType"),Strings.nullToEmpty(data.get("designation")), 
					Strings.nullToEmpty(data.get("PAN")), data.get("jobType"),data.get("totalWorkExp"),data.get("currentWorkExp"), 
					Strings.nullToEmpty(data.get("officeEmail")),Strings.nullToEmpty(data.get("salary")),data.get("salaryMode"),
					data.get("bankName"));

			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.COMPANY_NAME_ERROR_MSG)), "Company name is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.COMPANY_TYPE_ERROR_MSG)), "Company type is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.DESIGNATION_ERROR_MSG)), "Designation is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.PAN_ERROR_MSG)), "PAN number is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.JOB_TYPE_ERROR_MSG)), "Employment type is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.TOTAL_WORK_EXP_ERROR_MSG)), "Total work experience is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.CURRENT_WORK_EXP_ERROR_MSG)), "Current work experience is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.OFFICE_EMAIL_ERROR_MSG)), "Work email is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.SALARY_ERROR_MSG)), "Salary is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.SALARY_MODE_ERROR_MSG)), "Mode of salary is a required field");
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.BANK_NAME_ERROR_MSG)), "Bank name is a required field");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("check auto complete company list when user enters one letter in step three page")
	public void check_auto_complete_company_list_when_user_enters_one_letter_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for (Map<String, String> data : regData.asMaps()){
			boolean autoCityList = RegistrationPage.autoCompleteCompanyList(data.get("companyName")).isEmpty();
			System.out.print(autoCityList);
			Assert.assertFalse(autoCityList);		
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify company name text field by providing specialChars in step three page")
	public void verify_company_name_text_field_by_providing_specialChars_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.COMPANY_NAME_ERROR_MSG)), "Company name cannot have special characters");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("check auto complete designation list when user enters one letter in step three page")
	public void check_auto_complete_designation_list_when_user_enters_one_letter_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for (Map<String, String> data : regData.asMaps()){
			boolean autoCityList = RegistrationPage.autoCompleteDesignationList(data.get("designation")).isEmpty();
			System.out.print(autoCityList);
			Assert.assertFalse(autoCityList);		
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify designation list text field by providing invalid name in step three page")
	public void verify_designation_list_text_field_by_providing_invalid_name_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.DESIGNATION_ERROR_MSG)), "Designation cannot have special characters. Please check to continue");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify pan number field by providing invalid number in step three page")
	public void verify_pan_number_field_by_providing_invalid_number_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.PAN_ERROR_MSG)), "Given PAN number is not in the required format and is invalid. Please check to continue");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify pan number field by providing all alphabets in step three page")
	public void verify_pan_number_field_by_providing_all_alphabets_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.PAN_ERROR_MSG)), "Given PAN number is not in the required format and is invalid. Please check to continue");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify pan number field by providing number in case sensitive in step three page")
	public void verify_pan_number_field_by_providing_number_in_case_sensitive_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.ValidateNextPageTitle((Constants.SUBMISSION_PAGE_TITLE)), "Verification and application submission");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify pannumber field by providing number with invalid sequence in step three page")
	public void verify_pannumber_field_by_providing_number_with_invalid_sequence_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.PAN_ERROR_MSG)), "Given PAN number is not in the required format and is invalid. Please check to continue");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("verify pannumber field by providing number with less than required letters in step three page")
	public void verify_pannumber_field_by_providing_number_with_less_than_required_letters_in_step_three_page(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation((Constants.PAN_ERROR_MSG)), "Given PAN number is not in the required format and is invalid. Please check to continue");
			RegistrationPage.refreshBrowser();
		}	
	}

	@Then("user provides current company experience greater than total work experience")
	public void user_provides_current_company_experience_greater_than_total_work_experience(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.TOTAL_WORK_EXP_ERROR_MSG), "Total work experience cannot be less than the current work experience. Please check selection");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_WORK_EXP_ERROR_MSG), "Current work experience cannot be more than the total work experience. Please check selection");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("user provides invalid email")
	public void user_provides_invalid_email(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.OFFICE_EMAIL_ERROR_MSG), "Given email is not in the correct format. Please check to continue");
			RegistrationPage.refreshBrowser();
		}	
	}

	@Then("user provides invalid emailId at starting of the name")
	public void user_provides_invalid_email_id_at_starting_of_the_name(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.OFFICE_EMAIL_ERROR_MSG), "Given email is not in the correct format. Please check to continue");
			RegistrationPage.refreshBrowser();

		}
	}
	@Then("user provides salary less than 15k")
	public void user_provides_salary_less_than_15k(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.SALARY_ERROR_MSG), "To apply, salary must be more than Rs. 15000.");
			RegistrationPage.refreshBrowser();
		}
	}

	@Then("user provides salary greater than 10Lakhs")
	public void user_provides_salary_greater_than_10Lakhs(DataTable regData) {

		CustRegDataValidation.completePendingSteps();
		for(Map<String, String> data: regData.asMaps()) {
			RegistrationPage.passCustStepThreeInfo(data.get("companyName"), data.get("companyType"), data.get("designation"), data.get("PAN"), data.get("jobType"), data.get("totalWorkExp"), 
					data.get("currentWorkExp"), data.get("officeEmail"), data.get("salary"), data.get("salaryMode"), data.get("bankName"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.SALARY_ERROR_MSG), "To apply, salary must be less than Rs. 999999.");
			RegistrationPage.refreshBrowser();
		}

	}

	@Then("quit the page")
	public void quit_the_page() {
		RegistrationPage.closeBrowser();
	}


	//Generic methods to complete step one and step two customer details
	//These methods will help to call when test scripts has to execute step-2 and and step-3 reg cases

	public static void completePendingSteps() {

		RegistrationPage.completeStepOne();
		RegistrationPage.complteStepTwo();
	}

}
