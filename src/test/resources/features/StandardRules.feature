Feature: Applying the standard game rules

    Scenario Outline: Decide whether a cell dies or lives
        Given a cell that is <initial> with <num> neighbours
        When I apply the standard game rules
        Then the cell should be <next>

    Examples:
        | initial | num | next |
        | alive   | 0   | dead  |
        | alive   | 1   | dead  |
        | alive   | 2   | alive |
        | alive   | 3   | alive |
        | alive   | 4   | dead  |
        | alive   | 5   | dead  |
        | alive   | 6   | dead  |
        | alive   | 7   | dead  |
        | alive   | 8   | dead  |
        | dead    | 0   | dead  |
        | dead    | 1   | dead  |
        | dead    | 2   | dead  |
        | dead    | 3   | alive |
        | dead    | 4   | dead  |
        | dead    | 5   | dead  |
        | dead    | 6   | dead  |
        | dead    | 7   | dead  |
        | dead    | 8   | dead  |
