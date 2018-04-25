@Cleartrip_login
Feature: verify i am login to cleartrip

  @Verify_the_entered_userid_password_are_correct
  Scenario Outline: Verify i am able to login with multiple credential
    Given i am on cleartrip home page
    And i enter "<username>" and "<password>"
    Then i login successfully
    Then i logout successfully from cleartrip application

    Examples: 
      | username              | password    |
      | komal.jha26@gmail.com | Komal@12345 |
      | bh                    | gh          |
      | incide                | doo         |
      | komal.jha26@gmail.com | Komal@12345 |
