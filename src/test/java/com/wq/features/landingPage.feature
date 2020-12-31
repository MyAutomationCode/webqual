@landingPageValidation
Feature: WQ landing page Validataion 


Scenario: Validate landing page title 
	Given user already launched the moneytap webqual page 
	Then verify the webpage title 
	Then close the webpage


Scenario: Validate moneytap benefits
	Given user already launched the moneytap webqual page 
	Then verify the main heading under the offers page
	Then verify the subheading of first offer
	Then verify the content of first offer
	Then verify the subheading of second offer
	Then verify the content of second offer
	Then verify the subheading of third offer
	Then verify the content of third offer
	Then verify the subheading of fourth offer
	Then verify the content of fourth offer
	Then verify the subheading of fifth offer
	Then verify the content of fifith offer
	Then close the webpage

Scenario: Validate login button
	Given user already launched the moneytap webqual page 
	Then verify login button
	Then close the webpage

Scenario: Validate customer reg step one title
	Given user already launched the moneytap webqual page 
	Then verify customer reg step one title
	Then close the webpage
	
Scenario: Validate scroll bar option in landing page	
	Given user already launched the moneytap webqual page 
	Then find the scroll bar in webpage and verify
	Then close the webpage
