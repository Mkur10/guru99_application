@payment
Feature: Payment Gateway Purchase Flow

  Scenario: Successful toy purchase using generated card
    Given User navigates to Purchase Page
    When User selects quantity "1" and clicks Buy Now
    And User generates a new card
    And User enters card details and makes payment
    Then User should see payment success message "Payment successfull!"
    And User should see an Order ID
