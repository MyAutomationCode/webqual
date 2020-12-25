@custRegValidation
Feature: Customer data validations

# test cases for step one customer registration page

Scenario: verify step one page without providing details
	Given user launched webpage
	Then click on continue button without providing values in step one page
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
	
#test cases for step two customer registration page

@smoke
Scenario: verify step two page without passing any details
	Given user launched webpage
	Then click on continue button without providing details in step two page
	Then quit the page

Scenario: verify step two page by valid residence type
	Given user launched webpage
	And user given valid residence type
	Then quit the page

Scenario: verify step two page by valid years in current address
	Given user launched webpage
	And user given valid years in current address details
	Then quit the page

Scenario: verify step two page by valid years in current city
	Given user launched webpage
	And user given valid years in current city details
	Then quit the page

Scenario: verify step two page by providing address1 with three chars
	Given user launched webpage
	And user entered first adrress line with less than minimum chars
	Then quit the page

Scenario: verify step two page by providing address1 with three repeated chars
	Given user launched webpage
	And user entered first adrress line with three repeated chars
	Then quit the page


Scenario: verify step two page by providing address1 with unsupporrted special chars 
	Given user launched webpage
	And user entered first adrress line with unsupported special chars
	Then quit the page

Scenario: verify step two page by providing valid residence address1 details
	Given user launched webpage
	And user entered valid details in first address line
	Then quit the page

Scenario: verify step two page by providing address2 with three chars
	Given user launched webpage
	And user entered second adrress line with less than minimum chars
	Then quit the page

Scenario: verify step two page by providing address2 with three repeated chars
	Given user launched webpage
	And user entered second adrress line with three repeated chars
	Then quit the page


Scenario: verify step two page by providing address2 with unsupporrted special chars 
	Given user launched webpage
	And user entered second adrress line with unsupported special chars
	Then quit the page

Scenario: verify step two page by providing valid address2 details
	Given user launched webpage
	And user entered valid details in second address line
	Then quit the page

Scenario: verify step two page by providing valid pincode
	Given user launched webpage
	And user entered valid details in pincode
	Then quit the page

Scenario: verify step two page by providing invalid pincode
	Given user launched webpage
	And user entered invalid details in pincode
	Then quit the page

Scenario: verify step two page by providing alphanumeric values in pincode
	Given user launched webpage
	And user entered alphanumeric values in pincode
	Then quit the page

Scenario: verify step two page by providing less than 6 digits
	Given user launched webpage
	And user entered pincode with less than six digits
	Then quit the page

