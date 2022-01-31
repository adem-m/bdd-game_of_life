package com.mrizak;

import java.util.ArrayList;
import java.util.List;

public final class Disposition {
    public final static Disposition EMPTY_MAP = new Disposition(new ArrayList<>());

    private final List<Coordinates> coordinates;

    public Disposition(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
}
