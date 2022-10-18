Feature: To add a product to cart and product name passed via feature

  Background: 
    Given I have launched the application
    When I enter the correct username and password
    And I click on the Login Button
    Then I should land on the home page

  @sanity
  Scenario: This scenario is to successfully add one product to the cart
    When I am adding "Sauce Labs Backpack" to the cart
    Then The product is added to cart
    And Item number changed to "1"

  @sanity
  Scenario: This scenario is to add multiple products to the cart in one session
    When I am adding below products to the cart
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    Then Item number changed to "2"

  @regression
  Scenario Outline: This scenario is to add multiple products to the cart in multiple sessions
    When I am adding "<Product_Name>" to the cart
    Then The product with "<Product_Name>" is added to cart
    And Item number changed to "1"

    Examples: 
      | Product_Name             |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
