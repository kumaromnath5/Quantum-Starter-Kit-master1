@amazonhome
Feature: I am on amazon home page

  @amazonpage
  Scenario: Verify i am on amazon home page
    Given I am amazon home page
    And verify the title of amazon home page
    Then verify carrier of the page
