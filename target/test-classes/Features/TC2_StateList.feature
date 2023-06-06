@State
Feature: State Module API Automation
Scenario: Verify User Get StateList through api
Given User add headers for Statelist
When User send "GET" request for statelist endpoint
Then User Should verify the status code is 200
And User Should verify statelist response message matches "Tamil Nadu" and save state id