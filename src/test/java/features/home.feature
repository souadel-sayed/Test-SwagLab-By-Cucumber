Feature: Select item to buy


  @Home
  Scenario Outline: select  specific item to buy
    Given I am on the hOME PAGE page
    When I clickon add "<product_name>" to cart
    And  I click on the cart icon
    Then User proceeds to Cart page

    Examples:
      | product_name                     |
      | Sauce Labs Backpack              |
      | Sauce Labs Fleece Jacket         |
      |Test.allTheThings() T-Shirt (Red) |
