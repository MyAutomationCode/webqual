@testFieldValidations
Feature: Customer registration page data validations 

Scenario: verify phone number text field in verification page
	Given user launched the webpage and completed all steps
	Then verify phone number text field in verification page
	Then close the page 

Scenario: verify otp text field 
	Given user launched the webpage and completed all steps
	Then verify otp text field
	Then close the page

Scenario: verify promo code text field 
	Given  user launched the webpage and completed all steps
	Then verify promo code text field
	Then close the page

Scenario: verify send otp button 
	Given  user launched the webpage and completed all steps
	Then verify send otp button
	Then close the page

Scenario: verify apply code button 
	Given user launched the webpage and completed all steps 
	Then verify apply code button
	Then close the page

Scenario: verify userConsent checkbox
	Given  user launched the webpage and completed all steps
	Then verify userConsent checkbox
	Then close the page

Scenario: verify whatsApp notification checkbox
	Given  user launched the webpage and completed all steps 
	Then verify whatsApp notification checkbox
	Then close the page

Scenario: verify check limit CTA button 
	Given user launched the webpage and completed all steps 
	Then verify check limit CTA button
	Then close the page