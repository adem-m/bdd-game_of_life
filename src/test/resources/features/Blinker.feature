Feature: A blinker is a period-2 oscillator

  Scenario Outline: Blinker is oscillating
    Given a <start> blinker
    When I run a new generation
    Then I should have a <result> blinker

  Examples:
    | start      | result     |
    | horizontal | vertical   |
    | vertical   | horizontal |