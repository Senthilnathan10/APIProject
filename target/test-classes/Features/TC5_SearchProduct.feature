@SearchProduct
Feature: SearchProuct Module Api Automation

  Scenario Outline: Verify SearchProduct to the application through api
    Given User add headders for SearchProduct
    When User add request body for SearchProduct "<productName>"
    And User send "POST" request for SearchProduct endpoint
    Then User Should verify the status code is 200
    And User Should verify SearchProduct response message matches "OK"

    Examples: 
      | productName |
      | nuts        |
