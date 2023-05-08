Feature: As user i want to test order on website

  Scenario: POST ORDER I want to make a new order
    Given I set endpoint to order
    And I success login and going to order
    When I input token authorization
    Then user see status code 200 and new order response

  Scenario: GET - As a user I want to list all my order
    Given I set endpoint to order
    When I send request to endpoint order
    When I input token authorization
    Then I see status code 200 and user show list of the order