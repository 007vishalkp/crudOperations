@CRUDoperations
Feature: CRUD operations
  This feature will help users to understand the CRUD operations of api.

  @createapicall
  Scenario Outline: Creating a new record in the database
    Given We have the "<api>" url
    When A record is created "<status>"
    Then The response <code> is shown
    Examples:
      | api  | status     | code |
      | POST | successful | 201  |
#      | POST | unsuccessful | 500  | #No failure scenario since api is accepting null value.

  @updateapicall
  Scenario Outline: Updating an existing record in the database.
    Given We have the "<api>" url
    When A <record> is updated "<status>"
    Then The response <code> is shown
    Examples:
      | api | status       | code | record |
      | PUT | successful   | 200  | 10     |
      | PUT | unsuccessful | 500  | 400    |

  @readapicall
  Scenario Outline: Accessing the details from the database, of a particular record.
    Given We have the "GET" url
    Then We can access the details of the <record> successfully
    Examples:
      | record |
      | 9      |
      | 2      |

  @deleteapicall
  Scenario Outline: Deleting a particular record from the database
    Given We have the "DELETE" url
    Then We can delete the <record> successfully
    Examples:
      | record |
      | 5      |
      | 7      |