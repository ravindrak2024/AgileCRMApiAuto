@company
Feature: Company related scenario

  Background:
    Given clean all company



  @smoke
  Scenario: Create a new company and validate if created successfully
    When I create company with below details
      |type   |cname     |url                        |email               |
      |mnc    |persistent|http://www.persistent.co.in|ravi.per@yopmail.com|
    And I get created company
    Then company should be created with name "persistent"


  @smoke
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

  @workflow
  Scenario: Create a new company and validate if created successfully
    When I create company with below details
      |type   |cname     |url                        |email               |
      |mnc    |persistent|http://www.persistent.co.in|ravi.per@yopmail.com|
      |mnc    |tcs|http://www.tataconsultancyservices.com|ravi.tata@yopmail.com|
    And I get all company
    Then all company "should" contain company with name "persistent"
    And  all company "should" contain company with name "tcs"

  @workflowx
  Scenario: Create, delete a company and validate.
    When I create company with below details
      |type   |cname     |url                        |email               |
      |mnc    |persistent|http://www.persistent.co.in|ravi.per@yopmail.com|
      |mnc    |tcs|http://www.tataconsultancyservices.com|ravi.tata@yopmail.com|
    And I delete a company with name "tcs"
    And I get all company
    And  all company "shouldnot" contain company with name "tcs"
    Then all company "should" contain company with name "persistent"

