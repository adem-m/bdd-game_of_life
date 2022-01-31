package com.mrizak;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Grid grid = Grid.create(10, new StandardRules());
        grid.applyInitialDisposition(new Disposition(List.of(
                new Coordinates(3, 4),
                new Coordinates(3, 5),
                new Coordinates(3, 6)
        )));
        grid.display();
        grid.nextGeneration();
        grid.display();
        grid.nextGeneration();
        grid.display();
        grid.nextGeneration();
    }
}
