package com.mrizak;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Grid grid = Grid.create(5, new StandardRules());
        grid.applyInitialDisposition(new Disposition(List.of(
                new Coordinates(2, 1),
                new Coordinates(2, 2),
                new Coordinates(2, 3)
        )));
        grid.display();
        grid.nextGeneration();
        grid.display();
        grid.nextGeneration();
        grid.display();
        grid.nextGeneration();
    }
}
