Feature: Addressbook to get contact by id;
  I want to use this template to get contact by id

  Scenario: get contact by id
    When Get contact by 1
    Then Return success message
    
