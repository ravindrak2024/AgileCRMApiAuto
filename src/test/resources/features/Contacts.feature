Feature: Feature to test Contacts functionality.

  Background:
    Given clean all contacts

  Scenario: Check create contact with valid details
    When I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    Then user should be created with first_name "Rahul"
    And owner email should be "ravikadagoudar@yopmail.com"


  Scenario Outline: Check create contact with invalid details
    When I create the invalid contact with below details
      |first_name |last_name    |email            |
      |<fname>    |<lname>      |<email_add>      |
    Then user should not be created and response should have statuscode <status_codes>

    Examples:
    |fname | lname | email_add        | status_codes|
    |      |       |                  | 500         |

  Scenario: Check update contact with valid details
    When I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    Then user should be created with first_name "Rahul"
    And owner email should be "ravikadagoudar@yopmail.com"
    Then I update "email" of user to "rahul.mane@yopmail.com"
    And I get user and check "email" is "rahul.mane@yopmail.com"
    Then I update "first_name" of user to "rakesh"
    And I get user and check "first_name" is "rakesh"


  Scenario: Check update contact lead score with valid details
    When I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    Then user should be created with first_name "Rahul"
    And I update "lead_score" of contact with value 40
    Then user's lead_score should be 40


  Scenario: Check delete tags of contact
    When I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    Then user should be created with first_name "Rahul"
    And I delete "tags" of contact
    Then I get contact
    And contact "tags" should be "empty"


  Scenario: Check multiple contact create and validate list of contacts
    When I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
      |Rajesh    |kumar    |rajesh@yopmail.com|
    And get all contacts
    Then number of contacts should be 2

  Scenario: Check search contact by email id
    Given I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
      |Rajesh    |kumar    |rajesh@yopmail.com|
    When I search contact by id "rajesh@yopmail.com"
    Then contact with email "rajesh@yopmail.com" should be present

 Scenario: Adding tags to a contact based on email id
    Given I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    When I add tags "selenium,automation" for contact with email "rahul@yopmail.com"
    And I get contact
    Then contact "tags" should contain "selenium,automation"



  Scenario: Delete tags to a contact based on email id
    Given I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    When I delete tags "Lead,Subject" for contact with email "rahul@yopmail.com"
    And I get contact
    Then contact "tags" should be "empty"

  @smoke
  Scenario: Add score to contact using email ID
    Given I create the contact with following details
      |first_name|last_name|email            |
      |Rahul     |mane     |rahul@yopmail.com|
    When I add score value 30 to the contact with email "rahul@yopmail.com"
    And I get contact
    Then contact "score" should be "50"