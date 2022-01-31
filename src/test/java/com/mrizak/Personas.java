package com.mrizak;

import java.util.List;

public class Personas {
    public static final Disposition HORIZONTAL_BLINKER = new Disposition(List.of(
            new Coordinates(3, 4),
            new Coordinates(3, 5),
            new Coordinates(3, 6)
    ));

    public static final Disposition VERTICAL_BLINKER = new Disposition(List.of(
            new Coordinates(2, 5),
            new Coordinates(3, 5),
            new Coordinates(4, 5)
    ));
}
