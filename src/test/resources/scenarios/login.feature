Feature: Login test
  As a common user
  I want to logging in
  So that I enter my credentials

  Scenario: Login test positive scenario
    Given I open login page
    When I enter my 'tomsmith' login on the Login Page
    And I enter my 'SuperSecretPassword!' password on the Login Page
    And I click on submit button on the Login Page
    Then The main page is displayed

  Scenario Outline: Login test negative scenario like bad credentials
    Given I open login page
    When I enter my '<login>' login on the Login Page
    And I enter my '<password>' password on the Login Page
    And I click on submit button on the Login Page
    Then I see alarm '<message>'

    Examples:
    | login | password | message |
    | tomsmith | blablabla | Your password is invalid! |
    | mvlasov | SuperSecretPassword! | Your username is invalid! |
    | mvlasov | blablabla | Your username is invalid! |