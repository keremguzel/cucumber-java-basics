Feature: Login test

  @Login-Negative
  Scenario Outline: Wrong username error

    Given User is on the login page

    When User is typing a wrong username "<username>"
    And User is typing a correct password "<password>"
    * User click the login button

    Then User gets an error message for wrong username

    Examples:
      | username | password    |
      | kerem    | Password123 |
      | STUDENT  | Password123 |

  @Login-Negative
  Scenario: Wrong password error

    Given User is on the login page

    When User is typing a correct username "student"
    * User is typing a wrong password "pass"
    * User click the login button

    Then User gets an error message for wrong password

  @Login-Positive @SmokeTest
  Scenario: Successfully login

    Given User is on the login page

    When User is typing a correct username "student"
    And User is typing a correct password "Password123"
    And User click the login button

    Then User is navigated to home page