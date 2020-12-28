@custRegValidation 
Feature: Customer registration page data validations 

# test cases for step one customer registration page

Scenario: verify step one page without providing details 
	Given user launched webpage 
	Then click on continue button without providing values in step one page 
		|firstname | middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| |  | | | Select gender |  | -- Select -- |  |
	Then quit the page 
	
Scenario: verify continue option by providing valid details in step one 
	Given user launched webpage 
	And user entered all mandatory details in step one 
	Then quit the page 
	
Scenario: verify step one reg details by providing invalid firstname 
	Given user launched webpage 
	And user entered invalid firstname 
	#	Fetching dynamic data from feature file using data table with maps mechanism| 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| 1382djfd | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card |7666666790|
		| 1dj@.)fd | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card |7666666790|
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid middlename 
	Given  user launched webpage 
	And  user entered invalid middlename 
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid lastname 
	Given  user launched webpage 
	And  user entered invalid lastname 
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid dob 
	Given  user launched webpage 
	And  user entered invalid dob 
	Then  quit the page 
	
Scenario: 
	verify step one reg details by providing dob less than min age criteria 
	Given  user launched webpage 
	And  user entered dob less than min age criteria 
	Then  quit the page 
	
Scenario: 
	verify step one reg details by providing dob more than max age criteria 
	Given  user launched webpage 
	And  user entered dob more than max age criteria 
	Then  quit the page 
	
Scenario: verify auto complete city list in step one page 
	Given  user launched webpage 
	And  check auto complete city list when user enters one letter in step one page
		| city |
		| A |
		| Nas |
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid city name 
	Given  user launched webpage 
	And  user entered invalid city name 
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid phonenumber 
	Given  user launched webpage 
	And  user entered invalid phonenumber 
	Then  quit the page 
	
Scenario: verify step one reg details by providing number lessthan ten digits 
	Given  user launched webpage 
	And  user entered phone with less than ten digits 
	Then  quit the page 
	
	#test cases for step two customer registration page
	
	
Scenario: verify step two page without passing any details 
	Given  user launched webpage
	Then  click on continue button without providing details in step two page 
	Then  quit the page 
	
Scenario: verify step two page by valid details 
	Given  user launched webpage 
	And  user given valid details 
	Then  quit the page 
	
Scenario:
verify if customer provides age of city greater than age of residence in step two page 
	Given  user launched webpage
	And   customer provides age of city greater than age of residence 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | Less than 1 year | abcfder,asdef, | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
	
Scenario: verify step two page by providing address1 with less than 3 chars 
	Given  user launched webpage
	And  user entered first adrress line with less than minimum chars 
	Then  quit the page 
	
Scenario: verify step two page by providing address1 with less than 3 chars 
	Given  user launched webpage
	And  user entered first adrress line with less than minimum chars includes special chars 
	Then  quit the page 
	
Scenario: verify step two page by providing address1 with three repeated chars 
	Given  user launched webpage 
	And  user entered first adrress line with three repeated chars 
	Then  quit the page 
	
Scenario: 
	verify step two page by providing address1 with unsupporrted special chars 
	Given user launched webpage
	And  user entered first adrress line with unsupported special chars 
	Then  quit the page 
	
Scenario: verify step two page by providing address2 with less than 3 chars 
	Given user launched webpage 
	And  user entered second adrress line with less than minimum chars 
	Then  quit the page 
	
Scenario: verify step two page by providing address2 with less than 3 chars 
	Given user launched webpage 
	And  user entered second adrress line with less than minimum chars includes special chars 
	Then  quit the page 
	
Scenario: verify step two page by providing address2 with three repeated chars 
	Given  user launched webpage
	And  user entered second adrress line with three repeated chars 
	Then  quit the page 
	
Scenario: 
	verify step two page by providing address2 with unsupporrted special chars 
	Given user launched webpage 
	And  user entered second adrress line with unsupported special chars 
	Then  quit the page 
	
Scenario: verify step two page by providing invalid pincode 
	Given user launched webpage 
	And  user entered invalid details in pincode 
	Then  quit the page 
	
Scenario: verify step two page by providing alphanumeric values in pincode 
	Given user launched webpage
	And  user entered alphanumeric values in pincode 
	Then  quit the page 
	
Scenario: verify step two page by providing pincode with less than 6 digits 
	Given  user launched webpage
	And  user entered pincode with less than six digits 
	Then  quit the page 
	
	
