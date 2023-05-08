Feature: Product Data
  As an admin
  I want to see list of data product
  So that I can check existing data product

  Scenario: POST PRODUCT create a new product
    Given Iam setting endpoint for product
    When I send HTTP request to post valid data product
    Then I get status code 200
    And iam seeing new detail product

  Scenario: GET - As a user I want to get all product
    Given Iam setting endpoint for product
    When i send request HTTP get all product
    Then I get status code 200
    And I can see all product

  Scenario: DELETE PRODUCT I want to delete a product
    Given i set endpoint for delete product
    When i send request for delete product
    Then I get status code 200
    And I receive valid data for deleting product

  Scenario: GET  want to see product comments
    Given I set the endpoint for product comment
    When I send HTTP request for product comment
    Then I get status code 200
    And I receive valid data for product comment
