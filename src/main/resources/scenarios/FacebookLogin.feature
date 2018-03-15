@Facebook_Login
Feature: As i login in facebook

  @Login_with_valid_credentials
  Scenario Outline: Verify with valid cred
    Given open facebook page
    And Enter "<Username>"
    And Enter "<Password>"
    Then I am on home page

    Examples: 
      | Username | Password |
      | omnath   | jha      |
