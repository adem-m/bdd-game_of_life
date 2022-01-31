Feature: A blinker is a period-2 oscillator

  Scenario: Blinker is oscillating
    Given a horizontal blinker
    When I run a new generation
    Then I should have a vertical blinker