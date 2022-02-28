package com.mrizak;

import java.util.List;

public class StartingGrid {
    public static final Disposition HORIZONTAL_BAR = new Disposition(List.of(
        new Coordinates(2, 1),
        new Coordinates(2, 2),
        new Coordinates(2, 3)
    ));

    public static final Disposition VERTICAL_BAR = new Disposition(List.of(
        new Coordinates(1, 2),
        new Coordinates(2, 2),
        new Coordinates(3, 2)
    ));

    public Grid grid = Grid.create(5, new StandardRules());;

    public StartingGrid() {
        this.grid.applyInitialDisposition(StartingGrid.HORIZONTAL_BAR);
    }
}
