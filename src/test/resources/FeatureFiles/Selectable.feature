Feature: To verify that jquery page Selectable functionalities

    I want to perform multi select action to items list

     @Selectable
    Scenario: To verify that multi select item from the list
    Given User should be able to see home page
    And Check that the selectable link is clickable
    When the user clicks on the selectable link 
    And User should navigate to the next selectable page
    And User multi select the items from the item list
    Then background color of the items list should be change