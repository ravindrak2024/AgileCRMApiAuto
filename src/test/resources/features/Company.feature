@company
Feature: Company related scenario

  Background:
    Given clean all company



  Scenario: Create a new company and validate if created successfully
    When I create company with below details
      |type   |cname     |url                        |email               |
      |mnc    |persistent|http://www.persistent.co.in|ravi.per@yopmail.com|
    And I get created company
    Then company should be created with name "persistent"

  @smokeX
  Scenario Outline: Update an existing company and validate
    When I create company with below details
      |type   |cname     |url                        |email               |
      |mnc    |persistent|http://www.persistent.co.in|ravi.per@yopmail.com|
    And I update "<field>" of company as "<value>"
    And I get updated company
    Then company should be updated with "<field>" "<value>"

    Examples:
    |field|value                   |
    |name |Spicejet                |
    |url  |http://www.spicejet.com/|
