@custRegFieldValidation 
Feature: Customer registration page field validations 
#This feature file contains all field validations test cases
#For dynamic data used data tables with maps mechanism

#test cases for step one customer registration page

Scenario: verify moneytap logo
	Given user launched the moneytap webqual page 
	Then verify moneytap logo
	Then close the page  

Scenario: Verify firstname text field 
	Given user launched the moneytap webqual page 
	Then verify firstname text field 
	Then close the page 
	
Scenario: verify middlename text field 
	Given user launched the moneytap webqual page 
	Then verify middlename text field 
	Then close the page 
	
Scenario: verify lastname text field 
	Given user launched the moneytap webqual page 
	Then verify lastname text field 
	Then close the page 
	
Scenario: verify dob text field 
	Given user launched the moneytap webqual page 
	Then verify dob text field 
	Then close the page 
	
Scenario: verify gender dropdown 
	Given user launched the moneytap webqual page 
	Then verify gender dropdown field 
	Then close the page 
	
Scenario: verify city of residence text field 
	Given user launched the moneytap webqual page 
	Then verify city of residence text field 
	Then close the page 
	
Scenario: verify credit history dropdown 
	Given user launched the moneytap webqual page 
	Then verify credit history dropdown field 
	Then close the page 
	
Scenario: verify phone number text field 
	Given user launched the moneytap webqual page 
	Then verify phone number text field 
	Then close the page 
	
	# test cases for step two customer registration page
	
Scenario: verify residence type drowndown option in step two page 
	Given user launched webpage and completed first step 
	Then verify residence type dropdown option 
	Then close the page 
	
	
Scenario: verify years in current residence drowndown option in step two page 
	Given user launched webpage and completed two steps 
	Then verify years in current residence drowndown option 
	Then close the page 
	
Scenario: verify years in current city drowndown option in step two page 
	Given user launched webpage and completed first step 
	Then verify years in current city drowndown option 
	Then close the page 
	
	
Scenario: verify address1 text field in step two page 
	Given user launched webpage and completed first step 
	Then verify first address line text field 
	Then close the page 
	
Scenario: verify address2 text field in step two page 
	Given user launched webpage and completed first step 
	Then verify second address line text field 
	Then close the page 
	
Scenario: verify pincode text field in step two page 
	Given user launched webpage and completed first step 
	Then verify pincode text field 
	Then close the page 
	
Scenario: verify city text field in step two page 
	Given user launched webpage and completed first step 
	Then verify city text field 
	Then close the page 
	
Scenario: verify state text field in step two page 
	Given user launched webpage and completed first step 
	Then verify state text field 
	Then close the page 
	
Scenario: verify continue button 
	Given user launched webpage and completed first step 
	Then verify continue button 
	Then close the page 
	
	# test cases for step-3 registration page
	
	
Scenario: verify company name text field 
	Given user launched webpage and completed two steps 
	Then verify company name text field 
	Then close the page 
	
Scenario: verify company type dropdown button 
	Given user launched webpage and completed two steps 
	Then verify company type dropdown button 
	Then close the page 
	
Scenario: verify designation text field 
	Given user launched webpage and completed two steps 
	Then verify designation text field 
	Then close the page 
	
Scenario: verify pan number text field 
	Given user launched webpage and completed two steps 
	Then verify pan number text field 
	Then close the page 
	
Scenario: verify job type dropdown button 
	Given user launched webpage and completed two steps 
	Then verify job type dropdown button 
	Then close the page 
	
Scenario: verify total work experience dropdown button 
	Given user launched webpage and completed two steps 
	Then verify total work experience dropdown button 
	Then close the page 
	
Scenario: verify work experience in current company dropdown button 
	Given user launched webpage and completed two steps 
	Then verify work experience in current company dropdown button 
	Then close the page 
	
Scenario: verify office email text field 
	Given user launched webpage and completed two steps 
	Then verify office email text field 
	Then close the page 
	
Scenario: verify salary text field 
	Given user launched webpage and completed two steps 
	Then verify salary text field 
	Then close the page 
	
Scenario: verify salary mode dropdown button 
	Given user launched webpage and completed two steps 
	Then verify salary mode dropdown button 
	Then close the page 
	
Scenario: verify bank name dropdown button 
	Given user launched webpage and completed two steps 
	Then verify bank name dropdown button 
	Then close the page 
	
	#verification and submission field validation cases
	
Scenario: verify phone number text field 
	Given user launched the webpage and completed all three steps 
	Then verify phone number text field in verification page 
	Then close the page 
	
Scenario: verify otp text field 
	Given user launched the webpage and completed all three steps 
	Then verify otp text field 
	Then close the page 
	
Scenario: verify promo code text field 
	Given user launched the webpage and completed all three steps 
	Then verify promo code text field 
	Then close the page 
	
Scenario: verify send otp button 
	Given user launched the webpage and completed all three steps 
	Then verify send otp button 
	Then close the page 
	
Scenario: verify apply code button 
	Given user launched the webpage and completed all three steps 
	Then verify apply code button 
	Then close the page 
	
Scenario: verify userConsent checkbox 
	Given user launched the webpage and completed all three steps 
	Then verify userConsent checkbox 
	Then close the page 
	
Scenario: verify whatsApp notification checkbox 
	Given user launched the webpage and completed all three steps 
	Then verify whatsApp notification checkbox 
	Then close the page 
	
Scenario: verify check limit CTA button 
	Given user launched the webpage and completed all three steps 
	Then verify check limit CTA button 
	Then close the page 
		
Scenario: verify panpopup text field 
	Given user launched webpage and completed two steps 
	Then verify text field which is present in panpopup msg 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|FXSPK4506F|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then close the page 
	
Scenario: verify panpopup CTA button
	Given user launched webpage and completed two steps 
	Then verify panpopup CTA button
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|FXSPK4506F|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then close the page 
	
	
	