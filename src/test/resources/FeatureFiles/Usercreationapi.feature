Feature: Get user information by api response

  @GetUserinfo
  Scenario: User calls the web service to get a user information
    Given user get api to receive response from server
    When user send the request to the server
    Then verify if the status code is
    And also verify the name and id
    
   @CreateUser
   Scenario: User send the request to create an user
   Given User have a name and job title to create user
   When the user send request to create user with params
   Then to verify that id generated to newly created user
   And verify the if the status code
   And verify the json reponse
    