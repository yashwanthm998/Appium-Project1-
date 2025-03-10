Feature: Customer Side Flow

  Scenario: Customer purchase a product
    Given User is on Home page
    When User enters "prepUser@gmail.com" and "Prep@1234" to Login
    And User searches for "minyak" on search bar
    And User adds the product to cart
    And Confirming order using API
    Then User verifies the order ID
