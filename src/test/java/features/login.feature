Feature: Login to Swag Lab website
  @test
  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then User proceeds to Products page

    Examples:
      | username       | password     |
      | standard_user  | secret_sauce |
      | problem_user   | secret_sauce |
  @test
  Scenario Outline: Login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then give me error message: Epic sadface: Username and password do not match any user in this service

    Examples:
      | username        | password     |
      | secret_sauce      | wrong_pass   |
      | standard_user   | wrong_pass   |
  @test
  Scenario Outline: Login with empty credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then give me error message:Epic sadface: Username is required

    Examples:
      | username | password |
      |          |          |
  @test
  Scenario Outline: Login with empty password
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then give me error message:Epic sadface: Password is required

    Examples:
      | username      | password |
      | standard_user |          |





