@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User Should verify the status code is 200
    And User Should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Raj        | Khundra   | 1234567898 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

  Scenario Outline: Verify update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for update new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User Should verify the status code is 200
    And User Should verify the updateUserAddress  response message matches "Address Updated Successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Senthil    | Nathan    | 7010681632 | MVEEG     |    33 |  101 |     100 |  600042 | Chennai | home         |

  Scenario Outline: Verify Get user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    And User send "GET" request for getUserAddress endpoint
    Then User Should verify the status code is 200
    And User Should verify the GetUserAddress response message matches "OK"

  Scenario Outline: Verify delete address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for delete the address "<address_id>"
    When User send "DELETE" request for deleteAddress endpoint
    Then User Should verify the status code is 200
    And User Should verify the deleteUserAddress  response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |       5603 |
