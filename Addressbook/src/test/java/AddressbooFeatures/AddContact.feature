Feature: Addressbook to Add Contact

	Scenario Outline: Add contact
	    When user wants to add contact with <name>,<city>,<state>,<address>,<phonenumber>,<zipcode>
	    Then Return success message as Employee Created successfully
	    Examples:
	      | name     |  city    |   state   |   address    |  phonenumber    | zipcode   |
	      | "Sonal"  | "Pune"   |   "MH"    | "Shiv Nagar" | "9988776655"    |  445566   |
	  