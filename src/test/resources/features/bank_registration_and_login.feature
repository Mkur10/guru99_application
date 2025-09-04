@bank
Feature: Bank Registration and Login

  Scenario: User registers and logs in successfully
    Given User navigates to Bank Home Page
    When User clicks on registration link
    And User enters email "testuser123@example.com"
    And User submits registration
    Then User should get User ID and Password
    Given User is on Bank Login Page
    When User logs in with generated credentials
    Then User should see welcome message containing "Manger"
    And User logs out
