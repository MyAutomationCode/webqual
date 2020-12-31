@custRegDataValidation 
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
	Then user entered all mandatory details in step one 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1993 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then quit the page 
	
Scenario: verify step one reg details by providing invalid firstname 
	Given user launched webpage 
	Then user entered invalid firstname 
	#	Fetching dynamic data from feature file using data table with maps mechanism| 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| 1382djfd | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card |7666666800|
		| 1dj@.)fd | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card |7666666800|
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid middlename 
	Given  user launched webpage 
	Then  user entered invalid middlename 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abrah@#m | roy | 20/08/1993 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid lastname 
	Given  user launched webpage 
	Then  user entered invalid lastname 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | r@#12oy | 20/08/1993 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid dob 
	Given  user launched webpage 
	Then  user entered invalid dob 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 40/40/4993 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: 
	verify step one reg details by providing dob less than min age criteria 
	Given  user launched webpage 
	Then  user entered dob less than min age criteria 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1999 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: 
	verify step one reg details by providing dob more than max age criteria 
	Given  user launched webpage 
	Then  user entered dob more than max age criteria 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1945 | Male | Bangalore | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: verify auto complete city list in step one page 
	Given  user launched webpage 
	Then  check auto complete city list when user enters one letter in step one page 
		| city |
		| A |
		| Nas |
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid city name 
	Given  user launched webpage 
	Then  user entered invalid city name 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1993 | Male | Rajamundry | I have an active credit card | 7666666800 |
	Then  quit the page 
	
Scenario: verify step one reg details by providing invalid phonenumber 
	Given  user launched webpage 
	Then  user entered invalid phonenumber 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1993 | Male | Bangalore | I have an active credit card | 7A666@6800 |
	Then  quit the page 
	
Scenario: verify step one reg details by providing number lessthan ten digits 
	Given  user launched webpage 
	Then  user entered phone with less than ten digits 
		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
		| john | abraham | roy | 20/08/1993 | Male | Bangalore | I have an active credit card | 76666668 |
	Then  quit the page 
	
	#Scenario: verify step one reg details by providing phone number which is already registered
	#	Given  user launched webpage 
	#	And  user entered phone which is already reigstered in step one page
	#		|firstname| middlename | lastname | dob | gender | city | creditHistory | phoneNumber |
	#		| john | Raju | Devathi | 20/08/1993 | Male | Bangalore | I have an active credit card | 7666666705 |
	#	Then  quit the page 
	
	
	#test cases for step two customer registration page
	
	
Scenario: verify step two page without passing any details 
	Given  user launched webpage 
	Then  click on continue button without providing details in step two page 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		|-- Select -- | -- Select -- | -- Select -- |   |    |   |
	Then  quit the page 
	
Scenario: verify step two page by providing valid details 
	Given  user launched webpage 
	Then  user given valid details in step two page 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
Scenario: 
	verify if customer provides age of city greater than age of residence in step two page 
	Given  user launched webpage 
	Then  customer provides age of city greater than age of residence 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | Less than 1 year | abcfder,asdef, | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
Scenario: verify step two page by providing address1 with less than 3 chars 
	Given  user launched webpage 
	Then  user entered first adrress line with less than minimum chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | ab | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
Scenario: 
	verify step two page by providing address1 with less than 3 chars and includes special chars 
	Given  user launched webpage 
	Then  user entered first adrress line with less than minimum chars includes special chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | @4 | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
Scenario: verify step two page by providing address1 with three repeated chars 
	Given  user launched webpage 
	And  user entered first adrress line with three repeated chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | aaa,aaa | sigma soft, whitefield | 560043 |
	Then  quit the page 
	
Scenario: 
	verify step two page by providing address1 with unsupporrted special chars 
	Given user launched webpage 
	Then  user entered first adrress line with unsupported special chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | (4rth floor), | sigma soft, whitefield | 560043 |
	Then  quit the page 

Scenario: verify step two page by providing address2 with less than 3 chars 
	Given user launched webpage 
	Then  user entered second adrress line with less than minimum chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | si | 560043 |
	Then  quit the page 

Scenario: verify step two page by providing address2 with less than 3 chars which includes special chars
	Given user launched webpage 
	Then  user entered second adrress line with less than minimum chars includes special chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | s! | 560043 |
	Then  quit the page 
	
Scenario: verify step two page by providing address2 with three repeated chars 
	Given  user launched webpage 
	Then  user entered second adrress line with three repeated chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | efff,rddd,wsss,| 560043 |
	Then  quit the page 
	
Scenario: verify step two page by providing address2 with unsupported special chars 
	Given user launched webpage 
	Then  user entered second adrress line with unsupported special chars 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | %$()sigma, soft, tech | 560043 |
	Then  quit the page 
	
Scenario: verify step two page by providing invalid pincode 
	Given user launched webpage 
	Then  user entered invalid pincode which is not relavent to given city
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | sigma soft, whitefield | 100013 |
	Then  quit the page 
	
Scenario: verify step two page by providing alphanumeric values in pincode 
	Given user launched webpage 
	Then  user entered alphanumeric and special letters in pincode 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | sigma soft, whitefield | 56qw@_e3 |
	Then  quit the page 
	
Scenario: verify step two page by providing pincode with less than 6 digits 
	Given  user launched webpage 
	Then  user entered pincode with less than six digits 
		| residenceType | years in residence | years in city | address1 | address2 | pincode |
		| Rented with Family | 1 - 3 years | 1 - 3 years | 4rth floor,Moneytap | sigma soft, whitefield | 5603 |
	Then  quit the page 
	
	# test cases for step 3 customer registration
	
Scenario: verify step three reg details by providing valid details 
	Given  user launched webpage 
	Then  user provided all valid details and clicks on continue in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then  quit the page 
	
Scenario: verify step three reg details without providing details 
	Given  user launched webpage 
	Then  click on continue button without providing any details in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|  |-- Select --|  |  |-- Select --|-- Select --|-- Select --|  |  |-- Select --|-- Select --|
	Then  quit the page 
	
	
Scenario: verify auto complete company list in step three page 
	Given  user launched webpage 
	Then  check auto complete company list when user enters one letter in step three page 
		|companyName|
		|M|
		|L|
		|J|
	Then  quit the page 
	
Scenario: 
	verify company name text field by providing invalid name in step three page 
	Given  user launched webpage 
	Then  verify company name text field by providing specialChars in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|mud1@##_)|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then  quit the page 
	
Scenario: verify auto complete designation list in step three page 
	Given  user launched webpage 
	Then  check auto complete designation list when user enters one letter in step three page 
		|designation|
		|M|
		|AS|
		|Q|
	Then  quit the page 
	
Scenario: 
	verify designation text field by providing invalid name in step three page 
	Given user launched webpage 
	Then  verify designation list text field by providing invalid name in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Acc@0132!_|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then  quit the page 
	
Scenario: verify with invalid pan in step three page 
	Given  user launched webpage 
	Then verify pan number field by providing invalid number in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKqw1213S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: verify pannumber field by providing all alphabets 
	Given  user launched webpage 
	Then verify pan number field by providing all alphabets in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|CKEPDEWQWQ|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: 
	verify pannumber field by providing number in case sensitive in step three page 
	Given  user launched webpage 
	Then verify pan number field by providing number in case sensitive in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|ckapd3458l|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: 
	verify pannumber field by providing number with invalid sequence in step three page 
	Given  user launched webpage 
	Then verify pannumber field by providing number with invalid sequence in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|12dkee4rx|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: 
	verify pannumber field by providing less than required letters in step three page 
	Given  user launched webpage 
	Then verify pannumber field by providing number with less than required letters in step three page 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|12drx|Salaried|More than 3 years|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: 
	verify if customer provides current company experience greater than total work experience in step three page 
	Given  user launched webpage 
	Then user provides current company experience greater than total work experience 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|12drx|Salaried|Less than 1 year|More than 3 years|test@moneytap.com|45000|Netbanking|ICICI Bank|
	Then  quit the page 
	
Scenario: verify email text field with invalid format 
	Given  user launched webpage 
	Then  user provides invalid email 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test01.moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: verify email text field with invalid emailId at starting of the id 
	Given  user launched webpage 
	Then  user provides invalid emailId at starting of the name 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|(@1Atest01)@moneytap.com|45000|Netbanking|ICICI Bank|
	Then quit the page 
	
Scenario: verify salary text field by providing less than 15k 
	Given  user launched webpage 
	Then user provides salary less than 15k 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|12000|Netbanking|ICICI Bank|
	Then quit the page 
	
	
Scenario: verify salary text field by providing greater than 10Lakhs 
	Given  user launched webpage 
	Then user provides salary greater than 10Lakhs 
		|companyName|companyType|designation|PAN|jobType|totalWorkExp|currentWorkExp|officeEmail|salary|salaryMode|bankName|
		|MUDRA|Private Limited|Engineer|COKPQ1234S|Salaried|More than 3 years|More than 3 years|test@moneytap.com|9999999|Netbanking|ICICI Bank|
	Then quit the page 
	
	
# test cases for verification and submission flow

@smoke
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
@smoke	
Scenario: verify submission page without selecting whatsup notifiation option
	Given user launched webpage and completed all three steps
	Then  verify submission page without selecting whatsup notifiation option
	|promoCode|
	||
	Then  quit the page 
@smoke
Scenario: verify submission page by selecting whatsup notifiation option
	Given user launched webpage and completed all three steps
	Then  verify submission page by selecting whatsup notifiation option
	|promoCode|
	||
	Then  quit the page 
@smoke
Scenario: verify otp sent notification when user clicks on send otp option
	Given user launched webpage and completed all three steps
	Then  verify otp sent notification when user clicks on send otp option
	Then  quit the page 
	
Scenario: verify resend otp in 30sec option
	Given user launched webpage and completed all three steps
	Then  verify resend otp in 30sec option
	Then  quit the page
