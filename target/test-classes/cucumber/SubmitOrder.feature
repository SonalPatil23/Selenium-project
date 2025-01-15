@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file.

Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product <productName> to cart
    And Checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message displayed on confirmationPage

    Examples: 
      | name              | password    | productName      |
      | anshika@gmail.com | Iamking@000 | ADIDAS ORIGINAL |

     
