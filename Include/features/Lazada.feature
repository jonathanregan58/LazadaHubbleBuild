Feature: Lazada
 
    
     @Lazada
  Scenario: Test Lazada
     Given User is on Home Page of Lazada
     When User searches for "Logitech Keyboard"
     And User choose price range between "100000" to "3000000"
     And User choose to sort from lowest to highest
     Then User is able to get item name from page 1 to page 3