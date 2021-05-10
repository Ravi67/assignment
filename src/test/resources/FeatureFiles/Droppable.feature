
Feature: To verify that jquery page droppable functionalities
  
    I want to perform drag and drop action to target

   @Droppable
  Scenario: To verify that square element put on target
    Given User should be able to see home page
    And Check that the droppable link is clickable
    When the user clicks on the droppable link 
    And User should navigate to the next page 
    And Able to drag and drop the square element to destination
    Then verify the dropped message appears 
    And also check background should be yellow visible
    
