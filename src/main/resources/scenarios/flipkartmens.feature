@Flipkart_mens
Feature: I am on flipkart mens page

  @navigate_mens
  Scenario: Verify i am on flipkart mens page
    Given i am on flipkart home page
    And i select mens section
    Then i select tshirt
    Then i am on tshirt dscprition page