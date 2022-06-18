Feature: Addressbook Feature File
  I want to use this template for CURD Operations Testing

  Scenario: Get contact by id
    When Get contact from database whose id is 1
    Then Return success message with status code 200
    
  Scenario: Get all contacts
    When Get All contacts from addressbook 
    Then Return Success with status code 200

	#Scenario Outline: Add contact in addressbook
	 #   When Add contact with <name>,<city>,<state>,<address>,<phonenumber>,<zipcode>
	  #  Then Return success message with staus code 200
	   # Examples:
	     # | name     |  city    |   state   |   address    |  phonenumber    | zipcode   |
	    # | "Sonal"  | "Pune"   |   "MH"    | "Shiv Nagar" | "9988776655"    |  445566   |
	 
  Scenario: Delete contact by id
    When Delete contact  by id 22
    Then Return sucess with status code 200
    
	Scenario Outline: Update contact
	    When Wants to update contact with <id>,<name>,<city>,<state>,<address>,<phonenumber>,<zipcode>
	    Then Return success with status code1 200
	    Examples:
	      | id | name     |  city    |   state   |   address    |  phonenumber    | zipcode   |
	      | 21 | "Sonal"  | "Mumbai" |   "MH"    | "Shiv Nagar" | "9988776655"    |  445566   |
	  