package com.wq.stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
	public static void user_entered_all_mandatory_details_in_step_one(){

		RegistrationPage.passCustStepOneInfo("Manikanta","Raju","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		Assert.assertEquals(RegistrationPage.ValidateNextPageTitle(Constants.STEP_TWO_TITLE), "Current Residence Details");
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
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.DOB_ERROR_MSG), "To apply, age must be between 23 to 65 years");		
	}

	@Then("check auto complete city list when user enters one letter in step one page")
	public void check_auto_complete_city_list_when_user_enters_one_letter_in_step_one_page(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){

			boolean autoCityList = RegistrationPage.autoCompleteCityList(data.get("city")).isEmpty();
			System.out.print(autoCityList);
			Assert.assertFalse(autoCityList);		
			driver.navigate().refresh();
		}	
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
	public void click_on_continue_button_without_providing_details_in_step_two_page() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("-- Select --","-- Select --","-- Select --","","","");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RESIDENCE_TYPE_ERROR_MSG), "Type of residence is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_RES_AGE_ERROR_MSG), "Current residence duration is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_CITY_AGE_ERROR_MSG), "Current city duration is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address is a required field");
		//		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Current city is a required field");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), "Pincode is a required field");

	}
	@Then("user given valid details")
	public void user_given_valid_details() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years","14-s,M layout","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.ValidateNextPageTitle(Constants.STEP_THREE_TITLE), "Work and Income Details");

	}

	@Then("customer provides age of city greater than age of residence")
	public void customer_provides_age_of_city_greater_than_age_of_residence(DataTable regData) {

		for (Map<String, String> data : regData.asMaps()){

			CustRegDataValidation.completeStepOne();
			RegistrationPage.passCustStepTwoInfo(data.get("residenceType"), data.get("years in residence"),data.get("years in city"), data.get("address1"), 
					data.get("address2"), data.get("pincode"));
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_RES_AGE_ERROR_MSG), "Years in current residence cannot be more than the current city. Check selection");
			Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.CURRENT_CITY_AGE_ERROR_MSG), "Years in current city cannot be less than current residence years. Check selection");
			RegistrationPage.refreshBrowser();
		}	
	}

	@Then("user entered first adrress line with less than minimum chars")
	public void user_entered_first_adrress_line_with_less_than_minimum_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"4-","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field cannot have less than 3 characters");

	}	
	@Then("user entered first adrress line with less than minimum chars includes special chars")
	public void user_entered_first_adrress_line_with_less_than_minimum_chars_includes_special_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"*1","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field can have only these special characters [./,-]");

	}
	@Then("user entered first adrress line with three repeated chars")
	public void user_entered_first_adrress_line_with_three_repeated_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"aaa aaa 123 shanti nagar","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field does not allow three repeated characters.");

	}
	@Then("user entered first adrress line with unsupported special chars")
	public void user_entered_first_adrress_line_with_unsupported_special_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"*&*(asadd-2jds","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_ONE_ERROR_MSG), "Address field can have only these special characters [./,-]");

	}
	@Then("user entered second adrress line with less than minimum chars")
	public void user_entered_second_adrress_line_with_less_than_minimum_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"*1","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field can have only these special characters [./,-]");

	}
	@Then("user entered second adrress line with less than minimum chars includes special chars")
	public void user_entered_second_adrress_line_with_less_than_minimum_chars_includes_special_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"*1","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field can have only these special characters [./,-]");

	}
	@Then("user entered second adrress line with three repeated chars")
	public void user_entered_second_adrress_line_with_three_repeated_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"aaa aaa 123 shanti nagar","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field does not allow three repeated characters.");

	}
	@Then("user entered second adrress line with unsupported special chars")
	public void user_entered_second_adrress_line_with_unsupported_special_chars() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"*&*(asadd-2jds","Kalkere","560043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.RES_ADD_LINE_TWO_ERROR_MSG), "Address field can have only these special characters [./,-]");

	}
	@Then("user entered invalid details in pincode")
	public void user_entered_invalid_details_in_pincode() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"14-s,M layout","Kalkere","110043");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), "Your chosen city and given pincode don’t match. Please check to continue");

	}
	@Then("user entered alphanumeric values in pincode")
	public void user_entered_alphanumeric_values_in_pincode() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"14-s,M layout","Kalkere","4e@1");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), 
				"Pincode must be 6 digits only. Please check to continue");
	}
	@Then("user entered pincode with less than six digits")
	public void user_entered_pincode_with_less_than_six_digits() {

		CustRegDataValidation.completeStepOne();
		RegistrationPage.passCustStepTwoInfo("Rented with Family","More than 3 years","More than 3 years",
				"14-s,M layout","Kalkere","5600");
		Assert.assertEquals(RegistrationPage.errorMsgValidation(Constants.PINCDOE_ERROR_MSG), 
				"Pincode must be 6 digits only. Please check to continue");
	}

	@Then("quit the page")
	public void quit_the_page() {
		RegistrationPage.closeBrowser();
	}
	public static void completeStepOne() {

		CustRegDataValidation.user_entered_all_mandatory_details_in_step_one();
	}

}
