package com.wq.stepdefinations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class RegStepOneFieldValidation {
	WebDriver driver;

	@Given("user launched the moneytap webqual page")
	public void user_launched_the_moneytap_webqual_page() {

		System.setProperty("webdriver.chrome.driver", "C:/Work/workspace/Automation/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev.moneytap.com/jqual");
	}
	
	@Then("verify firstname text field")
	public void verify_firstname_text_field() {

		Boolean firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']")).isEnabled();
		Assert.assertTrue(firstname);
	}
	
	@Then("verify middlename text field")
	public void verify_middlename_text_field() {
		
		Boolean middlename = driver.findElement(By.xpath("//input[@placeholder='Middle Name (Optional)']")).isEnabled();
		Assert.assertTrue(middlename);
	}
	
	@Then("verify lastname text field")
	public void verify_lastname_text_field() {
		
		Boolean lastname = driver.findElement(By.xpath("//input[@placeholder='Middle Name (Optional)']")).isEnabled();
		Assert.assertTrue(lastname);
	}
	
	@Then("verify dob text field")
	public void verify_dob_text_field () {

		Boolean dob = driver.findElement(By.xpath("//input[@reference='date_of_birth']")).isEnabled();
		Assert.assertTrue(dob);
	}
	
	@Then("verify gender dropdown field")
	public void verify_gender_dropdown_field() {

		Boolean gender = driver.findElement(By.xpath("//select[@selected='selected']")).isEnabled();
		Assert.assertTrue(gender);

	}
	
	@Then("verify city of residence text field")
	public void verify_city_of_residence_text_field() {
		
		Boolean city = driver.findElement(By.xpath("//input[@placeholder='Start Typing']")).isEnabled();		
		Assert.assertTrue(city);

	}
	
	@Then("verify phone number text field")
	public void verify_phone_number_text_field() {	
		Boolean phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone number']")).isEnabled();		
		Assert.assertTrue(phoneNumber);
		
	}
	
	@Then("verify continue button")
	public void verify_continue_button() {	
		Boolean phoneNumber = driver.findElement(By.xpath("//button[@class='btn btn-orange submitBtn']")).isEnabled();		
		Assert.assertTrue(phoneNumber);
		
	}
	
	@Then("close the page")
	public void close_the_page() {
		driver.close();
	}
}
