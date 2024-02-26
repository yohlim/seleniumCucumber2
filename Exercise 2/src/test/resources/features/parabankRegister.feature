@All
Feature: Para bank registration

  @positive @register
  Scenario:Success register
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user input name
    And user input address detail
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user regist succesfully

  @negative1 @allNegativecase @register
  Scenario: Failed register - Missmatch password
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user input name
    And user input address detail
    And user fill valid username and password
    And user input password confirmation
    And user input invalid password confirmation
    When user click register button
    Then user get err password did not match

  @negative2 @allNegativecase @register
  Scenario: user register with username has been registered
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user input name
    And user input address detail
    And user fill username and password has been registered before
    And user input password confirmation username has been registered
    When user click register button
    Then user get message This username already exists

   @negative3 @allNegativecase @register
  Scenario: user click button register without input anykind on field form register
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user click register button
    Then user get message required on each field

   @negative4 @allNegativecase @register
  Scenario: user click button register without input field firstname
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field lastname
    And user input address detail
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message First name is required.

    @negative5 @allNegativecase @register
  Scenario: user click button register without input field lastname
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input address detail
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message lastname is required.

   @negative6 @allNegativecase @register
  Scenario: user click button register without input field address
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field city,state,zipcode,phone,dan ssn
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message address is required.

   @negative7 @allNegativecase @register
  Scenario: user click button register without input field city
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,state,zipcode,phone,dan ssn
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message city is required.

   @negative8 @allNegativecase @register
  Scenario: user click button register without input field state
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,zipcode,phone,dan ssn
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message state is required.

    @negative9 @allNegativecase @register
  Scenario: user click button register without input field zipcode
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,phone,dan ssn
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message zipcode is required.

   @negative10 @allNegativecase @register
  Scenario: user click button register without input field phone
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,zipcode,dan ssn
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user regist succesfully

   @negative11 @allNegativecase @register
  Scenario: user click button register without input field ssn and phone
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,zipcode
    And user fill valid username and password
    And user input password confirmation
    When user click register button
    Then user get message Social Security Number is required.

  @negative12 @allNegativecase @register
  Scenario: user click button register without input field username
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,zipcode,phone,dan ssn
    And user fill valid password
    And user input password confirmation
    When user click register button
    Then user get message username is required.

  @negative13 @allNegativecase @register
  Scenario: user click button register without input field password
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,zipcode,phone,dan ssn
    And user input username confirmation
    And user input password confirmation
    When user click register button
    Then user get message password is required.

   @negative14 @allNegativecase @register
  Scenario: user click button register without input field password confirmation
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    And user input field firstname
    And user input field lastname
    And user input field address,city,state,zipcode,phone,dan ssn
    And user fill valid username and password
    When user click register button
    Then user get message password confirmation is required.

