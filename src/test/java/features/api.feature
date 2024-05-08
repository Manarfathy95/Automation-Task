Feature: API Activity Testing

  Scenario: verify the api response code and schema when send valid data
    When a user sends a GET request to the API
    Then the response code should be 200
    And  the response should match the schema

