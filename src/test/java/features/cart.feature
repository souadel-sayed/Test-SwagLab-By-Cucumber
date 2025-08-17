Feature: verify cart page


  @Cart
  Scenario: select  specific item to buy
    Given I am on the cart page
    When verify product as expected
    And  I click on the check out icon
    Then User proceeds to information page

