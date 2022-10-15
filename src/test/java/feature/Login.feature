Feature: Login feature Scenario

  Background: 
    Given I have launched the application

  @sanity
  Scenario: This scenario is to define the login happy path
    And I enter the correct username and password
    And I click on the Login Button
    Then I should land on the home page

  @sanity
  Scenario: This scenario is to define the failure path
    When I enter the incorrect username and password
    And I click on the Login Button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"

  @regression
  Scenario: This sceanrio is to define the success path
    When I enter the username as "standard_user" and Password as "secret_sauce"
    And I click on the Login Button
    Then I should land on the home page

  @regression
  Scenario Outline: This sceanrio is to define the failure path
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName | Password |
      | standard | test     |
      | user     | test123  |
