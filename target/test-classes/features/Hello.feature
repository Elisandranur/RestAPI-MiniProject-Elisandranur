Feature: As user I want to test index page hello

  Scenario: GET HELLO  want to test hello index page
    Given Iam setting endpoint for hello
    When Iam send request endpoint
    And I could see status code 200
    Then I saw show hello message