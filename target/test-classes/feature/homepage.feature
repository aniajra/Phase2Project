Feature: To add a product to cart and product name passed via feature

  Background: 
    Given I have launched the application
    And I enter the correct username and password
    And I click on the Login Button
    Then I should land on the home page

  Scenario: This scenario is to successfully add a product "Sauce Labs Backpack" to card
    And I am adding "sauce-labs-backpack" to the cart
    Then The product is added to cart
    And Item number changed to "1"

  Scenario Outline: This scenario is to add multiple products to the card
    And I am adding "<Product_Name>" to the cart
    Then The product is added to cart
    And Item number changed to "<item_number>"

    Examples: 
      | Product_Name             | item_number |
      | sauce-labs-bike-light    |           1 |
      | sauce-labs-fleece-jacket |           1 |

  Scenario: This scenario is to add multiple products to the card
    And I am adding below product to the cart
      | sauce-labs-bike-light    |
      | sauce-labs-fleece-jacket |
    Then The product is added to cart
    And Item number changed to "2"
