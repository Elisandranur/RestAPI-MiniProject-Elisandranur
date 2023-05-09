Feature: Authentication for login and register

  Scenario: Authentication VALID Login account
    Given I set endpoint for login
    When Iam send POST HTTP request for valid data
    Then seeing status code 200
    And get validation data and token

  Scenario: Authen for Login with INVALID INPUT
    Given I set endpoint for login
    When Iam send POST HTTP request for invalid data
    Then get the status code 400
    And get error message for failed login

    @REGISTER
  Scenario: Register with valid data input
      Given Iam set endpoint for register
      When I send created account with valid data input
      Then get status code 200 after send register
      And I see new detail account

  Scenario: Register with invalid data input
    Given Iam set endpoint for register
    When I send HTTP request with empty FULLNAME data register
    Then I see status code 400