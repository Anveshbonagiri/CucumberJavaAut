Feature: Login page feature

  @Login
  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @Login
  Scenario: Forgot passwork link
    Given user is on login page
    Then forgot your passwork link should be displayed

  @Login
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "bonagirianvesh123@gmail.com"
    And user enters password "Test1test"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"
