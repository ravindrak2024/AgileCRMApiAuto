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


