Feature: Blinker
  A blinker is a 2-period oscillator.

#    - - - - -       - - - - -      - - - - -
#    - - - - -       - - X - -      - - - - -
#    - X X X -   ->  - - X - -  ->  - X X X - 
#    - - - - -       - - X - -      - - - - -
#    - - - - -       - - - - -      - - - - -

  Background:
    Given the starting grid

  Scenario: first generation
    Given 0 generations have been produced
    When the next generation is produced
    Then the blinker should be vertical 

#    - - - - -
#    - - X - - 
#    - - X - -
#    - - X - -
#    - - - - -

  Scenario: second generation
    Given 1 generation has been produced
    When the next generation is produced
    Then the blinker should be horizontal

#    - - - - -
#    - - - - - 
#    - X X X -
#    - - - - -
#    - - - - -

  Scenario: third generation
    Given 2 generations have been produced
    When the next generation is produced
    Then the blinker should be vertical 

#    - - - - -
#    - - X - - 
#    - - X - -
#    - - X - -
#    - - - - -