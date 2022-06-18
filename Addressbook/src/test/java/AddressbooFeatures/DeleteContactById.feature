
Feature: Delete Contact by Id from Addressbook
  
  Scenario: Delete contact by id
    When Get contact  by id 15
    Then Return message "Conatct Deleted Successfully"

 