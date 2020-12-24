package com.wq.stepdefinations;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.wq.common.Commons;
import com.wq.pages.CustRegValidationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CustRegValidation extends Commons {

	CustRegValidationPage pages = new CustRegValidationPage();
	@Given("user launched webpage")
	public void user_launched_webpage() {	
		Commons.browserInitialization();

	}
	@Then("click on continue button")
	public void click_on_continue_button() {

		CustRegValidationPage.passCustStepOneInfo("","","","","Select gender","","-- Select --","");
		String firstNameErrorMsg = CustRegValidationPage.firstNameErrorMsg();
		String middleNameErrorMsg = CustRegValidationPage.middleNameErrorMsg();
		String lastNameErrorMsg = CustRegValidationPage.lastNameErrorMsg();
		String dobMsg = CustRegValidationPage.dobErrorMsg();
		String genderErrorMsg = CustRegValidationPage.genderErrorMsg();
		String cityErrorMsg = CustRegValidationPage.cityErrorMsg();
		String chErrorMsg = CustRegValidationPage.credtiHistoryErrorMsg();
		String phoneNumberErrorMsg = CustRegValidationPage.phoneErrorMsg();

		Assert.assertEquals(firstNameErrorMsg, "First name is a required field");
		Assert.assertEquals(lastNameErrorMsg, "Last name is a required field");
		Assert.assertEquals(dobMsg, "Date of birth is required");
		Assert.assertEquals(genderErrorMsg, "Gender is a required field");
		Assert.assertEquals(cityErrorMsg, "Current city is a required field");
		Assert.assertEquals(chErrorMsg, "Credit history is a required field");
		Assert.assertEquals(phoneNumberErrorMsg, "Phone number is a required field");

	}
	@And("user entered all mandatory details in step one")
	public void user_entered_all_mandatory_details_in_step_one(){

		CustRegValidationPage.passCustStepOneInfo("Manikanta","Raju","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		String stepTwoLaunchVerification = CustRegValidationPage.ValidateStepOnePageWithDetails();
		Assert.assertEquals(stepTwoLaunchVerification, "Current Residence Details");

	}

	@And("user entered invalid firstname")
	public void user_entered_invalid_firstname(DataTable credentials) {

		List<List<String>> data = credentials.cells();
		CustRegValidationPage.passCustStepOneInfo(
				data.get(0).get(0), data.get(0).get(1),
				data.get(0).get(2), data.get(0).get(3), 
				data.get(0).get(4),	data.get(0).get(5), 
				data.get(0).get(6), data.get(0).get(7));
		String firstNameErrorMsg = CustRegValidationPage.firstNameErrorMsg();
		Assert.assertEquals(firstNameErrorMsg, "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid middlename")
	public void user_entered_invalid_middlename() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","138@##$*","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");	
		String middleNameErrorMsg = CustRegValidationPage.middleNameErrorMsg();
		Assert.assertEquals(middleNameErrorMsg, "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid lastname")
	public void user_entered_invalid_lastname() {

		CustRegValidationPage.passCustStepOneInfo("Manikanta","","@#$QWSKS","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		String lastNameErrorMsg = CustRegValidationPage.lastNameErrorMsg();		
		Assert.assertEquals(lastNameErrorMsg, "Name can contain only letters and spaces. Please check to continue");
	}

	@And("user entered invalid dob")
	public void user_entered_invalid_dob() {

		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","36/36/10008","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		String dobNameErrorMsg = CustRegValidationPage.dobErrorMsg();	
		Assert.assertEquals(dobNameErrorMsg, "To apply, age must be between 23 to 65 years");
	}
	@Then("user entered dob less than min age criteria")
	public void user_entered_dob_less_than_min_age_criteria() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1998","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		String dobErrorMsg = CustRegValidationPage.dobErrorMsg();
		Assert.assertEquals(dobErrorMsg, "To apply, age must be between 23 to 65 years");

	}
	@Then("user entered dob more than max age criteria")
	public void user_entered_dob_more_than_max_age_criteria() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1954","Male","Bangalore",
				"I have an active credit card and a loan","7666666790");
		String dobErrorMsg = CustRegValidationPage.dobErrorMsg();
		Assert.assertEquals(dobErrorMsg, "To apply, age must be between 23 to 65 years");		
	}
	@Then("user entered invalid city name")
	public void user_entered_invalid_city_name() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Ra123432@#(#",
				"I have an active credit card and a loan","7666666790");
		String cityErrorMsg = CustRegValidationPage.cityErrorMsg();	
		Assert.assertEquals(cityErrorMsg, "Sorry, we’re currently available only in the given cities");		
	}

	@Then("user entered city not in list")
	public void user_entered_city_not_in_list() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Rajamundry",
				"I have an active credit card and a loan","7666666790");
		String cityErrorMsg = CustRegValidationPage.cityErrorMsg();	
		Assert.assertEquals(cityErrorMsg, "Sorry, we’re currently available only in the given cities");	
	}

	@Then("user entered invalid phonenumber")
	public void user_entered_invalid_phonenumber() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","7666-@_#");
		String phoneNumberErrorMsg = CustRegValidationPage.phoneErrorMsg();	
		Assert.assertEquals(phoneNumberErrorMsg, "The Phone field should be of minimum 10 characters.");		
	}

	@Then("user entered phone with less than ten digits")
	public void user_entered_phone_with_less_than_ten_digits() {
		CustRegValidationPage.passCustStepOneInfo("Manikanta","","Devathi","20/08/1993","Male","Bangalore",
				"I have an active credit card and a loan","66666790");
		String phoneNumberErrorMsg = CustRegValidationPage.phoneErrorMsg();	
		Assert.assertEquals(phoneNumberErrorMsg, "The Phone field should be of minimum 10 characters.");
	}

	@Then("quit the page")
	public void quit_the_page() {
		driver.close();
	}
}
