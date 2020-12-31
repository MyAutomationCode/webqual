@test
Feature: Customer registration page data validations 
	
# test cases for verification and submission flow


Scenario: verify submission page by providing valid details
	Given  user launched webpage and completed all three steps
	Then  verify submission page by providing valid details
	|promoCode|
	|  | 
	Then  quit the page 


Scenario: verify submission page without providng any details
	Given  user launched webpage and completed all three steps 
	Then  verify submission page witout providng any details
	|phone|otp|promoCode|
	|  | |  | 
	Then  quit the page 
	

Scenario: verify submission page by removing the pre-filled mobile number
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by removing the pre-filled mobile number
	|phone|otp|promoCode|
	|  | 1234|  | 
	Then  quit the page 


Scenario: verify submission page by providing mobile num with less than ten digits
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing mobile num with less than ten digits
	|phone|otp|promoCode|
	| 8790867 | 1234 |  | 
	Then  quit the page 


Scenario: verify submission page by providing mobile num with alphanumeric values
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing mobile num with alphanumeric values
	|phone|otp|promoCode|
	| 8790gt13 | 1234 |  | 
	Then  quit the page 


Scenario: verify submission page by providing mobile num with special chars
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing mobile num with special chars
	|phone|otp|promoCode|
	| @3fe_2@! |1234 |  | 
	Then  quit the page 


Scenario: verify submission page by providing invalid otp
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing invalid otp
	|otp|promoCode|
	| 12D# |  | 
	Then  quit the page 
	

Scenario: verify submission page by providing otp with alphabet values
	Given  user launched webpage and completed all three steps  
	Then  verify submission page by providing otp with alphabet values
	|otp|promoCode|
	| DERe |  | 
	Then  quit the page 
	

Scenario: verify submission page by providing otp with less than required digits
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing otp with less than required digits
	|otp|promoCode|
	| 106 |  | 
	Then  quit the page 

Scenario: verify submission page by providing valid mobile num with wrong otp
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing valid mobile num with wrong otp
	|otp|promoCode|
	| 1203 |  | 
	Then  quit the page 

Scenario: verify submission page by providing valid mobile num without otp
	Given  user launched webpage and completed all three steps  
	Then  verify submission page by providing valid mobile num without otp
	|otp|promoCode|
	|  |  | 
	Then  quit the page 

Scenario: verify submission page without mobile num with valid otp
	Given  user launched webpage and completed all three steps 
	Then  verify submission page without mobile num with valid otp
	|phone|otp|promoCode|
	|  | 1102 |  | 
	Then  quit the page 

Scenario: verify submission page by providing different mobile num and otp
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing different mobile num and otp
	|phone|otp|promoCode|
	| 7000000801 | 1201 |  | 
	Then  quit the page 

#Scenario: verify submission page when server is down
#Given  user launched webpage and completed all three steps 
#	Then  verify submission page when server is down
#	|phone|otp|promoCode|
#	| 8790867011 | 1201 |  | 
#	Then  quit the page 

Scenario: verify submission page by providing expired otp
	Given  user launched webpage and completed all three steps 
	Then  verify submission page by providing expired otp
	|otp|promoCode|
	| 1231 |  | 
	Then  quit the page 


Scenario: verify apply code option by providing wrong promo code
	Given user launched webpage and completed all three steps
	Then  verify apply code option by providing wrong promo code
	|otp|promoCode|
	|| WERFRE |
	Then  quit the page 

Scenario: verify apply code option by providing valid promo code
	Given user launched webpage and completed all three steps
	Then  verify apply code option by providing valid promo code
	|otp|promoCode|
	||VC2484G|
 	Then  quit the page 

Scenario: verify apply code option without providing promo code
	Given user launched webpage and completed all three steps
	Then  verify apply code option without providing promo code
	Then  quit the page 

Scenario: verify user consent weblink
	Given user launched webpage and completed all three steps
	Then  verify user consent weblink
	Then  quit the page 

Scenario: verify terms and conditions link
	Given user launched webpage and completed all three steps
	Then  verify terms and conditions link
	Then  quit the page 

Scenario: verify privacy policy link
	Given user launched webpage and completed all three steps
	Then  verify privacy policy link
	Then  quit the page 

#Scenario: verify submission page without selecting whatsup notifiation option
#	Given user launched webpage and completed all three steps
#	Then  verify submission page without selecting whatsup notifiation option
#	|promoCode|
#	||
#	Then  quit the page 

#Scenario: verify submission page by selecting whatsup notifiation option
#	Given user launched webpage and completed all three steps
#	Then  verify submission page by selecting whatsup notifiation option
#	|promoCode|
#	||
#	Then  quit the page 

Scenario: verify otp sent notification when user clicks on send otp option
	Given user launched webpage and completed all three steps
	Then  verify otp sent notification when user clicks on send otp option
	Then  quit the page 

	
	
