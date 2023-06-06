@City
Feature: CityList Module Api Automation

  Scenario Outline: Verify user get citylist through api
    Given User add headders for citylist
    When User add request body to get cityid "<stateId>"
    And User send "POST" request for citylist endpoint
    Then User Should verify the status code is 200
    And User Should verify citylist response message matches "Yercaud" and save city id

    Examples: 
      | stateId |
      |      35 |
