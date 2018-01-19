Feature: Simulation features of a basic snookermatch
  Scenario: Simulate a match of 3 frames
    Given A new match for player John Higgins Vs Mark Williams on the best of 3
    When The current player scores consecutive 1,7,1,7,1,6,1
    Then His score will be 24
    And There are 115 point left
    And His current break will be 24
    When The other player is on play
    And The current player scores consecutive 1
    Then His current break will be 1
    And The current score will be 24 Vs 1
    And There are 107 point left
    When A new frame is started
    Then The match will be 1 Vs 0 frames
    And The current player scores consecutive 1,6
    And The other player is on play
    And The current player scores consecutive 1,6,1,4,1,6,1,7
    Then His current break will be 27
    When A new frame is started
    Then The match will be 1 Vs 1 frames






