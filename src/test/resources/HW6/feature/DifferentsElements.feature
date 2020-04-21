Feature: Different elements page feature

  Scenario: I click checkboxes and corresponding logs should appear
    Given I am on the Main Page
    Then Page title is equal to 'Home Page'
    And I perform login with 'Roman' and 'Jdi1234'
    Then I can see my name 'ROMAN IOVLEV' on the top left side of the screen
    Then I click on 'Service' tab on the Header menu
    When I click the link 'DIFFERENT ELEMENTS' in Service dropdown
    When I click checkbox Wind on the Elements page
    When I click checkbox Water on the Elements page
    When I select radiobutton Selen on the Elements page
    When I select 'Yellow' in colors dropdown
    And Log row should be for each selected value on the log panel
