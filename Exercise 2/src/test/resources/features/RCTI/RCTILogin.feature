@AllRCTI
Feature: RCTI LOGIN

  @positive @login
  Scenario: Success login
    Given user is on rcti homepage
    Then user click button login
    And user input email or phone number
    And user input password
    When user click button login pada form login

  @negative1 @login
  Scenario: user can't click button login if still not input field username
    Given user is on rcti homepage
    Then user click button login
    And user input password
    Then button login is disable

  @negative2 @login
  Scenario: user can't click button login if still not input field password
    Given user is on rcti homepage
    Then user click button login
    And user input email or phone number
    Then button login is disable

  @negative3 @login
  Scenario: user input invalid username
    Given user is on rcti homepage
    Then user click button login
    And user input invalid email or phone number
    And user input password
    When user click button login on login form

  @negative4 @login
  Scenario: user input invalid password
    Given user is on rcti homepage
    Then user click button login
    And user input email or phone number
    And user input invalid password
    When user click button login on login form