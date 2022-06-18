
Feature: Update Contact of Addressbook
  Scenario Outline: Update contact
	    When user wants to add contact with <id>,<name>,<city>,<state>,<address>,<phonenumber>,<zipcode>
	    Then Return success message as "Contact updated Successfully"
	    Examples:
	      | id | name     |  city    |   state   |   address    |  phonenumber    | zipcode   |
	      | 16 | "Sonal"  | "Pune"   |   "MH"    | "Shiv Nagar" | "9988776655"    |  445566   |
	  

