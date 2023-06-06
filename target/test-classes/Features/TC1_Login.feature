@Login
Feature: Login Module API Automation

  Scenario: Get User Logtoken from login endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User Should verify the status code is 200
    And User Should verify the login repsonse body FirstName present as "Senthil" and get the logtoken
