@custRegValidation
Feature: Customer data validations

@smoketest
Scenario: verify continue option without providing details
	Given user launched webpage
	Then click on continue button
	Then quit the page
		
Scenario: verify continue option by providing valid details in step one
	Given user launched webpage
	And user entered all mandatory details in step one
	Then quit the page

Scenario: verify step one reg details by providing invalid firstname
	Given user launched webpage
	And user entered invalid firstname
| 1382djfd | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card | 7666666790 |
	Then quit the page

Scenario: verify step one reg details by providing invalid middlename
	Given user launched webpage
	And user entered invalid middlename
	Then quit the page
	
Scenario: verify step one reg details by providing invalid lastname
	Given user launched webpage
	And user entered invalid lastname
	Then quit the page
	
Scenario: verify step one reg details by providing invalid dob
	Given user launched webpage
	And user entered invalid dob
	Then quit the page

Scenario: verify step one reg details by providing invalid dob
	Given user launched webpage
	And user entered invalid dob
	Then quit the page

Scenario: verify step one reg details by providing dob less than min age criteria
	Given user launched webpage
	And user entered dob less than min age criteria
	Then quit the page

Scenario: verify step one reg details by providing dob more than max age criteria
Given user launched webpage
	And user entered dob more than max age criteria
	Then quit the page

Scenario: verify step one reg details by providing invalid city name
	Given user launched webpage
	And user entered invalid city name
	Then quit the page

Scenario: verify step one reg details by providing invalid phonenumber
	Given user launched webpage
	And user entered invalid phonenumber
	Then quit the page
	
Scenario: verify step one reg details by providing number lessthan ten digits
	Given user launched webpage
	And user entered phone with less than ten digits 
	Then quit the page
	
