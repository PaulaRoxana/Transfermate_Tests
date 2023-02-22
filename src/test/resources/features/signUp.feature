 Feature: Sign Up - new user registration

  Background: Open the page of new user registration
    Given The Sign Up page is opened

  Scenario Outline: (TC_9_1 -> PASS) Successful account registration, user is navigated to Email And Mobile Number Verification Page
    When user selects an account type "<account type>"
    And user fills the following fields on the form with given values
      | field name   | value          |
      | country      | Romania        |
      | first_name   | generateRandom |
      | last_name    | generateRandom |
      | email        | generateRandom |
      | phone_prefix | Romania        |
      | mobile_phone | generateRandom |
    And user checks the Terms of Use and Privacy Policy checkbox
    And user checks the News and Offers checkbox
    And user enters the correct captcha result
    And user clicks on Open my free account button
    Then user is navigated to Email And Mobile Number Verification Page
    Examples:
      | account type |
      | individual   |
      | sole_trader  |

  Scenario Outline: (TC_9.2 -> PASS) (Verify) user cannot proceed on Email And Mobile Number Verification Page
                    by utilizing an already used "Email" address
    When user selects an account type "<account type>"
    And user fills the following fields on the form with given values
      | field name   | value                    |
      | country      | Romania                  |
      | first_name   | generateRandom           |
      | last_name    | generateRandom           |
      | email        | mathew.mayer@example.com |
      | phone_prefix | Romania                  |
      | mobile_phone | generateRandom           |
    And user checks the Terms of Use and Privacy Policy checkbox
    And user checks the News and Offers checkbox
    And user enters the correct captcha result
    And user clicks on Open my free account button
    Then error message "Already exists!" is displayed above Email field
    And user remains on Sign Up page
    Examples:
      | account type |
      | individual   |

  Scenario Outline: (TC_9.3 -> FAIL) (Verify) user cannot proceed on Email And Mobile Number Verification Page by utilizing
  an already used "Mobile Phone" number
    When user selects an account type "<account type>"
    And user fills the following fields on the form with given values
      | field name   | value          |
      | country      | United Kingdom |
      | first_name   | generateRandom |
      | last_name    | generateRandom |
      | email        | generateRandom |
      | phone_prefix | United Kingdom |
      | mobile_phone | 6603512114     |
    And user checks the Terms of Use and Privacy Policy checkbox
    And user checks the News and Offers checkbox
    And user enters the correct captcha result
    And user clicks on Open my free account button
    Then error message "Already exists!" is displayed above Mobile Phone field
    And user remains on Sign Up page
    Examples:
      | account type |
      | individual   |


  Scenario Outline: (TC_9_4-> PASS) (Verify) user cannot proceed on Email And Mobile Number Verification Page
  without checking the Terms of Use and Privacy Policy checkbox
    When user selects an account type "<account type>"
    And user fills the following fields on the form with given values
      | field name   | value          |
      | country      | Romania        |
      | first_name   | generateRandom |
      | last_name    | generateRandom |
      | email        | generateRandom |
      | phone_prefix | Romania        |
      | mobile_phone | 1452850746     |
    And user checks the News and Offers checkbox
    And user enters the correct captcha result
    And user clicks on Open my free account button
    Then error message is displayed above Terms of Use and Privacy Policy checkbox
    And user remains on Sign Up page
    Examples:
      | account type |
      | individual   |

  Scenario Outline: (TC_9_5-> PASS) (Verify) user can proceed on Email And Mobile Number Verification Page
                    without checking the News and Offers checkbox
    When user selects an account type "<account type>"
    And user fills the following fields on the form with given values
      | field name        | value                   |
      | country           | Romania                 |
      | first_name        | generateRandom          |
      | last_name         | generateRandom          |
      | email             | generateRandom          |
      | phone_prefix      | Romania                 |
      | mobile_phone      | 1452850746              |
    And user checks the Terms of Use and Privacy Policy checkbox
    And user enters the correct captcha result
    And user clicks on Open my free account button
    Then user is navigated to Email And Mobile Number Verification Page
    Examples:
      | account type|
      | individual|
