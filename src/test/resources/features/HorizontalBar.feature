Feature: Horizontal bar

#    - - - - -
#    - - - - - 
#    - X X X -
#    - - - - -
#    - - - - -

    Scenario: Horizontal bar definition 
        Given the starting grid
        Then the grid points should have the following values
            | coordinates | status  |
            | 0,0         | DEAD    |
            | 0,1         | DEAD    |
            | 0,2         | DEAD    |
            | 0,3         | DEAD    |
            | 0,4         | DEAD    |
            | 1,0         | DEAD    |
            | 1,1         | DEAD    |
            | 1,2         | DEAD    |
            | 1,3         | DEAD    |
            | 1,4         | DEAD    |
            | 2,0         | DEAD    |
            | 2,1         | ALIVE   |
            | 2,2         | ALIVE   |
            | 2,3         | ALIVE   |
            | 2,4         | DEAD    |
            | 3,0         | DEAD    |
            | 3,1         | DEAD    |
            | 3,2         | DEAD    |
            | 3,3         | DEAD    |
            | 3,4         | DEAD    |
            | 4,0         | DEAD    |
            | 4,1         | DEAD    |
            | 4,2         | DEAD    |
            | 4,3         | DEAD    |
            | 4,4         | DEAD    |

