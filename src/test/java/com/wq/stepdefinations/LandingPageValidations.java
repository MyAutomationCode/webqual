package com.wq.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wq.common.Commons;
import com.wq.pages.FieldValidationPage;
import com.wq.pages.LandingPage;
import com.wq.pages.RegistrationPage;
import com.wq.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.jv.Lan;

public class LandingPageValidations extends Commons{
	
	
	@Given("user already launched the moneytap webqual page")
	public void user_already_launched_the_moneytap_webqual_page() {
		Commons.browserInitialization();
	}

	@Then("verify the webpage title")
	public void verify_the_webpage_title() {

		String title = LandingPage.validateTitle();
		Assert.assertEquals(title,"MoneyTap - Apply for MoneyTap to get approved up to Rs. 5 lakhs in 4 minutes");
	} 

	@Then("verify the main heading under the offers page")
	public void verify_the_main_heading_under_the_offers_page() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.OFFERS_HEADING), "MoneyTap Benefits");
	}

	@Then("verify the subheading of first offer")
	public void verify_the_subheading_of_first_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FIRST_OFFER_TITLE),"Borrow nothing, pay nothing");
	}

	@Then("verify the content of first offer")
	public void verify_the_content_of_first_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FIRST_OFFER_INFO), "Reserve the full amount, pay interest only on what you transfer to your bank account.");
	}

	@Then("verify the subheading of second offer")
	public void verify_the_subheading_of_second_offer() throws InterruptedException {		
		Assert.assertEquals(LandingPage.uiValidations(Constants.SECOND_OFFER_TITLE), "Credit that never ends");
	}

	@Then("verify the content of second offer")
	public void verify_the_content_of_second_offer() throws InterruptedException {		
		Assert.assertEquals(LandingPage.uiValidations(Constants.SECOND_OFFER_INFO), "Get a limit top-up with every repayment. Borrow the money again, with no reapplication.");
	}

	@Then("verify the subheading of third offer") 
	public void verify_the_subheading_of_third_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.THIRD_OFFER_TITLE), "Get money instantly");
	}

	@Then("verify the content of third offer")
	public void verify_the_content_of_third_offer() throws InterruptedException { 
		Assert.assertEquals(LandingPage.uiValidations(Constants.THIRD_OFFER_INFO), "Anytime you need money, transfer it to your bank account in minutes from the app.");
	}

	@Then("verify the subheading of fourth offer")
	public void verify_the_subheading_of_fourth_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FOURTH_OFFER_TITLE), "Get a bonus Credit Card");
	}

	@Then("verify the content of fourth offer")
	public void verify_the_content_of_fourth_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FOURTH_OFFER_INFO), "Use your add-on Mastercard anywhere, with an interest free period of up to 50 days.");
	}

	@Then("verify the subheading of fifth offer")
	public void verify_the_subheading_of_fifth_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FIFTH_OFFER_TITLE), "Fee & Tenure");
	}

	@Then("verify the content of fifith offer")
	public void verify_the_content_of_fifith_offer() throws InterruptedException {
		Assert.assertEquals(LandingPage.uiValidations(Constants.FIFTH_OFFER_INFO), "Interest Rate – 13% - 36% PA\r\n"
				+ "Processing Fee – 2%\r\n"
				+ "Loan Tenure – 2 – 36 Months\r\n"
				+ "Loan Amount – 3,000 to 5 Lakh");
	}

	@Then("verify login button")
	public void verify_login_button() {
		
		Assert.assertTrue(FieldValidationPage.validateFields(Constants.LOGIN_BTN));
	}

	@Then("verify customer reg step one title")
	public void verify_customer_reg_step_one_title() throws InterruptedException {		
		Assert.assertEquals(RegistrationPage.validateNextPageTitle(Constants.STEP_ONE_TITLE), "Get started by creating your profile");
	}

	@Then("find the scroll bar in webpage and verify")
	public void find_the_scroll_bar_in_webpage_and_verify() {
		
		Assert.assertTrue(LandingPage.verifyScrollbar());
	}

	@Then("close the webpage")
	public void close_the_webpage() {
		Commons.closeBrowser();
	}

}
