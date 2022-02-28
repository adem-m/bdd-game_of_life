package com.mrizak;

import java.util.List;

public class StartingGrid {
    private Disposition horizontalBar = new Disposition(List.of(
        new Coordinates(2, 1),
        new Coordinates(2, 2),
        new Coordinates(2, 3)
    ));

    public Grid grid = Grid.create(5, new StandardRules());;

    public StartingGrid() {
        this.grid.applyInitialDisposition(horizontalBar);
    }
}
