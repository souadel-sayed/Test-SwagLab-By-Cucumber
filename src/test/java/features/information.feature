Feature: enter user information to check out


  @information
  Scenario Outline: verifying the user information
    Given I am on the information page
    When Enter "<firstname>" and "<lastname>" and "<zipcode>"
    And click on Continue buttoun
    Then User proceeds to Overview page

    Examples:
      | firstname   | lastname    | zipcode     |
      | Souad       |  elsayed    |12345        |
