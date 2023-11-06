Feature: Login test

  @Login-Negative
  Scenario Outline: Wrong username error
    Given User is on the login page
    When User is typing a correct username "<username>"
    And User is typing a wrong password "<password>"
    * User click the login button
    Then User gets an error message

    Examples:
      | username | password |
      | student  | password |
      | student  | 12345    |

  @Login-Negative
  Scenario: Wrong password error
    Given User is on the login page
    When User is typing a correct username "student"
    * User is typing a wrong password "pass"
    * User click the login button
    Then User gets an error message

  @Login-Positive @SmokeTest
  Scenario: Successfully login
    Given User is on the login page
    When User is typing a correct username "student"
    And User is typing a correct password "Password123"
    And User click the login button
    Then User is navigated to home page

