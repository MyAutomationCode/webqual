@custRegValidation
Feature: Customer data validations

Scenario: verify continue option without providing details
	Given user launched webpage
	Then click on continue button

Scenario: verify contiunue option by providing valid details
	Given user launched webpage
	And user provided all the mandatory details
	Then click on continue button

Scenario: verify step one reg details by providing invalid firstname
	Given user launched webpage
	And user entered invalid firstname
	Then click on continue button
	
Scenario: verify step one reg details by providing invalid lastname
	Given user launched webpage
	And user entered invalid lastname
	Then click on continue button

Scenario: verify step one reg details by providing invalid dob
	Given user launched webpage
	And user entered invalid dob
	Then click on continue button
	



	