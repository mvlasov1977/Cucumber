Feature: Login test
  As a common user
  I want to logging in
  So that I enter my credentials

  Scenario: Login test positive scenario
    Given I open login page
    When I enter my 'tomsmith' login password on the Login Page
    And I enter my 'SuperSecretPassword!' password on the Login Page
    And I click on submit button on the Login Page
    Then The main page is displayed