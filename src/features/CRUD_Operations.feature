Feature: CRUD operations
  This feature will help users to understand the CRUD operations of api.

  Scenario: Testing valid GET endpoint
    Given url 'https://jsonplaceholder.typicode.com'
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint
    Given url 'https://jsonplaceholder.typicode.com'
    When method GET
    Then status 200
    And match $ == {id:"1234",name:"John Smith"}