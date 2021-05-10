Feature: To verify that jquery page controlgroup functionalities

    I want to perform group multiple buttons into the one visual sets

    @Controlgroup
    Scenario: To verify that groupd multiple buttons into the visual set
    Given User should be able to see home page
    And Check that controlgroup link is clickable
    When the user clicks on the controlgroup link 
    And User should navigate to the next controlgroup page
    And User book the rental car as per need
    Then Verify the selected element is highlight